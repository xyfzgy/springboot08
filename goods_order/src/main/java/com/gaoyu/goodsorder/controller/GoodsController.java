package com.gaoyu.goodsorder.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.gaoyu.goodsorder.common.Result;
import com.gaoyu.goodsorder.entity.Goods;
import com.gaoyu.goodsorder.service.GoodsService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 商品管理 Controller
 *
 * @RestController = @Controller + @ResponseBody
 *   表示这个类的所有方法返回值都自动转成 JSON
 *
 * @RequestMapping("/api/goods") 设置统一的 URL 前缀
 *
 * @RequiredArgsConstructor Lombok 注解，自动生成带 final 字段的构造器
 *   等价于手写：public GoodsController(GoodsService goodsService) { ... }
 *   这是"构造器注入"——Spring 推荐的依赖注入方式，比 @Autowired 更优雅
 */
@RestController
@RequestMapping("/api/goods")
@RequiredArgsConstructor
public class GoodsController {

    private final GoodsService goodsService;

    // ==================== 查询 ====================

    /**
     * 查询商品列表（支持条件筛选）
     *
     * GET /api/goods               → 查全部在售商品
     * GET /api/goods?category=数码  → 查数码类商品
     * GET /api/goods?status=0      → 查已下架商品
     *
     * @RequestParam(required = false) 表示这个参数是可选的
     * 不传就不加条件，传了就按条件筛选
     */
    @GetMapping
    public Result<List<Goods>> list(
            @RequestParam(required = false) String category,
            @RequestParam(required = false) Integer status) {

        // LambdaQueryWrapper 是 MyBatis-Plus 的条件构造器
        // 比写 SQL 字符串更安全、更优雅
        LambdaQueryWrapper<Goods> wrapper = new LambdaQueryWrapper<>();

        // condition(条件, 值) —— 条件为 true 时才加这个查询条件
        // 类似 SQL 的 WHERE category = ? AND status = ?
        wrapper.eq(category != null, Goods::getCategory, category)
                .eq(status != null, Goods::getStatus, status)
                .orderByDesc(Goods::getCreateTime);  // 按创建时间倒序，最新商品排前面

        List<Goods> list = goodsService.list(wrapper);
        return Result.success(list);
    }

    /**
     * 查询单个商品详情
     *
     * GET /api/goods/1 → 查 ID 为 1 的商品
     *
     * @PathVariable 从 URL 路径中取参数
     * 比如 /api/goods/1 中的 1 就会被赋值给 id
     */
    @GetMapping("/{id}")
    public Result<Goods> detail(@PathVariable Long id) {
        Goods goods = goodsService.getById(id);
        if (goods == null) {
            return Result.fail(404, "商品不存在");
        }
        return Result.success(goods);
    }

    // ==================== 新增 ====================

    /**
     * 新增商品
     *
     * POST /api/goods
     * 请求体（JSON格式）：
     * {
     *   "name": "机械键盘 K8 Pro",
     *   "category": "数码",
     *   "price": 499.00,
     *   "stock": 200,
     *   "status": 1,
     *   "description": "87键热插拔，RGB背光"
     * }
     *
     * @RequestBody 把请求体中的 JSON 自动转成 Java 对象
     */
    @PostMapping
    public Result<Goods> create(@RequestBody Goods goods) {
        // 参数校验：商品名称和分类不能为空
        if (goods.getName() == null || goods.getName().trim().isEmpty()) {
            return Result.fail(400, "商品名称不能为空");
        }
        if (goods.getCategory() == null || goods.getCategory().trim().isEmpty()) {
            return Result.fail(400, "商品分类不能为空");
        }
        if (goods.getPrice() == null) {
            return Result.fail(400, "商品价格不能为空");
        }

        // 新增商品默认在售状态
        if (goods.getStatus() == null) {
            goods.setStatus(1);
        }
        if (goods.getStock() == null) {
            goods.setStock(0);
        }

        goodsService.save(goods);
        return Result.success("商品添加成功", goods);
    }

    // ==================== 修改 ====================

    /**
     * 更新商品
     *
     * PUT /api/goods/1
     * 请求体（JSON格式，只传要修改的字段即可）：
     * {
     *   "price": 399.00,
     *   "stock": 50
     * }
     */
    @PutMapping("/{id}")
    public Result<Goods> update(@PathVariable Long id, @RequestBody Goods goods) {
        // 先检查商品是否存在
        Goods existing = goodsService.getById(id);
        if (existing == null) {
            return Result.fail(404, "商品不存在");
        }

        // 把 ID 设进去，确保更新的是正确的记录
        goods.setId(id);
        goodsService.updateById(goods);
        return Result.success("商品更新成功", goods);
    }

    // ==================== 删除 ====================

    /**
     * 删除商品（逻辑删除）
     *
     * DELETE /api/goods/1
     *
     * 逻辑删除：不是真的从数据库删掉记录，而是把 deleted 字段改为 1
     * 之后查询时 MyBatis-Plus 会自动加上 WHERE deleted = 0 条件
     * 就像把文件放进回收站，而不是 Shift+Delete
     */
    @DeleteMapping("/{id}")
    public Result<Void> delete(@PathVariable Long id) {
        Goods existing = goodsService.getById(id);
        if (existing == null) {
            return Result.fail(404, "商品不存在");
        }

        goodsService.removeById(id);  // 实际执行的是 UPDATE SET deleted=1
        return Result.success("商品删除成功", null);
    }
}