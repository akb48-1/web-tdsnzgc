package com.tdsnzgc.manage_web.pojo.shippingMethods.mapper;


import com.tdsnzgc.manage_web.pojo.base.mapper.BaseMapper;
import com.tdsnzgc.manage_web.pojo.shippingMethods.ShippingMethods;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface ShippingMethodsMapper extends BaseMapper<ShippingMethods> {
    List<ShippingMethods> queryAll();
}
