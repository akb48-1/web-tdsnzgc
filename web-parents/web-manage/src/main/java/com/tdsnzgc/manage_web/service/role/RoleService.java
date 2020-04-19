package com.tdsnzgc.manage_web.service.role;

import com.tdsnzgc.manage_web.pojo.base.service.BaseService;
import com.tdsnzgc.manage_web.pojo.role.Role;

import java.math.BigInteger;
import java.util.List;

public interface RoleService extends BaseService<Role> {
    Role queryById(BigInteger role_id);
    int addPermission(BigInteger role_id, BigInteger permission_id);
    int removePermission(BigInteger role_id, BigInteger permission_id);
    int queryUsingRoleById(BigInteger role_id);
}
