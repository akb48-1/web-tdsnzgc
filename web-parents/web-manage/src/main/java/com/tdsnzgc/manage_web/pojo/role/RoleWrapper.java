package com.tdsnzgc.manage_web.pojo.role;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(value = "RoleWrapper", description = "角色包装")
public class RoleWrapper {

    @ApiModelProperty("角色类list")
    private List<Role> listRole;

    @ApiModelProperty(value="描述 mark",name="state",required=true)
    private String mark;
}
