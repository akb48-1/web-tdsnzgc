package com.tdsnzgc.manage_web.service.order;

import com.tdsnzgc.common_web.config.resultUtil.Result;
import com.tdsnzgc.manage_web.pojo.base.service.BaseService;
import com.tdsnzgc.manage_web.pojo.goods.Goods;
import com.tdsnzgc.manage_web.pojo.order.Order;

import java.text.ParseException;
import java.util.Map;

public interface OrderService extends BaseService<Order> {
    Result addOrder(Map map) throws ParseException;
}
