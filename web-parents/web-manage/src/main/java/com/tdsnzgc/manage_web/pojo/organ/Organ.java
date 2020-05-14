package com.tdsnzgc.manage_web.pojo.organ;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.tdsnzgc.manage_web.pojo.base.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigInteger;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(value = "Organ",description = "机构信息")
public class Organ extends BaseEntity {

    @ApiModelProperty(value = "机构id")
    private BigInteger organ_id;

    @ApiModelProperty("机构名")
    private String organ_name;

    @ApiModelProperty("机构地址")
    private String organ_address;

    @ApiModelProperty("机构电话")
    private String organ_tel;

    @ApiModelProperty("机构图片")
    private String organ_picture;

    @ApiModelProperty("机构描述")
    private String organ_desc;

    @ApiModelProperty("创办时间")
    @JsonFormat(pattern = "yyyy-MM-dd")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date organ_create_time;

    @ApiModelProperty("状态 0: 正常运营 1:暂停运营")
    private int status;
}
