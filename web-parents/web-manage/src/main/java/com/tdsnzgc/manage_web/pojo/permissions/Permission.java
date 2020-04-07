package com.tdsnzgc.manage_web.pojo.permissions;

import com.tdsnzgc.manage_web.pojo.base.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Permission extends BaseEntity {
    Integer permission_id;
    String permission_name;
    String permission_type;
    String permission_index;
    String permission_level;

    String route_url;
    String component_path;
    String handle_value;
    Integer parent_menu_id;
    String iCon;
}
