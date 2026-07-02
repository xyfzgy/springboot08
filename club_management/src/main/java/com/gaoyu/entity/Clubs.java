package com.gaoyu.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.math.BigDecimal;
import lombok.Data;

/**
 * 社团信息表
 * @TableName clubs
 */
@TableName(value ="clubs")
@Data
public class Clubs implements Serializable {
    /**
     * 社团ID
     */
    @TableId(type = IdType.AUTO)
    private Integer clubId;

    /**
     * 社团名称
     */
    private String clubName;

    /**
     * 社长学号
     */
    private String presidentId;

    /**
     * 当前剩余经费
     */
    private BigDecimal budget;

    /**
     * 社团简介
     */
    private String description;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}