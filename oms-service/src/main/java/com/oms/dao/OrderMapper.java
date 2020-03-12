package com.oms.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.oms.api.response.GoodsCarVO;
import com.oms.dao.entity.Order;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface OrderMapper extends BaseMapper<Order> {

    List<GoodsCarVO> queryGoodsCar(@Param("openId") String openId);
}