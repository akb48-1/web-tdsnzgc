package com.tdsnzgc.manage_web.pojo.role.mapper;

import com.tdsnzgc.manage_web.pojo.base.mapper.BaseMapper;
import com.tdsnzgc.manage_web.pojo.role.Role;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;
import java.util.List;
import java.util.Map;

@Mapper
@Repository
public interface RoleMapper extends BaseMapper<Role> {
    List<String> queryPermissionIdsByRoleIds(List<String> list);
    int addPermission(@Param("role_id") BigInteger role_id, @Param("permission_id") BigInteger permission_id, @Param("updateer_name") String updateer_name);
    int removePermission(@Param("role_id") BigInteger role_id, @Param("permission_id") BigInteger permission_id, @Param("updateer_name") String updateer_name);
    int queryUsingRoleById(BigInteger role_id);
}
