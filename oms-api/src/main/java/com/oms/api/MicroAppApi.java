package com.oms.api;


import com.oms.api.request.AddAddressRequest;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


/**
 * @author pengfeng
 */
@Api(tags = "MicroAppApi")
@RequestMapping(value = "/micro")
public interface MicroAppApi {

    /**
     * 添加地址
     *
     * @param request
     * @return
     */
    @PostMapping(value = "/add/address")
    @ApiOperation("获取用户信息")
    ResponseEntity addAddress(AddAddressRequest request);


}