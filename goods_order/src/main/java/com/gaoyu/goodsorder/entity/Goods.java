package com.gaoyu.goodsorder.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * 商品实体
 *
 * MyBatis-Plus 的注解说明：
 * @TableName   —— 指定对应的数据库表名（类名和表名一致时可省略）
 * @TableId     —— 标记主键，type = IdType.AUTO 表示自增
 * @TableLogic  —— 标记逻辑删除字段，删除时不真删，而是把 deleted 改为 1
 * @TableField  —— 手动指定字段映射（大部分情况不需要，驼峰自动转换）
 */
@Data
@TableName("goods")
@NoArgsConstructor
@AllArgsConstructor
public class Goods {

    /** 商品ID（主键自增） */
    @TableId(type = IdType.AUTO)
    private Long id;

    /** 商品名称 */
    private String name;

    /** 商品分类（数码、服饰、食品、家居） */
    private String category;

    /** 商品单价 */
    private BigDecimal price;

    /** 库存数量 */
    private Integer stock;

    /** 商品状态：0-下架 1-在售 */
    private Integer status;

    /** 商品描述 */
    private String description;

    /** 创建时间（插入时自动填充） */
    @TableField(fill = FieldFill.INSERT)
    private LocalDateTime createTime;

    /** 更新时间（插入和更新时自动填充） */
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private LocalDateTime updateTime;

    /** 逻辑删除标记：0-正常 1-已删除 */
    @TableLogic
    private Integer deleted;
}