package com.tdsnzgc.manage_web.pojo.permissions;

import com.tdsnzgc.manage_web.pojo.base.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigInteger;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Permission extends BaseEntity {
    BigInteger permission_id;
    String permission_name;
    Integer permission_type;
    Integer permission_index;
    Integer permission_level;

    String route_url;
    String component_path;
    String handle_value;
    BigInteger parent_menu_id;
    String icon;
}
