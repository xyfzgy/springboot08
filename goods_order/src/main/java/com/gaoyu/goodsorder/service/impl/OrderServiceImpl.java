package com.gaoyu.goodsorder.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.gaoyu.goodsorder.entity.Order;
import com.gaoyu.goodsorder.mapper.OrderMapper;
import com.gaoyu.goodsorder.service.OrderService;
import org.springframework.stereotype.Service;

/** 订单 Service 实现类 */
@Service
public class OrderServiceImpl extends ServiceImpl<OrderMapper, Order> implements OrderService {
}