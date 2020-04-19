package com.tdsnzgc.manage_web.pojo.permissions.mapper;

import com.tdsnzgc.manage_web.pojo.permissions.Permission;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;
import java.util.List;
import java.util.Map;

@Mapper
@Repository
public interface PermissionMapper {
    @Select("select * from t_permissions where status = 0")
    List<Permission> queryAllPermission();

    List<Permission> queryMyPermission(List<String> list);

    List<Permission> queryUsingPermissionByRoleId(Map map);

    List<Permission> queryUnUsingPermissionByRoleId(Map map);

    int queryUsingPermissionById(@Param("role_id") BigInteger role_id, @Param("permission_id") BigInteger permission_id);
}
