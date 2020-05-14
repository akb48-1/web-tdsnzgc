package com.tdsnzgc.manage_web.pojo.unit.mapper;

import com.tdsnzgc.manage_web.pojo.base.mapper.BaseMapper;
import com.tdsnzgc.manage_web.pojo.unit.Unit;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Mapper
@Repository
public interface UnitMapper extends BaseMapper<Unit> {
    List<Unit> queryAll();
}
