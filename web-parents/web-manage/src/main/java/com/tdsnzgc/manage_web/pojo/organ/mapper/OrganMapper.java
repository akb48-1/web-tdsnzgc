package com.tdsnzgc.manage_web.pojo.organ.mapper;


import com.tdsnzgc.manage_web.pojo.base.mapper.BaseMapper;
import com.tdsnzgc.manage_web.pojo.organ.Organ;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface OrganMapper extends BaseMapper<Organ> {
}
