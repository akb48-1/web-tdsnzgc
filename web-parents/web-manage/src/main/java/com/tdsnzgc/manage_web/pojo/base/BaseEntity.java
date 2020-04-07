package com.tdsnzgc.manage_web.pojo.base;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.format.annotation.DateTimeFormat;

import java.sql.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BaseEntity {

    @CreatedDate
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "创建时间")
    private Date create_time;

    @ApiModelProperty("创建人id")
    private String createor_id;

    @ApiModelProperty("创建人名称")
    private String createor_name;

    @CreatedDate
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty("更新时间")
    private Date update_time;

    @ApiModelProperty("更新人id")
    private String update_id;

    @ApiModelProperty("更新人名称")
    private String update_name;
}
