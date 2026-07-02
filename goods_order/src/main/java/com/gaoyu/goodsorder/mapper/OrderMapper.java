package com.gaoyu.goodsorder.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.gaoyu.goodsorder.entity.Order;
import org.apache.ibatis.annotations.Mapper;

/** 订单 Mapper */
@Mapper
public interface OrderMapper extends BaseMapper<Order> {
}