package com.gaoyu.goodsorder.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.gaoyu.goodsorder.entity.Goods;
import org.apache.ibatis.annotations.Mapper;

/**
 * 商品 Mapper
 *
 * 继承 BaseMapper<Goods> 后，自动获得以下方法（不用写一行代码）：
 * - insert(Goods)               插入
 * - deleteById(id)              按ID删除
 * - updateById(Goods)           按ID更新
 * - selectById(id)              按ID查询
 * - selectList(wrapper)         条件查询列表
 * - selectPage(page, wrapper)   分页查询
 * ... 还有更多，但以上这些覆盖了 90% 的场景
 */
public interface GoodsMapper extends BaseMapper<Goods> {
}