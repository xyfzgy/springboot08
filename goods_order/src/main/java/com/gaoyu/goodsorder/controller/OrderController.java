package com.gaoyu.goodsorder.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.gaoyu.goodsorder.common.Result;
import com.gaoyu.goodsorder.entity.Goods;
import com.gaoyu.goodsorder.entity.Order;
import com.gaoyu.goodsorder.service.GoodsService;
import com.gaoyu.goodsorder.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 订单管理 Controller
 *
 * 订单的业务逻辑比商品复杂：
 * - 下单时要校验商品是否存在、库存是否充足
 * - 要计算总金额 = 商品单价 × 购买数量
 * - 要自动生成订单编号
 */
@RestController
@RequestMapping("/api/orders")
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;
    private final GoodsService goodsService;

    /** 订单编号计数器（简化版，生产环境建议用 Redis 或数据库序列） */
    private final AtomicInteger counter = new AtomicInteger(0);

    /** 查询订单列表（支持按状态筛选） */
    @GetMapping
    public Result<List<Order>> list(
            @RequestParam(required = false) Integer status) {

        LambdaQueryWrapper<Order> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(status != null, Order::getStatus, status)
                .orderByDesc(Order::getCreateTime);  // 最新的订单排前面

        return Result.success(orderService.list(wrapper));
    }

    /** 查询订单详情 */
    @GetMapping("/{id}")
    public Result<Order> detail(@PathVariable Long id) {
        Order order = orderService.getById(id);
        if (order == null) {
            return Result.fail(404, "订单不存在");
        }
        return Result.success(order);
    }

    /**
     * 下单（创建订单）
     *
     * POST /api/orders
     * 请求体：
     * {
     *   "goodsId": 1,
     *   "quantity": 2,
     *   "remark": "送到公司前台"
     * }
     *
     * 下单逻辑：
     * 1. 校验商品是否存在且在售
     * 2. 校验库存是否充足
     * 3. 计算总金额
     * 4. 生成订单编号
     * 5. 保存订单
     */
    @PostMapping
    public Result<Order> create(@RequestBody Order order) {
        // ---- 1. 校验商品 ----
        if (order.getGoodsId() == null) {
            return Result.fail(400, "请选择商品");
        }
        Goods goods = goodsService.getById(order.getGoodsId());
        if (goods == null) {
            return Result.fail(404, "商品不存在");
        }
        if (goods.getStatus() == 0) {
            return Result.fail(400, "该商品已下架，无法下单");
        }

        // ---- 2. 校验库存 ----
        int quantity = order.getQuantity() != null ? order.getQuantity() : 1;
        if (quantity <= 0) {
            return Result.fail(400, "购买数量必须大于0");
        }
        if (goods.getStock() < quantity) {
            return Result.fail(400, "库存不足，当前库存：" + goods.getStock());
        }

        // ---- 3. 计算总金额 ----
        order.setQuantity(quantity);
        order.setTotalPrice(goods.getPrice().multiply(java.math.BigDecimal.valueOf(quantity)));

        // ---- 4. 生成订单编号 ----
        // 格式：ORD + 日期 + 3位序号，如 ORD20260627001
        String datePart = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMdd"));
        String orderNo = "ORD" + datePart + String.format("%03d", counter.incrementAndGet());
        order.setOrderNo(orderNo);

        // ---- 5. 设置默认值并保存 ----
        order.setStatus(0);  // 新订单默认"待付款"

        orderService.save(order);
        return Result.success("下单成功", order);
    }

    /**
     * 更新订单状态
     *
     * PUT /api/orders/1
     * 请求体：
     * { "status": 1 }
     *
     * 订单状态流转：待付款(0) → 已付款(1) → 已发货(2) → 已完成(3)
     *                                       ↘ 已取消(4)
     */
    @PutMapping("/{id}")
    public Result<Order> update(@PathVariable Long id, @RequestBody Order order) {
        Order existing = orderService.getById(id);
        if (existing == null) {
            return Result.fail(404, "订单不存在");
        }

        // 简单的状态校验：已完成的订单不能改
        if (existing.getStatus() == 3) {
            return Result.fail(400, "订单已完成，无法修改");
        }
        // 已取消的订单不能改
        if (existing.getStatus() == 4) {
            return Result.fail(400, "订单已取消，无法修改");
        }

        order.setId(id);
        orderService.updateById(order);
        return Result.success("订单更新成功", order);
    }

    /** 取消订单（逻辑删除） */
    @DeleteMapping("/{id}")
    public Result<Void> delete(@PathVariable Long id) {
        Order existing = orderService.getById(id);
        if (existing == null) {
            return Result.fail(404, "订单不存在");
        }

        orderService.removeById(id);
        return Result.success("订单取消成功", null);
    }
}