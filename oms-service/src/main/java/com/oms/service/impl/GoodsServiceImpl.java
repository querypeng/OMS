package com.oms.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.baomidou.mybatisplus.extension.toolkit.ChainWrappers;
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
        List<Goods> goodsList = ChainWrappers.lambdaQueryChain(goodsMapper).list();
        return WrapperBeanCopier.convert(goodsList, GoodsVO.class);
    }
}
