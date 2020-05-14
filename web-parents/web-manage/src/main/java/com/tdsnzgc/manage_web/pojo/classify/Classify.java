package com.tdsnzgc.manage_web.pojo.classify;

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
@ApiModel(value = "Classify",description = "分类信息")
public class Classify extends BaseEntity {
    @ApiModelProperty(value = "分类id")
    private BigInteger classify_id;

    @ApiModelProperty("分类名称")
    private String classify_name;

    @ApiModelProperty("父分类id")
    private BigInteger parent_classify_id;

    @ApiModelProperty("机构id")
    private BigInteger organ_id;

    @ApiModelProperty("状态 0启用 1禁用")
    private int status;
}
