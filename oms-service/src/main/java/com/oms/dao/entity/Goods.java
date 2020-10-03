package com.oms.dao.entity;

import lombok.Data;


@Data
public class Goods {
    /**
     * 主键Id
     */
    private Long id;

    /**
     * 商品名称
     */
    private String goodsName;

    /**
     * 价格(元)
     */
    private Long price;

    /**
     * 副标题
     */
    private String title;

    /**
     * 图1
     */
    private String picture1;

    /**
     * 图2
     */
    private String picture2;

    /**
     * 图3
     */
    private String picture3;


}