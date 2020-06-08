package com.tdsnzgc.manage_web.pojo.base;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.tdsnzgc.common_web.config.account.service.impl.AccountServiceImpl;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.security.core.context.SecurityContextHolder;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BaseEntity {

    @ApiModelProperty(value = "创建时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date create_time;

    @ApiModelProperty("创建人名称")
    private String createer_name;

    @ApiModelProperty("更新时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date update_time;

    @ApiModelProperty("更新人名称")
    private String updateer_name;

    public void setCreateer_name() {
        this.createer_name = (String) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    }

    public void setUpdateer_name() {
        this.updateer_name = (String) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    }

    public String setUsername() {
        return (String) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    }
    
    
}
