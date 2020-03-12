package com.oms.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.oms.api.response.GoodsVO;
import com.oms.dao.entity.Goods;

import java.util.List;

/**
 * @author pengfeng
 * @date 2020-03-12 16:49
 */
public interface GoodsService extends IService<Goods> {

    List<GoodsVO> queryGoods();


}
