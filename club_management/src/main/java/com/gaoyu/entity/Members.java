package com.gaoyu.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 社团成员关系表
 * @TableName members
 */
@TableName(value ="members")
@Data
public class Members implements Serializable {
    /**
     * 
     */
    @TableId(type = IdType.AUTO)
    private Integer id;

    /**
     * 学号
     */
    private String studentId;

    /**
     * 社团ID
     */
    private Integer clubId;

    /**
     * 角色
     */
    private Object role;

    /**
     * 加入日期
     */
    private Date joinDate;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}