package com.oms.dao.entity;


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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPicture1() {
        return picture1;
    }

    public void setPicture1(String picture1) {
        this.picture1 = picture1;
    }

    public String getPicture2() {
        return picture2;
    }

    public void setPicture2(String picture2) {
        this.picture2 = picture2;
    }

    public String getPicture3() {
        return picture3;
    }

    public void setPicture3(String picture3) {
        this.picture3 = picture3;
    }
}