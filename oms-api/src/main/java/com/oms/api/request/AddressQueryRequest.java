package com.oms.api.request;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

/**
 * @author pengfeng
 * @date 2020-03-12 16:13
 */
@Data
public class AddressQueryRequest implements Serializable {

    @NotBlank(message = "openId不能为空")
    private String openId;
}
