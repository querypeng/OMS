package com.oms.controller;


import com.oms.api.MicroAppApi;
import com.oms.api.request.AddAddressRequest;
import com.oms.service.AddressService;
import com.oms.shared.exception.ExceptionResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;


/**
 * @author pengfeng
 */
@RestController
public class MicroAppController implements MicroAppApi {

    @Resource
    private AddressService addressService;

    @Override
    public ResponseEntity<ExceptionResponse> addAddress(@Validated @RequestBody AddAddressRequest request) {
        addressService.addAddress(request);
        return new ResponseEntity<>(new ExceptionResponse(200, "success"), HttpStatus.CREATED);
    }
}
