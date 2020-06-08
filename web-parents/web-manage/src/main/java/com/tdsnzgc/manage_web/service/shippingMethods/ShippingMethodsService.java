package com.tdsnzgc.manage_web.service.shippingMethods;

import com.tdsnzgc.manage_web.pojo.base.service.BaseService;
import com.tdsnzgc.manage_web.pojo.shippingMethods.ShippingMethods;

import java.util.List;

public interface ShippingMethodsService {
    List<ShippingMethods> queryAll();
}
