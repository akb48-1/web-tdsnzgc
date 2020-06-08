package com.tdsnzgc.manage_web.service.paymentType.impl;

import com.tdsnzgc.manage_web.pojo.paymentType.PaymentType;
import com.tdsnzgc.manage_web.pojo.paymentType.mapper.PaymentTypeMapper;
import com.tdsnzgc.manage_web.pojo.shippingMethods.ShippingMethods;
import com.tdsnzgc.manage_web.service.paymentType.PaymentTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PaymentTypeServiceImpl implements PaymentTypeService {

    @Autowired
    PaymentTypeMapper paymentTypeMapper;

    @Override
    public List<PaymentType> queryAll() {
        return paymentTypeMapper.queryAll();
    }
}
