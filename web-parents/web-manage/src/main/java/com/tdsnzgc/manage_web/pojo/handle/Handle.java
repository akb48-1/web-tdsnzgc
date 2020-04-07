package com.tdsnzgc.manage_web.pojo.handle;

import com.tdsnzgc.manage_web.pojo.base.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Handle extends BaseEntity {
    Integer id;
    String name;
    String value;
    String index;
    Integer parent_id;
}
