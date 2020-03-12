package com.oms.dao.domain;

import lombok.Data;


@Data
public class Address {
    /**
     * 主键Id
     */
    private Long id;

    /**
     * 姓名
     */
    private String name;

    /**
     * 手机号
     */
    private String moblie;

    /**
     * 详细地址
     */
    private String address;

    /**
     * 微信openId
     */
    private String openId;

}