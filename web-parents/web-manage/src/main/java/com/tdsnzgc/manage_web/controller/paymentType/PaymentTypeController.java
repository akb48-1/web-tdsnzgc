package com.tdsnzgc.manage_web.controller.paymentType;


import com.tdsnzgc.common_web.config.resultUtil.Result;
import com.tdsnzgc.common_web.config.resultUtil.ResultUtil;
import com.tdsnzgc.manage_web.pojo.paymentType.PaymentType;
import com.tdsnzgc.manage_web.pojo.shippingMethods.ShippingMethods;
import com.tdsnzgc.manage_web.service.paymentType.PaymentTypeService;
import com.tdsnzgc.manage_web.service.shippingMethods.ShippingMethodsService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Api(tags = "运输方式Controller")
@RestController
@RequestMapping("/paymentType")
public class PaymentTypeController {

    @Autowired
    PaymentTypeService paymentTypeService;

    @ApiOperation("所有支付方式")
    @PostMapping("/queryAll")
    public Result queryAll() {
        List<PaymentType> paymentTypeList = paymentTypeService.queryAll();
        return new ResultUtil().setData(paymentTypeList);
    }
}
