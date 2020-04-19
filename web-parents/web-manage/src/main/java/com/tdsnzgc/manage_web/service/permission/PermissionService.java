package com.tdsnzgc.manage_web.service.permission;

import com.tdsnzgc.common_web.vo.PageVo;
import com.tdsnzgc.manage_web.pojo.menu.Menu;
import com.tdsnzgc.manage_web.pojo.permissions.Permission;

import java.math.BigInteger;
import java.util.List;
import java.util.Map;

public interface PermissionService {
    List<Menu> queryMyPermissionMenu(String token, String type);
    List<String> getMyPermissionIds(String token);
    Map queryUsingPermissionByRoleId(Map map);
    Map queryUnUsingPermissionByRoleId(Map map);
}
