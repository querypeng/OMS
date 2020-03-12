package com.oms.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.baomidou.mybatisplus.extension.toolkit.ChainWrappers;
import com.oms.api.request.AddressQueryRequest;
import com.oms.api.response.AddressListVO;
import com.oms.dao.AddressMapper;
import com.oms.dao.entity.Address;
import com.oms.service.AddressService;
import com.oms.shared.beans.WrapperBeanCopier;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author pengfeng
 * @date 2020-03-12 13:44
 */
@Service
public class AddressServiceImpl extends ServiceImpl<AddressMapper, Address> implements AddressService {

    @Override
    public List<AddressListVO> queryAddress(AddressQueryRequest request) {
        List<Address> list = ChainWrappers.lambdaQueryChain(this.getBaseMapper())
                .eq(Address::getOpenId, request.getOpenId())
                .list();
        return WrapperBeanCopier.convert(list, AddressListVO.class);
    }
}
