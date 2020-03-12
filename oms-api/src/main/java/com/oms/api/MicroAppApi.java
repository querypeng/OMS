package com.oms.api;


import com.oms.api.request.AddressAddRequest;
import com.oms.api.request.AddressUpdateRequest;
import io.swagger.annotations.Api;
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
    ResponseEntity addAddress(AddressAddRequest request);

    /**
     * 编辑地址
     *
     * @param request
     * @return
     */
    @PostMapping(value = "/update/address")
    ResponseEntity editAddress(AddressUpdateRequest request);

    /**
     * 删除地址
     *
     * @param request
     * @return
     */
    @PostMapping(value = "/delete/address")
    ResponseEntity deleteAddress(AddressUpdateRequest request);


}