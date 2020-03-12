package com.oms.dao.domain;

import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Data
@Table(name = "order")
public class Order {
    /**
     * 主键Id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 商品Id
     */
    @Column(name = "goods_id")
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
    @Column(name = "creat_time")
    private Date creatTime;

    /**
     * openId
     */
    @Column(name = "open_id")
    private String openId;

    private String remark;


}