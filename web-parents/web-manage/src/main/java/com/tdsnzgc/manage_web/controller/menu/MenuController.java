package com.tdsnzgc.manage_web.controller.menu;

import com.tdsnzgc.common_web.config.resultUtil.Result;
import com.tdsnzgc.common_web.config.resultUtil.ResultUtil;
import com.tdsnzgc.manage_web.pojo.menu.Menu;
import com.tdsnzgc.manage_web.service.permission.PermissionService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(tags = "菜单/路由权限Controller")
@RestController
@RequestMapping("/menu")
public class MenuController {

    @Autowired
    PermissionService permissionService;


    @ApiOperation("查询全部权限菜单")
    @PostMapping("/queryAllPermissionMenu")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "token", value = "用户令牌", required = true)
    })
    public Result queryAllPermissionMenu(@RequestHeader(name = "token") String token) {
        List<Menu> permissions = permissionService.queryMyPermissionMenu(token, null);
        return new ResultUtil().setData(permissions);
    }

    @ApiOperation("查询权限路由")
    @PostMapping("/queryMyPermissionRouter")
    @ApiImplicitParams({
        @ApiImplicitParam(name = "token", value = "用户令牌", required = true)
    })
    public Result queryMyPermissionRouter(@RequestHeader(name = "token") String token) {
        List<Menu> permissions = permissionService.queryMyPermissionMenu(token, "router");
        return new ResultUtil().setData(permissions);
    }
}
