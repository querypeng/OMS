package com.oms.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.oms.api.request.GoodsCarQueryRequest;
import com.oms.api.response.GoodsCarVO;
import com.oms.dao.entity.Order;

import java.util.List;

/**
 * @author pengfeng
 * @date 2020-03-12 18:46
 */
public interface OrderService extends IService<Order> {

    List<GoodsCarVO> queryGoodsCar(GoodsCarQueryRequest request);
}
