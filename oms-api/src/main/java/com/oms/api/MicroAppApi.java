package com.oms.api;


import com.oms.api.request.AddressAddRequest;
import com.oms.api.request.AddressDeleteRequest;
import com.oms.api.request.AddressQueryRequest;
import com.oms.api.request.AddressUpdateRequest;
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
    @ApiOperation("添加地址")
    ResponseEntity addAddress(AddressAddRequest request);

    /**
     * 编辑地址
     *
     * @param request
     * @return
     */
    @PostMapping(value = "/update/address")
    @ApiOperation("编辑地址")
    ResponseEntity editAddress(AddressUpdateRequest request);

    /**
     * 删除地址
     *
     * @param request
     * @return
     */
    @PostMapping(value = "/delete/address")
    @ApiOperation("删除地址")
    ResponseEntity deleteAddress(AddressDeleteRequest request);

    /**
     * 查询地址列表
     *
     * @param request
     * @return
     */
    @PostMapping(value = "/query/address")
    @ApiOperation("查询地址列表")
    ResponseEntity queryAddress(AddressQueryRequest request);


}