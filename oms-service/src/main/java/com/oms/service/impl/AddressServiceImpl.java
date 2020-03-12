package com.oms.service.impl;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.oms.api.request.AddressAddRequest;
import com.oms.api.request.AddressDeleteRequest;
import com.oms.api.request.AddressQueryRequest;
import com.oms.api.request.AddressUpdateRequest;
import com.oms.api.response.AddressListVO;
import com.oms.dao.AddressMapper;
import com.oms.dao.domain.Address;
import com.oms.service.AddressService;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.sql.Wrapper;
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
    public void addAddress(AddressAddRequest request) {
        Address address = new Address();
        address.setAddress(request.getAddress());
        address.setMoblie(request.getMobile());
        address.setName(request.getName());
        address.setOpenId(request.getOpenId());
        addressMapper.insert(address);
    }

    @Override
    public void editAddress(AddressUpdateRequest request) {
        Address address = new Address();
        address.setAddress(request.getAddress());
        address.setMoblie(request.getMobile());
        address.setName(request.getName());
        address.setId(request.getId());
        addressMapper.updateById(address);
    }

    @Override
    public void deleteAddress(AddressDeleteRequest request) {
        addressMapper.deleteById(request.getId());
    }

    @Override
    public List<AddressListVO> queryAddress(AddressQueryRequest request) {
        QueryWrapper<Address> wrapper = new QueryWrapper<>();
        Address address = new Address();
        address.setOpenId(request.getOpenId());
        List<Address> addresses = addressMapper.selectList(wrapper);
        if (CollectionUtils.isEmpty(addresses)) {
            new ArrayList<>();
        }
        return JSON.parseArray(JSON.toJSONString(addresses), AddressListVO.class);
    }
}
