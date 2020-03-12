package com.oms.service.impl;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.baomidou.mybatisplus.extension.toolkit.ChainWrappers;
import com.oms.api.request.AddressAddRequest;
import com.oms.api.request.AddressDeleteRequest;
import com.oms.api.request.AddressQueryRequest;
import com.oms.api.request.AddressUpdateRequest;
import com.oms.api.response.AddressListVO;
import com.oms.dao.AddressMapper;
import com.oms.dao.entity.Address;
import com.oms.service.AddressService;
import com.oms.shared.beans.WrapperBeanCopier;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @author pengfeng
 * @date 2020-03-12 13:44
 */
@Service
public class AddressServiceImpl extends ServiceImpl<AddressMapper, Address> implements AddressService {

    @Resource
    private AddressMapper addressMapper;

    @Override
    public Boolean addAddress(AddressAddRequest request) {
        Address address = WrapperBeanCopier.convert(request, Address.class);
        return 1 == addressMapper.insert(address);
    }

    @Override
    public Boolean editAddress(AddressUpdateRequest request) {
        Address address = WrapperBeanCopier.convert(request, Address.class);
        return 1 == addressMapper.updateById(address);
    }

    @Override
    public Boolean deleteAddress(AddressDeleteRequest request) {
        return 1 == addressMapper.deleteById(request.getId());
    }

    @Override
    public List<AddressListVO> queryAddress(AddressQueryRequest request) {

        List<Address> list = ChainWrappers.lambdaQueryChain(addressMapper).eq(Address::getOpenId, request.getOpenId()).list();

        return WrapperBeanCopier.convert(list, AddressListVO.class);
    }
}
