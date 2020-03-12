package com.oms.api.response;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @author pengfeng
 * @date 2020-03-12 18:55
 */
@Data
@Builder
public class GoodsCarVO {

    private String orderNo;

    private String goodsName;

    /**
     * 商品价
     */
    private BigDecimal price;

    private String pictrue1;

    private String pictrue2;

    private String pictrue3;

    /**
     * 副标题
     */
    private String title;

    /**
     * 购物车价
     */
    private BigDecimal carPrice;

    private BigDecimal quantity;

    private Date creatTime;

    private String remark;

}
