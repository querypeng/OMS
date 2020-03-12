package com.oms.dao.domain;

import lombok.Data;

import javax.persistence.*;

@Data
@Table(name = "goods")
public class Goods {
    /**
     * 主键Id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 商品名称
     */
    @Column(name = "goods_name")
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
    private byte[] picture1;

    /**
     * 图2
     */
    private byte[] picture2;

    /**
     * 图3
     */
    private byte[] pictrue3;


}