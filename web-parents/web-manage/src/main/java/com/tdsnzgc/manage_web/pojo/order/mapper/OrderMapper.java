package com.tdsnzgc.manage_web.pojo.order.mapper;


import com.tdsnzgc.manage_web.pojo.base.mapper.BaseMapper;
import com.tdsnzgc.manage_web.pojo.order.Order;
import com.tdsnzgc.manage_web.pojo.paymentType.PaymentType;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Mapper
@Repository
public interface OrderMapper extends BaseMapper<Order> {
    int insert(Map map);
}
