package com.tdsnzgc.manage_web.controller.role;

import com.tdsnzgc.common_web.config.resultUtil.Result;
import com.tdsnzgc.common_web.config.resultUtil.ResultUtil;
import com.tdsnzgc.common_web.vo.PageVo;
import com.tdsnzgc.manage_web.pojo.permissions.mapper.PermissionMapper;
import com.tdsnzgc.manage_web.pojo.role.Role;
import com.tdsnzgc.manage_web.service.role.RoleService;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;

@Api(tags = "角色Controller")
@RestController
@RequestMapping("/role")
public class RoleController {

    @Autowired
    RoleService roleService;

    @Autowired
    PermissionMapper permissionMapper;

    @ApiOperation("角色详情")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id",value = "角色id")
    })
    @PostMapping("/queryById/{id}")
    public Result queryById(@PathVariable(name ="id") BigInteger role_id) {
        Role role = roleService.queryById(role_id);
        return new ResultUtil().setData(role);
    }

    @ApiOperation("角色列表翻页")
    @PostMapping("/queryByPage")
    public Result queryByPage( @RequestBody Map map, Role role, PageVo pageVo) {
        Map data = roleService.queryByPage(new PageVo().setParams(map));
        return new ResultUtil().setData(data);
    }

    @ApiOperation("新增角色")
    @PostMapping("/addRole")
    public Result addRole(@RequestBody Role role) {

        role.setCreateer_name();

        int row = roleService.insert(role);

        if(row == 1) {
            return new ResultUtil().setSuccessMsg("添加角色成功");
        }
        return new ResultUtil().setErrorMsg("添加角色失败");
    }

    @PostMapping("/updateRole")
    public Result updateRole(@RequestBody Role role) {

        role.setUpdateer_name();;

        int row = roleService.update(role);

        if(row == 1) {
            return new ResultUtil().setSuccessMsg("修改角色成功");
        }
        return new ResultUtil().setErrorMsg("修改失败，未找到此角色");
    }

    @ApiOperation("删除角色")
    @ApiImplicitParams({
        @ApiImplicitParam(name = "id",value = "角色id" )
    })
    @PostMapping("/deleteRole/{id}")
    public Result deleteRole(@PathVariable(name ="id") BigInteger role_id) {

        // 查询是否正在启用
        int qrow = roleService.queryUsingRoleById(role_id);

        if(qrow > 0) {

            return new ResultUtil().setErrorMsg("删除失败，还有其他用户在使用该角色");
        }

        int drow = roleService.delete(role_id);

        if(drow > 0) {
            return new ResultUtil().setSuccessMsg("删除角色成功");
        }

        return new ResultUtil().setErrorMsg("角色不存在");
    }


    @ApiOperation("添加角色相关权限")
    @ApiImplicitParams({
        @ApiImplicitParam(name = "role_id",value = "角色id"),
        @ApiImplicitParam(name = "permission_id", value = "权限id")
    })
    @PostMapping("/addPermission/{role_id}/{permission_id}")
    public Result addPermission(@PathVariable BigInteger role_id, @PathVariable BigInteger permission_id) {

        int qrow = permissionMapper.queryUsingPermissionById(role_id, permission_id);

        if(qrow == 0) {
            int row = roleService.addPermission(role_id, permission_id);

            if(row > 0) {
                return new ResultUtil().setSuccessMsg("添加权限成功");
            }
            return new ResultUtil().setErrorMsg("添加权限失败");
        }
        return new ResultUtil().setErrorMsg("添加失败,角色已存在此权限");
    }

    @ApiOperation("移除角色相关权限")
    @ApiImplicitParams({
        @ApiImplicitParam(name = "role_id",value = "角色id"),
        @ApiImplicitParam(name = "permission_id", value = "权限id")
    })
    @PostMapping("/removePermission/{role_id}/{permission_id}")
    public Result removePermission(@PathVariable BigInteger role_id, @PathVariable BigInteger permission_id) {

        int qrow = permissionMapper.queryUsingPermissionById(role_id, permission_id);

        if(qrow > 0) {
            int row = roleService.removePermission(role_id, permission_id);

            if(row > 0) {
                return new ResultUtil().setSuccessMsg("移除权限成功");
            }
            return new ResultUtil().setErrorMsg("移除权限失败");
        }
        return new ResultUtil().setErrorMsg("删除失败,角色不存在此权限");
    }


}
