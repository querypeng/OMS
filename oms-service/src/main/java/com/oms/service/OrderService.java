package com.oms.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.oms.api.request.GoodsCarAddRequest;
import com.oms.api.request.GoodsCarDeleteRequest;
import com.oms.api.request.GoodsCarQueryRequest;
import com.oms.api.response.OrderVO;
import com.oms.dao.entity.Order;

/**
 * @author pengfeng
 * @date 2020-03-12 18:46
 */
public interface OrderService extends IService<Order> {

    OrderVO queryGoodsCar(GoodsCarQueryRequest request);

    void deleteGoodsCar(GoodsCarDeleteRequest request);

    void addGoodsCar(GoodsCarAddRequest request);
}
