package com.oms.api.request;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import java.util.List;

/**
 * @author pengfeng
 * @date 2020-03-12 19:42
 */
@Data
public class GoodsCarDeleteRequest {

    @NotEmpty(message = "Id不能为空")
    private List<Long> orderIds;
}
