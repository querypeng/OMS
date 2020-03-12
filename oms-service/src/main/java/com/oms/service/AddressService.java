package com.oms.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.oms.api.request.AddressAddRequest;
import com.oms.api.request.AddressDeleteRequest;
import com.oms.api.request.AddressQueryRequest;
import com.oms.api.request.AddressUpdateRequest;
import com.oms.api.response.AddressListVO;
import com.oms.dao.entity.Address;

import java.util.List;

/**
 * @author pengfeng
 * @date 2020-03-12 13:43
 */
public interface AddressService extends IService<Address> {

    List<AddressListVO> queryAddress(AddressQueryRequest request);

}
