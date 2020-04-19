package com.tdsnzgc.manage_web.service.role;

import com.github.pagehelper.PageHelper;
import com.tdsnzgc.common_web.config.resultUtil.ResultUtil;
import com.tdsnzgc.common_web.util.Util;
import com.tdsnzgc.common_web.vo.PageVo;
import com.tdsnzgc.manage_web.pojo.role.Role;
import com.tdsnzgc.manage_web.pojo.role.mapper.RoleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.List;
import java.util.Map;

@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    RoleMapper roleMapper;


    @Override
    public Role queryById(BigInteger role_id) {
        return roleMapper.queryById(role_id);
    }

    @Override
    public Map queryByPage(Map map) {
        PageHelper.startPage((int) map.get("pageNo"), (int) map.get("pageSize"));

        List<Role> roleList = roleMapper.queryByPage(map);

        return new PageVo().setPageResult(roleList);
    }

    @Override
    public int insert(Role role) {
        return roleMapper.insert(role);
    }

    @Override
    public int update(Role role) {
        return roleMapper.update(role);
    }

    @Override
    public int delete(BigInteger role_id) {
        return roleMapper.delete(role_id);
    }

    @Override
    public int addPermission(BigInteger role_id,BigInteger permission_id) {
        String updateer_name = Util.getUserName();
        return roleMapper.addPermission(role_id, permission_id, updateer_name);
    }

    @Override
    public int removePermission(BigInteger role_id,BigInteger permission_id) {
        String updateer_name = Util.getUserName();
        return roleMapper.removePermission(role_id, permission_id, updateer_name);
    }

    @Override
    public int queryUsingRoleById(BigInteger role_id) {
        return roleMapper.queryUsingRoleById(role_id);
    }

}
