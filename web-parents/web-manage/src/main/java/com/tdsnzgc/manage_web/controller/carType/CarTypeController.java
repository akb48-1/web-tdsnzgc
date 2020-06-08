package com.tdsnzgc.manage_web.controller.carType;


import com.tdsnzgc.common_web.config.resultUtil.Result;
import com.tdsnzgc.common_web.config.resultUtil.ResultUtil;
import com.tdsnzgc.manage_web.pojo.carType.CarType;
import com.tdsnzgc.manage_web.pojo.paymentType.PaymentType;
import com.tdsnzgc.manage_web.service.carType.CarTypeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Api(tags = "车辆类型式Controller")
@RestController
@RequestMapping("/carType")
public class CarTypeController {

    @Autowired
    CarTypeService carTypeService;

    @ApiOperation("所有车辆类型")
    @PostMapping("/queryAll")
    public Result queryAll() {
        List<CarType> carTypeList = carTypeService.queryAll();
        return new ResultUtil().setData(carTypeList);
    }
}
