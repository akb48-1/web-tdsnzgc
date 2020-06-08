package com.tdsnzgc.manage_web.controller.order;


import com.tdsnzgc.common_web.config.account.service.impl.AccountServiceImpl;
import com.tdsnzgc.common_web.config.resultUtil.Result;
import com.tdsnzgc.common_web.config.resultUtil.ResultUtil;
import com.tdsnzgc.common_web.vo.PageVo;
import com.tdsnzgc.manage_web.pojo.order.Order;
import com.tdsnzgc.manage_web.service.order.OrderService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.text.ParseException;
import java.util.Map;

@Api(tags = "订单Controller")
@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    OrderService orderService;

    @Autowired
    AccountServiceImpl accountServiceImpl;

    @ApiOperation("订单详情")
    @PostMapping("/queryById/{id}")
    public Result queryByPage(@PathVariable(name ="id") BigInteger order_id) {
        Order order = orderService.queryById(order_id);
        return new ResultUtil().setData(order);
    }

    @ApiOperation("订单列表翻页")
    @PostMapping("/queryByPage")
    public Result queryByPage(@RequestBody Map map, Order order, PageVo pageVo) {
        Map data = orderService.queryByPage(new PageVo().setParams(map));
        return new ResultUtil().setData(data);
    }

    @ApiOperation("新增订单")
    @PostMapping("/addOrder")
    public Result createOrder(@RequestBody Map map) throws ParseException {

        BigDecimal payment_price = new BigDecimal(map.get("payment_price").toString());

        BigDecimal real_price = new BigDecimal(map.get("real_price").toString());

        BigDecimal zero = new BigDecimal("0");

        if(payment_price.compareTo(real_price) == 0) {

            map.put("payment_status", 1); // 订单状态 (1 已付清 2 部分支付 3 未支付)

        } else if(payment_price.compareTo(real_price) == -1) {

            if(payment_price.compareTo(zero) == 0) {

                map.put("payment_status", 3);

            } else {

                map.put("payment_status", 2);

            }
        } else if(payment_price.compareTo(real_price) == 1) {
            return new ResultUtil().setErrorMsg("实付金额不能超过应付金额");
        }

        return orderService.addOrder(map);

    }
}
