package com.oms.service.impl;

import com.oms.api.request.AddAddressRequest;
import com.oms.dao.AddressMapper;
import com.oms.dao.domain.Address;
import com.oms.service.AddressService;
import com.oms.shared.exception.BusinessException;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author pengfeng
 * @date 2020-03-12 13:44
 */
@Service
public class AddressServiceImpl implements AddressService {

    @Resource
    private AddressMapper addressMapper;

    @Override
    public void addAddress(AddAddressRequest request) {
        Address address = new Address();
        address.setAddress(request.getAddress());
        address.setMoblie(request.getMobile());
        address.setName(request.getName());
        address.setOpenId(request.getOpenId());
        addressMapper.insert(address);
        throw new BusinessException(1, "错误");
    }
}