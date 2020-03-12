package com.oms.api.request;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import java.util.List;

/**
 * @author pengfeng
 * @date 2020-03-12 19:48
 */

@Data
public class GoodsCarAddRequest {

    @NotEmpty(message = "商品Id不能为空")
    private List<Long> goodsId;
}
