package com.tdsnzgc.manage_web.pojo.classify.mapper;


import com.tdsnzgc.manage_web.pojo.base.mapper.BaseMapper;
import com.tdsnzgc.manage_web.pojo.classify.Classify;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface ClassifyMapper extends BaseMapper<Classify> {
    List<Classify> queryAll();
}
