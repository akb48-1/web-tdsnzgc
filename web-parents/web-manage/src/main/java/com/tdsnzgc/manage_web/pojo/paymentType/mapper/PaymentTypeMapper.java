package com.tdsnzgc.manage_web.pojo.paymentType.mapper;


import com.tdsnzgc.manage_web.pojo.base.mapper.BaseMapper;
import com.tdsnzgc.manage_web.pojo.paymentType.PaymentType;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface PaymentTypeMapper extends BaseMapper<PaymentType> {
    List<PaymentType> queryAll();
}
