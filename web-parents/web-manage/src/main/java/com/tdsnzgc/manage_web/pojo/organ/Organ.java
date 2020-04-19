package com.tdsnzgc.manage_web.pojo.organ;

import com.tdsnzgc.manage_web.pojo.base.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigInteger;

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
    private String organ_create_time;

}
