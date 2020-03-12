package com.oms.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.oms.api.request.GoodsCarQueryRequest;
import com.oms.api.response.GoodsCarVO;
import com.oms.dao.OrderMapper;
import com.oms.dao.entity.Order;
import com.oms.service.OrderService;
import com.oms.shared.beans.WrapperBeanCopier;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author pengfeng
 * @date 2020-03-12 18:46
 */
@Service
public class OrderServiceImpl extends ServiceImpl<OrderMapper, Order> implements OrderService {

    @Override
    public List<GoodsCarVO> queryGoodsCar(GoodsCarQueryRequest request) {
        return this.getBaseMapper().queryGoodsCar(request.getOpenId());
    }
}
