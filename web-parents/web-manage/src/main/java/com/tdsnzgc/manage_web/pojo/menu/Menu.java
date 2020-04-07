package com.tdsnzgc.manage_web.pojo.menu;

import com.tdsnzgc.manage_web.pojo.base.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Menu extends BaseEntity {
    Integer id;
    String title;
    String route_url;
    String index;
    String level;
    String component_path;
    Integer parent_id;
    String iCon;
    List<Menu> children;
    List<Object> handle_list;
}
