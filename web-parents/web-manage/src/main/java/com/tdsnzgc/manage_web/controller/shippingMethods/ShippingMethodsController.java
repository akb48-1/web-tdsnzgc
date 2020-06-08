package com.tdsnzgc.manage_web.controller.shippingMethods;


import com.tdsnzgc.common_web.config.resultUtil.Result;
import com.tdsnzgc.common_web.config.resultUtil.ResultUtil;
import com.tdsnzgc.manage_web.pojo.goods.Goods;
import com.tdsnzgc.manage_web.pojo.shippingMethods.ShippingMethods;
import com.tdsnzgc.manage_web.pojo.unit.Unit;
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
@RequestMapping("/shippingMethods")
public class ShippingMethodsController {

    @Autowired
    ShippingMethodsService shippingMethodsService;

    @ApiOperation("所有运输方式")
    @PostMapping("/queryAll")
    public Result queryAll() {
        List<ShippingMethods> shippingMethodsList = shippingMethodsService.queryAll();
        return new ResultUtil().setData(shippingMethodsList);
    }
}
