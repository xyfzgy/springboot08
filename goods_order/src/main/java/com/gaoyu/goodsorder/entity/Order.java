package com.gaoyu.goodsorder.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * 订单实体
 */
@Data
@TableName("orders")
@NoArgsConstructor
@AllArgsConstructor
public class Order {

    /**
     * 订单ID（主键自增）
     *
     * 注意：类名是 Order，但表名是 orders
     * 因为 order 是 MySQL 的关键字（ORDER BY），建表时用 orders 避免冲突
     * 所以这里必须用 @TableName("orders") 显式指定表名
     */
    @TableId(type = IdType.AUTO)
    private Long id;

    /** 订单编号（唯一，如 ORD20260627001） */
    private String orderNo;

    /** 关联商品ID */
    private Long goodsId;

    /** 购买数量 */
    private Integer quantity;

    /** 订单总金额 */
    private BigDecimal totalPrice;

    /**
     * 订单状态：0-待付款 1-已付款 2-已发货 3-已完成 4-已取消
     *
     * 订单状态流转：
     * 待付款(0) → 已付款(1) → 已发货(2) → 已完成(3)
     *   ↓
     * 已取消(4)
     */
    private Integer status;

    /** 订单备注 */
    private String remark;

    @TableField(fill = FieldFill.INSERT)
    private LocalDateTime createTime;

    @TableField(fill = FieldFill.INSERT_UPDATE)
    private LocalDateTime updateTime;

    @TableLogic
    private Integer deleted;
}