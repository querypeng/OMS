package com.oms.dao.domain;

import lombok.Data;

import javax.persistence.*;

@Data
@Table(name = "address")
public class Address {
    /**
     * 主键Id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
    @Column(name = "open_id")
    private String openId;

}