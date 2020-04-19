package com.tdsnzgc.manage_web.pojo.base;

import cn.hutool.core.date.DateUtil;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.tdsnzgc.common_web.config.account.pojo.Account;
import com.tdsnzgc.common_web.config.account.service.AccountService;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.text.SimpleDateFormat;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BaseEntity {

    @ApiModelProperty(value = "创建时间")
    private Date create_time;

    @ApiModelProperty("创建人名称")
    private String createer_name;

    @ApiModelProperty("更新时间")
    private Date update_time;

    @ApiModelProperty("更新人名称")
    private String updateer_name;

    public void setCreateer_name() {
        this.createer_name = (String) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    }

    public void setUpdateer_name() {
        this.updateer_name = (String) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    }
    
}
