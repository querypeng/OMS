package com.oms.api.request;

import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * @author pengfeng
 * @date 2020-03-12 18:54
 */
@Data
public class GoodsCarQueryRequest {

    @NotBlank(message = "openId不能为空")
    private String openId;
}
