package com.tdsnzgc.manage_web.service.carType.impl;

import com.tdsnzgc.manage_web.pojo.carType.CarType;
import com.tdsnzgc.manage_web.pojo.carType.mapper.CarTypeMapper;
import com.tdsnzgc.manage_web.service.carType.CarTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarTypeServiceImpl implements CarTypeService {

    @Autowired
    CarTypeMapper carTypeMapper;

    @Override
    public List<CarType> queryAll() {
        return carTypeMapper.queryAll();
    }
}
