package com.tdsnzgc.manage_web.pojo.banner;

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
@ApiModel(value = "Banner",description = "轮播图")
public class Banner extends BaseEntity {

    @ApiModelProperty(value = "轮播图id")
    private BigInteger banner_id;

    @ApiModelProperty(value = "轮播图地址")
    private String banner_url;

    @ApiModelProperty(value = "类型 轮播图位置(0 首页)")
    private Integer type;

    @ApiModelProperty(value = "状态(0 启用 1停用)")
    private Integer status;

    @ApiModelProperty(value = "排序(值越小越靠前)")
    private BigInteger sort;

    @ApiModelProperty(value = "描述")
    private String banner_desc;

    @ApiModelProperty(value = "链接地址")
    private String href;

    @ApiModelProperty(value = "信息所属机构")
    private BigInteger organ_id;
}
