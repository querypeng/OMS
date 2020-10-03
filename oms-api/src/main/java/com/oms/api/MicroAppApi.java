package com.oms.api;


import com.oms.api.request.*;
import com.oms.api.response.AddressListVO;
import com.oms.api.response.GoodsVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;


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
    @PostMapping(value = "/address/add")
    @ApiOperation("添加地址")
    ResponseEntity addAddress(AddressAddRequest request);

    /**
     * 编辑地址
     *
     * @param request
     * @return
     */
    @PostMapping(value = "/address/update")
    @ApiOperation("编辑地址")
    ResponseEntity editAddress(AddressUpdateRequest request);

    /**
     * 删除地址
     *
     * @param request
     * @return
     */
    @PostMapping(value = "/address/delete")
    @ApiOperation("删除地址")
    ResponseEntity deleteAddress(AddressDeleteRequest request);

    /**
     * 查询地址列表
     *
     * @param request
     * @return
     */
    @PostMapping(value = "/address/query")
    @ApiOperation("查询地址列表")
    ResponseEntity<List<AddressListVO>> queryAddress(AddressQueryRequest request);

    /**
     * 查看商品列表
     *
     * @return
     */
    @PostMapping(value = "/goods/query")
    @ApiOperation("查询商品列表")
    ResponseEntity<List<GoodsVO>> queryGoods();

    /**
     * 查看购物车
     * @param request
     * @return
     */
    @PostMapping(value = "/goodsCar/query")
    @ApiOperation("查看购物车")
    ResponseEntity queryGoodsCar(GoodsCarQueryRequest request);

    /**
     * 删除购物车商品
     *
     * @return
     */
    @PostMapping(value = "/goodsCar/delete")
    @ApiOperation("删除购物车商品")
    ResponseEntity deleteGoodsCar(GoodsCarDeleteRequest request);

    /**
     * 新增购物车商品
     *
     * @return
     */
    @PostMapping(value = "/goodsCar/add")
    @ApiOperation("新增购物车商品")
    ResponseEntity addGoodsCar(GoodsCarAddRequest request);


}