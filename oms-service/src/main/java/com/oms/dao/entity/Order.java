package com.oms.dao.entity;


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

    private String orderNo;

    private Integer status;

    /**
     * 数量
     */
    private BigDecimal quantity;

    /**
     * 创建时间
     */
    private Date createdTime;

    /**
     * openId
     */
    private String openId;

    private String remark;


}