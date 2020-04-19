package com.tdsnzgc.manage_web.controller.permission;

import com.tdsnzgc.common_web.config.resultUtil.Result;
import com.tdsnzgc.common_web.config.resultUtil.ResultUtil;
import com.tdsnzgc.common_web.vo.PageVo;
import com.tdsnzgc.manage_web.pojo.menu.Menu;
import com.tdsnzgc.manage_web.pojo.permissions.Permission;
import com.tdsnzgc.manage_web.pojo.role.Role;
import com.tdsnzgc.manage_web.pojo.role.mapper.RoleMapper;
import com.tdsnzgc.manage_web.service.permission.PermissionService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigInteger;
import java.util.List;
import java.util.Map;

@Api(tags = "菜单/路由权限Controller")
@RestController
@RequestMapping("/permission")
public class PermissionController {
    @Autowired
    PermissionService permissionService;

    @Autowired
    RoleMapper roleMapper;

    @ApiOperation("通过角色查已用权限")
    @PostMapping("/queryUsingPermissionByRoleId/{role_id}")
    public Result queryMyPermissionRouter(@PathVariable(name = "role_id") BigInteger role_id, @RequestBody Map map, PageVo pageVo, Permission permission) {
        Role role = roleMapper.queryById(role_id);
        if(role != null) {

            map.put("permission_ids", role.getPermission_ids());

            Map data = permissionService.queryUsingPermissionByRoleId(new PageVo().setParams(map));
            return new ResultUtil().setData(data);
        }
        return new ResultUtil().setErrorMsg("角色不存在");
    }

    @ApiOperation("通过角色查未用权限")
    @PostMapping("/queryUnUsingPermissionByRoleId/{role_id}")
    public Result queryUnUsingPermissionByRoleId(@PathVariable(name = "role_id") BigInteger role_id, @RequestBody Map map, PageVo pageVo, Permission permission) {
        Role role = roleMapper.queryById(role_id);
        if(role != null) {

            map.put("permission_ids", role.getPermission_ids());

            Map data = permissionService.queryUnUsingPermissionByRoleId(new PageVo().setParams(map));
            return new ResultUtil().setData(data);
        }
        return new ResultUtil().setErrorMsg("角色不存在");
    }
}
