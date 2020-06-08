package com.tdsnzgc.manage_web.service.shippingMethods.impl;

import com.github.pagehelper.PageHelper;
import com.tdsnzgc.common_web.vo.PageVo;
import com.tdsnzgc.manage_web.pojo.shippingMethods.ShippingMethods;
import com.tdsnzgc.manage_web.pojo.shippingMethods.mapper.ShippingMethodsMapper;
import com.tdsnzgc.manage_web.service.shippingMethods.ShippingMethodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.List;
import java.util.Map;

@Service
public class ShippingMethodsServiceImpl implements ShippingMethodsService {

    @Autowired
    ShippingMethodsMapper shippingMethodsMapper;

    @Override
    public List<ShippingMethods> queryAll() {
        return shippingMethodsMapper.queryAll();
    }
}
