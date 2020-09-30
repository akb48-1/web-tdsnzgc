package com.tdsnzgc.manage_web.pojo.menu;

import com.tdsnzgc.manage_web.pojo.base.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigInteger;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Menu extends BaseEntity {
    BigInteger id;
    String title;
    String route_url;
    Integer index;
    Integer level;
    Integer type;
    String component_path;
    BigInteger parent_id;
    String icon;
    List<Menu> children;
    List<Object> handle_list;
    Boolean show_menu;
}
