package com.oms.api.request;

import lombok.Data;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * @author pengfeng
 * @date 2020-03-12 16:06
 */
@Data
public class AddressDeleteRequest implements Serializable {

    @NotNull(message = "id不能为空")
    private Long id;
}
