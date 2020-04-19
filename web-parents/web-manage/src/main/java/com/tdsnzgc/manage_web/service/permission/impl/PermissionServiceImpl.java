package com.tdsnzgc.manage_web.service.permission.impl;

import com.github.pagehelper.PageHelper;
import com.tdsnzgc.common_web.config.account.pojo.Account;
import com.tdsnzgc.common_web.config.account.service.AccountServiceImpl;
import com.tdsnzgc.common_web.config.resultUtil.Result;
import com.tdsnzgc.common_web.vo.PageVo;
import com.tdsnzgc.manage_web.pojo.handle.Handle;
import com.tdsnzgc.manage_web.pojo.menu.Menu;
import com.tdsnzgc.manage_web.pojo.permissions.Permission;
import com.tdsnzgc.manage_web.pojo.permissions.mapper.PermissionMapper;
import com.tdsnzgc.manage_web.pojo.role.mapper.RoleMapper;
import com.tdsnzgc.manage_web.service.permission.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.*;

@Component
@Service
public class PermissionServiceImpl implements PermissionService {
    @Autowired
    PermissionMapper permissionMapper;

    @Autowired
    RoleMapper roleMapper;

    @Autowired
    AccountServiceImpl accountServiceImpl;

    @Override
    public List<Menu> queryMyPermissionMenu(String token, String type) {
        List<String> myPermissionIds = new ArrayList();
        // 权限集合
        List<Permission> permissionList = new ArrayList();

        if(token != null) {
            myPermissionIds = getMyPermissionIds(token);
            // 用户可用权限集合
            permissionList = permissionMapper.queryMyPermission(myPermissionIds);
        } else {
            // 所有权限集合
            permissionList = permissionMapper.queryAllPermission();
        }

        // 一级菜单
        List<Menu> level1MenuList = new ArrayList();

        // 二级菜单
        List<Menu> level2MenuList = new ArrayList();

        // 按钮权限
        List<Handle> handleList = new ArrayList();

        // 整理出菜单权限
        for (Permission p:permissionList  ) {
            // 菜单
            if(1 == p.getPermission_type()) {
                Menu menu = new Menu();
                menu.setId(p.getPermission_id());
                menu.setTitle(p.getPermission_name());
                menu.setRoute_url(p.getRoute_url());
                menu.setComponent_path(p.getComponent_path());
                menu.setIndex(p.getPermission_index());
                menu.setParent_id(p.getParent_menu_id());
                menu.setType(p.getPermission_type());
                menu.setIcon(p.getIcon());

                if(1 == p.getPermission_level()) {
                    level1MenuList.add(menu);
                }
                if(2 == p.getPermission_level()) {
                    level2MenuList.add(menu);
                }
            } else if (2 == p.getPermission_type()) {  // 按钮权限
                Handle handle = new Handle();
                handle.setId(p.getPermission_id());
                handle.setName(p.getPermission_name());
                handle.setValue(p.getHandle_value());
                handle.setIndex(p.getPermission_index());
                handle.setParent_id(p.getParent_menu_id());
                handle.setType(p.getPermission_type());
                handleList.add(handle);
            }
        }

        // 菜单添加按钮权限
        for (Handle handle:handleList ) {
            BigInteger parent_id = handle.getParent_id();
            if(parent_id != null) {
                // 处理 一级菜单的按钮权限
                for (Menu level1Menu:level1MenuList ) {
                    BigInteger id = level1Menu.getId();
                    if(id.equals(parent_id)) {
                        if(level1Menu.getHandle_list() == null) {
                            level1Menu.setHandle_list(new ArrayList<Object>());
                        }

                        if(type == null) {
                            List<Object> menu_handle_list = level1Menu.getHandle_list();
                            menu_handle_list.add(handle);
                        } else {
                            List<Object> menu_handle_list = level1Menu.getHandle_list();
                            menu_handle_list.add(handle.getValue());
                        }

                    }
                };

                // 处理 二级菜单的按钮权限
                for (Menu level2Menu:level2MenuList ) {
                    BigInteger id = level2Menu.getId();
                    if(id.equals(parent_id)) {
                        if(level2Menu.getHandle_list() == null) {
                            level2Menu.setHandle_list(new ArrayList<Object>());
                        }
                        if(type == null) {
                            List<Object> menu_handle_list = level2Menu.getHandle_list();
                            menu_handle_list.add(handle);
                        } else {
                            List<Object> menu_handle_list = level2Menu.getHandle_list();
                            menu_handle_list.add(handle.getValue());
                        }

                    }
                };
            }
        }

        // 嵌套菜单
        for (Menu level2Menu:level2MenuList ) {
            BigInteger parent_id = level2Menu.getParent_id();
            if(parent_id != null) {
                for (Menu level1Menu:level1MenuList ) {

                    BigInteger id = level1Menu.getId();
                    if(id.equals(parent_id)) {
                        if(level1Menu.getChildren() == null) {
                            level1Menu.setChildren(new ArrayList<Menu>());
                        }
                        List<Menu> children = level1Menu.getChildren();
                        children.add(level2Menu);
                    }
                }
            }
        }


        return level1MenuList;
    }


    @Override
    public List<String> getMyPermissionIds(String token) {
        // 获取用户信息
        Account account = accountServiceImpl.getUserInfo(token);

        // 读取 整理 用户角色id
        String[] role_ids = account.getRole_ids().split(",");
        List<String> role_ids_list = Arrays.asList(role_ids);

        // 读取角色权限
        List<String> rows = roleMapper.queryPermissionIdsByRoleIds(role_ids_list);

        // 整理角色权限
        List<String> permission_ids_list = new ArrayList();
        for (String row : rows) {
            String[] idsArr = row.split(",");
            List<String> idsList = Arrays.asList(idsArr);

            for (String id: idsList) {
                if(id != null)
                    permission_ids_list.add(id);
            }
        }

        // list 去重
        Set<String> hashSet = new HashSet<>(permission_ids_list);
        permission_ids_list = new ArrayList<>(hashSet);

        return permission_ids_list;
    }

    @Override
    public Map queryUsingPermissionByRoleId(Map map) {
        PageHelper.startPage((int) map.get("pageNo"), (int) map.get("pageSize"));
        List<Permission> list = permissionMapper.queryUsingPermissionByRoleId(map);
        return new PageVo().setPageResult(list);
    }

    @Override
    public Map queryUnUsingPermissionByRoleId(Map map) {
        PageHelper.startPage((int) map.get("pageNo"), (int) map.get("pageSize"));
        List<Permission> list = permissionMapper.queryUnUsingPermissionByRoleId(map);
        return new PageVo().setPageResult(list);
    }

}
