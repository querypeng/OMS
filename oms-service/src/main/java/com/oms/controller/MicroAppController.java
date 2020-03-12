package com.oms.controller;


import com.oms.api.MicroAppApi;
import com.oms.api.request.AddressAddRequest;
import com.oms.api.request.AddressDeleteRequest;
import com.oms.api.request.AddressQueryRequest;
import com.oms.api.request.AddressUpdateRequest;
import com.oms.api.response.AddressListVO;
import com.oms.service.AddressService;
import com.oms.shared.exception.ExceptionResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;


/**
 * @author pengfeng
 */
@RestController
public class MicroAppController implements MicroAppApi {

    @Resource
    private AddressService addressService;

    @Override
    public ResponseEntity<Boolean> addAddress(@Validated @RequestBody AddressAddRequest request) {
        return new ResponseEntity<>(addressService.addAddress(request), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Boolean> editAddress(@Validated @RequestBody AddressUpdateRequest request) {
        return new ResponseEntity<>(addressService.editAddress(request), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Boolean> deleteAddress(@Validated @RequestBody AddressDeleteRequest request) {
        return new ResponseEntity<>(addressService.deleteAddress(request), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<List<AddressListVO>> queryAddress(@Validated @RequestBody AddressQueryRequest request) {
        return new ResponseEntity<>(addressService.queryAddress(request), HttpStatus.OK);
    }


}
