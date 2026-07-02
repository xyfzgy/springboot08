package com.gaoyu.goodsorder.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.gaoyu.goodsorder.entity.Goods;

/**
 * 商品 Service 接口
 *
 * IService<Goods> 提供的方法比 BaseMapper 更丰富：
 * - save(Goods)                 插入
 * - saveBatch(List<Goods>)      批量插入
 * - removeById(id)              按ID删除
 * - updateById(Goods)           按ID更新
 * - getById(id)                 按ID查询
 * - list()                      查询全部
 * - list(wrapper)               条件查询
 * - page(page, wrapper)         分页查询
 * ...
 */
public interface GoodsService extends IService<Goods> {
}