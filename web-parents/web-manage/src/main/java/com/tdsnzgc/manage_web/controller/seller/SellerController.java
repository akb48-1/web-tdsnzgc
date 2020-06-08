package com.tdsnzgc.manage_web.controller.seller;


import com.tdsnzgc.common_web.config.resultUtil.Result;
import com.tdsnzgc.common_web.config.resultUtil.ResultUtil;
import com.tdsnzgc.manage_web.pojo.seller.Seller;
import com.tdsnzgc.manage_web.pojo.shippingMethods.ShippingMethods;
import com.tdsnzgc.manage_web.service.seller.SellerService;
import com.tdsnzgc.manage_web.service.shippingMethods.ShippingMethodsService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Api(tags = "销售员Controller")
@RestController
@RequestMapping("/seller")
public class SellerController {

    @Autowired
    SellerService sellerService;

    @ApiOperation("所有销售员")
    @PostMapping("/queryAll")
    public Result queryAll() {
        List<Seller> sellerList = sellerService.queryAll();
        return new ResultUtil().setData(sellerList);
    }
}
