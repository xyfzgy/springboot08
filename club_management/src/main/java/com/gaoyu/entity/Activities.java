package com.gaoyu.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 社团活动表
 * @TableName activities
 */
@TableName(value ="activities")
@Data
public class Activities implements Serializable {
    /**
     * 活动ID
     */
    @TableId(type = IdType.AUTO)
    private Integer activityId;

    /**
     * 主办社团ID
     */
    private Integer clubId;

    /**
     * 活动主题
     */
    private String title;

    /**
     * 开始时间
     */
    private Date startTime;

    /**
     * 结束时间
     */
    private Date endTime;

    /**
     * 活动地点
     */
    private String location;

    /**
     * 最大参与人数
     */
    private Integer maxParticipants;

    /**
     * 状态
     */
    private Object status;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}