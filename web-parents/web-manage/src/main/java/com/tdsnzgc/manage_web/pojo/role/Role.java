package com.tdsnzgc.manage_web.pojo.role;

import com.tdsnzgc.manage_web.pojo.base.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(value = "Role",description = "角色信息")
public class Role extends BaseEntity {

    @ApiModelProperty(value = "角色id")
    private Integer role_id;

    @ApiModelProperty("角色名")
    private String role_name;

    @ApiModelProperty("角色包含权限id集合")
    private String permission_ids;

    @ApiModelProperty("状态 1 启用 2 禁用")
    private Integer status;
}
