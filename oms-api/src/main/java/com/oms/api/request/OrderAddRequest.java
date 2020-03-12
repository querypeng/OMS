package com.oms.api.request;

import io.swagger.annotations.ApiModel;
import lombok.Data;

/**
 * <pre>
 * Description
 * @author shishi
 * 2020/3/12 18:06
 * </pre>
 */
@ApiModel("订单添加Request")
@Data
public class OrderAddRequest {

    /**
     * 姓名
     */
    private String name;

    /**
     * 手机号
     */
    private String mobile;

    /**
     * 详细地址
     */
    private String address;

    /**
     * 微信openId
     */
    private String openId;
}
