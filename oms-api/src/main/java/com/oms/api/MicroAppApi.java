package com.oms.api;


import com.oms.api.request.AddAddressRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;


/**
 * @author pengfeng
 */
public interface MicroAppApi {

    /**
     * 添加地址
     *
     * @param request
     * @return
     */
    @PostMapping(value = "/add/address")
    ResponseEntity addAddress(AddAddressRequest request);


}