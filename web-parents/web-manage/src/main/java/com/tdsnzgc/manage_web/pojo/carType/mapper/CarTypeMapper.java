package com.tdsnzgc.manage_web.pojo.carType.mapper;


import com.tdsnzgc.manage_web.pojo.base.mapper.BaseMapper;
import com.tdsnzgc.manage_web.pojo.carType.CarType;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface CarTypeMapper extends BaseMapper<CarType> {
    List<CarType> queryAll();
}
