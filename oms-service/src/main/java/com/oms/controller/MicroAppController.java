package com.oms.controller;


import com.oms.api.MicroAppApi;
import com.oms.api.request.AddressAddRequest;
import com.oms.api.request.AddressDeleteRequest;
import com.oms.api.request.AddressQueryRequest;
import com.oms.api.request.AddressUpdateRequest;
import com.oms.api.request.GoodsCarQueryRequest;
import com.oms.api.response.AddressListVO;
import com.oms.api.response.GoodsCarVO;
import com.oms.api.response.GoodsVO;
import com.oms.dao.entity.Address;
import com.oms.service.AddressService;
import com.oms.service.GoodsService;
import com.oms.service.OrderService;
import com.oms.shared.beans.WrapperBeanCopier;
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
    public ResponseEntity<Boolean> addAddress(@Validated @RequestBody AddressAddRequest request) {
        Address address = WrapperBeanCopier.convert(request, Address.class);
        return ResponseEntity.ok(addressService.save(address));
    }

    @Override
    public ResponseEntity<Boolean> editAddress(@Validated @RequestBody AddressUpdateRequest request) {
        Address address = WrapperBeanCopier.convert(request, Address.class);
        return ResponseEntity.ok(addressService.updateById(address));
    }

    @Override
    public ResponseEntity<Boolean> deleteAddress(@Validated @RequestBody AddressDeleteRequest request) {
        return ResponseEntity.ok(addressService.removeById(request.getId()));
    }

    @Override
    public ResponseEntity<List<AddressListVO>> queryAddress(@Validated @RequestBody AddressQueryRequest request) {
        return ResponseEntity.ok(addressService.queryAddress(request));
    }

    @Override
    public ResponseEntity<List<GoodsVO>> queryGoods() {
        return ResponseEntity.ok(goodsService.queryGoods());
    }

    @Override
    public ResponseEntity<List<GoodsCarVO>> queryGoodsCar(GoodsCarQueryRequest request) {
        return ResponseEntity.ok(orderService.queryGoodsCar(request));
    }


}
