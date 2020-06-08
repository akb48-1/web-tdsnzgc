package com.tdsnzgc.manage_web.pojo.shippingMethods;

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
@ApiModel(value = "ShippingMethods",description = "运输方式")
public class ShippingMethods extends BaseEntity {
    @ApiModelProperty(value = "运输方式id")
    private BigInteger shipping_methods_id;

    @ApiModelProperty(value = "运输方式名称")
    private String shipping_methods_name;

    @ApiModelProperty(value = "运输方式value")
    private String shipping_methods_value;

    @ApiModelProperty(value = "运输方式key")
    private String shipping_methods_key;

    @ApiModelProperty(value = "信息所属机构")
    private BigInteger organ_id;
}
