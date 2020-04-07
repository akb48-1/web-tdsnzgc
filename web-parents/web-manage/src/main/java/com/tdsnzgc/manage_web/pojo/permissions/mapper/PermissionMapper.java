package com.tdsnzgc.manage_web.pojo.permissions.mapper;

import com.tdsnzgc.manage_web.pojo.permissions.Permission;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface PermissionMapper {
    @Select("select * from t_permissions where status = 0")
    List<Permission> queryAllPermission();

    List<Permission> queryMyPermission(List<String> list);
}
