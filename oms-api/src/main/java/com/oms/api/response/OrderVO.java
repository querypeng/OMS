package com.oms.api.response;

import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

/**
 * @author pengfeng
 * @date 2020-03-12 19:54
 */
@Data
public class OrderVO {

    private List<GoodsCarVO> goodsCarList;

    private String status;

    private BigDecimal totalAmount;
}
