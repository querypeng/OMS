package com.oms.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.oms.api.request.AddAddressRequest;
import com.oms.dao.domain.Address;

/**
 * @author pengfeng
 * @date 2020-03-12 13:43
 */
public interface AddressService extends IService<Address> {

    void addAddress(AddAddressRequest request);
}
