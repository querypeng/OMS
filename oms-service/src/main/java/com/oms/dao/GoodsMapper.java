package com.oms.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.oms.dao.entity.Goods;
import org.apache.ibatis.annotations.Param;

/**
 * @author pengfeng
 */
public interface GoodsMapper extends BaseMapper<Goods> {

    int insertGoods(@Param("goods") Goods goods);

    int updateCommodity(@Param("goods") Goods goods);

    int deleteCommodity(@Param("id" ) Long id);
}