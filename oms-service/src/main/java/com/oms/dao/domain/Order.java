package com.oms.dao.domain;


import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data
public class Order {
    /**
     * 主键Id
     */
    private Long id;

    /**
     * 商品Id
     */
    private Integer goodsId;

    /**
     * 价格(元)
     */
    private Long price;

    /**
     * 订单状态
     */
    private Integer status;

    /**
     * 数量
     */
    private BigDecimal quantity;

    /**
     * 创建时间
     */
    private Date creatTime;

    /**
     * openId
     */
    private String openId;

    private String remark;


}