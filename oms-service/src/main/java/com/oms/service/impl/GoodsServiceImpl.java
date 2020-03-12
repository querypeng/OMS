package com.oms.service.impl;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.oms.api.response.GoodsVO;
import com.oms.dao.GoodsMapper;
import com.oms.dao.domain.Goods;
import com.oms.service.GoodsService;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.ArrayList;
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
        List<Goods> goodsList = goodsMapper.selectList(null);
        if (CollectionUtils.isEmpty(goodsList)) {
            return new ArrayList<>();
        }
        return JSON.parseArray(JSON.toJSONString(goodsList), GoodsVO.class);
    }
}
