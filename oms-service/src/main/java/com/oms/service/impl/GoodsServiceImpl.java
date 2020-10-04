package com.oms.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.oms.api.request.AddCommodityRequest;
import com.oms.api.request.DeleteCommodityRequest;
import com.oms.api.request.UpdateShoppingRequest;
import com.oms.api.response.GoodsVO;
import com.oms.dao.GoodsMapper;
import com.oms.dao.entity.Goods;
import com.oms.service.GoodsService;
import com.oms.shared.beans.WrapperBeanCopier;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author pengfeng
 * @date 2020-03-12 16:50
 */
@Service
public class GoodsServiceImpl extends ServiceImpl<GoodsMapper, Goods> implements GoodsService {

    @Resource
    private GoodsMapper goodsMapper;

    @Override
    public List<GoodsVO> queryGoods() {
        return WrapperBeanCopier.convert(this.list(), GoodsVO.class);
    }

    @Override
    public Boolean addGoods(AddCommodityRequest request) {
        Goods goods = new Goods();
        goods.setTitle(request.getTitle());
        goods.setGoodsName(request.getGoodsName());
        goods.setPrice(request.getPrice());
        goods.setPicture1(request.getPicture1());
        goods.setPicture2(request.getPicture2());
        goods.setPicture3(request.getPicture3());
        int num = goodsMapper.insertGoods(goods);
        return num == 1;
    }

    @Override
    public Boolean updateCommodity(UpdateShoppingRequest request) {
        Goods goods = new Goods();
        goods.setTitle(request.getTitle());
        goods.setGoodsName(request.getGoodsName());
        goods.setPrice(request.getPrice());
        goods.setPicture1(request.getPicture1());
        goods.setPicture2(request.getPicture2());
        goods.setPicture3(request.getPicture3());
        goods.setId(request.getId());
        int num = goodsMapper.updateCommodity(goods);
        return num == 1;
    }

    @Override
    public Boolean deleteCommodity(Long id) {
        int num = goodsMapper.deleteCommodity(id);
        return num == 1;
    }


}
