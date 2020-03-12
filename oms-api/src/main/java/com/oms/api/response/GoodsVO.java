package com.oms.api.response;

import lombok.Data;

/**
 * @author pengfeng
 * @date 2020-03-12 16:54
 */
@Data
public class GoodsVO {

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
