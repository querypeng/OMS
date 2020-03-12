package com.oms.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.oms.api.request.GoodsCarAddRequest;
import com.oms.api.request.GoodsCarDeleteRequest;
import com.oms.api.request.GoodsCarQueryRequest;
import com.oms.api.response.GoodsCarVO;
import com.oms.api.response.OrderVO;
import com.oms.dao.OrderMapper;
import com.oms.dao.entity.Order;
import com.oms.service.OrderService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

/**
 * @author pengfeng
 * @date 2020-03-12 18:46
 */
@Service
public class OrderServiceImpl extends ServiceImpl<OrderMapper, Order> implements OrderService {

    @Override
    public OrderVO queryGoodsCar(GoodsCarQueryRequest request) {

        OrderVO orderVO = new OrderVO();
        List<GoodsCarVO> goodsCarVOList = this.baseMapper.queryGoodsCar(request.getOpenId());
        goodsCarVOList.forEach(e -> {
            e.setCarPrice(e.getCarPrice().divide(new BigDecimal(100), 2, RoundingMode.HALF_UP));
            e.setPrice(e.getPrice().divide(new BigDecimal(100), 2, RoundingMode.HALF_UP));
        });
        orderVO.setTotalAmount(goodsCarVOList.stream().map(GoodsCarVO::getCarPrice).reduce(BigDecimal.ZERO, BigDecimal::add));
        orderVO.setGoodsCarList(goodsCarVOList);
        orderVO.setStatus(goodsCarVOList.stream().anyMatch(e -> e.getStatus().equals(1)) ? "未支付" : "已付款");
        return orderVO;
    }

    @Override
    public Boolean deleteGoodsCar(GoodsCarDeleteRequest request) {
        return this.removeByIds(request.getOrderIds());
    }

    @Override
    public Boolean addGoodsCar(GoodsCarAddRequest request) {
        return this.saveBatch(null);
    }
}
