package com.oms.controller;


import com.oms.api.MicroAppApi;
import com.oms.api.request.*;
import com.oms.api.response.AddressListVO;
import com.oms.api.response.GoodsCarVO;
import com.oms.api.response.GoodsVO;
import com.oms.service.AddressService;
import com.oms.service.GoodsService;
import com.oms.service.OrderService;
import com.oms.shared.exception.Response;
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
    @Resource
    private GoodsService goodsService;
    @Resource
    private OrderService orderService;

    @Override
    public ResponseEntity addAddress(@Validated @RequestBody AddressAddRequest request) {
        addressService.addAddress(request);
        return new ResponseEntity<>(new Response(200, "success"), HttpStatus.OK);
    }

    @Override
    public ResponseEntity editAddress(@Validated @RequestBody AddressUpdateRequest request) {
        addressService.editAddress(request);
        return new ResponseEntity<>(new Response(200, "success"), HttpStatus.OK);
    }

    @Override
    public ResponseEntity deleteAddress(@Validated @RequestBody AddressDeleteRequest request) {
        addressService.deleteAddress(request);
        return new ResponseEntity<>(new Response(200, "success"), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<List<AddressListVO>> queryAddress(@Validated @RequestBody AddressQueryRequest request) {
        List<AddressListVO> addressListVOList = addressService.queryAddress(request);
        return new ResponseEntity<>((List<AddressListVO>) new Response(200, "success", addressListVOList), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<List<GoodsVO>> queryGoods() {
        List<GoodsVO> goodsVOList = goodsService.queryGoods();
        return new ResponseEntity<>((List<GoodsVO>) new Response(200, "success", goodsVOList), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<List<GoodsCarVO>> queryGoodsCar(GoodsCarQueryRequest request) {
        List<GoodsCarVO> goodsCarVOList = orderService.queryGoodsCar(request);
        return new ResponseEntity<>(goodsCarVOList, HttpStatus.OK);
    }


}
