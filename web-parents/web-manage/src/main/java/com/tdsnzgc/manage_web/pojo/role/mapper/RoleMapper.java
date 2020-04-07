package com.tdsnzgc.manage_web.pojo.role.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface RoleMapper {
    List<String> queryRoleById(List<String> list);
}
