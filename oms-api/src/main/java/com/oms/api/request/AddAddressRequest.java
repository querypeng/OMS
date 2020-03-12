package com.oms.api.request;

import lombok.Data;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

/**
 * @author pengfeng
 * @date 2020-03-12 13:36
 */
@Data
public class AddAddressRequest {

    @NotBlank(message = "姓名不能为空")
    @Length(max = 30, message = "姓名不超过30个字符")
    private String name;

    @NotBlank(message = "手机号不能为空")
    @Pattern(regexp = "^[1][0-9]{10}$", message = "请输入正确的手机号")
    private String mobile;

    @NotBlank(message = "地址不能为空")
    private String address;

    @NotBlank(message = "openId不能为空")
    private String openId;
}
