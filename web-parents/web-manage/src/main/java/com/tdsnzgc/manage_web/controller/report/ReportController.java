package com.tdsnzgc.manage_web.controller.report;

import com.tdsnzgc.common_web.config.resultUtil.Result;
import com.tdsnzgc.common_web.config.resultUtil.ResultUtil;
import com.tdsnzgc.common_web.vo.PageVo;
import com.tdsnzgc.manage_web.pojo.order.Order;
import com.tdsnzgc.manage_web.pojo.permissions.mapper.PermissionMapper;
import com.tdsnzgc.manage_web.service.order.OrderService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Api(tags = "报表Controller")
@RestController
@RequestMapping("/report")
public class ReportController {

    @Autowired
    OrderService orderService;

    @ApiOperation("报表列表翻页")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "payment_type",value = "支付方式(1 现金 2 支付宝 3 微信 4 赊账 5  其他)" ),
            @ApiImplicitParam(name = "payment_status",value = "订单状态 (1 已付清 2 部分支付 3 未支付)" ),
            @ApiImplicitParam(name = "shipping_methods",value = "物流方式 (1 买家付运费 2 卖家付运费)" ),
            @ApiImplicitParam(name = "seller_id",value = "销售员ID" ),
            @ApiImplicitParam(name = "car_type",value = "车型ID" ),
            @ApiImplicitParam(name = "chauffeur_id",value = "司机ID" ),
            @ApiImplicitParam(name = "order_time_begin",value = "订单交易时间起" ),
            @ApiImplicitParam(name = "order_time_end",value = "订单交易时间止" ),
            @ApiImplicitParam(name = "create_time_begin",value = "数据记录时间起" ),
            @ApiImplicitParam(name = "create_time_end",value = "数据记录时间止" )
    })
    @PostMapping("/queryOrderReport")
    public Result queryOrderReport(@RequestBody Map map, PageVo pageVo) {
        Map data = orderService.queryReport(new PageVo().setParams(map));
        return new ResultUtil().setData(data);
    }

}
