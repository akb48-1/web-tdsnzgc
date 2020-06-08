package com.tdsnzgc.manage_web.pojo.seller;

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
@ApiModel(value = "Seller",description = "销售员")
public class Seller extends BaseEntity {
    @ApiModelProperty(value = "销售员id")
    private BigInteger seller_id;

    @ApiModelProperty(value = "销售员名称")
    private String seller_name;

    @ApiModelProperty(value = "销售员昵称")
    private String nick_name;

    @ApiModelProperty(value = "信息所属机构")
    private BigInteger organ_id;
}
