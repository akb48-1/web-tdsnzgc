package com.tdsnzgc.manage_web.pojo.paymentType;

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
@ApiModel(value = "PaymentType",description = "支付方式")
public class PaymentType extends BaseEntity {

    @ApiModelProperty(value = "支付方式id")
    private BigInteger payment_type_id;

    @ApiModelProperty(value = "支付方式名称")
    private String payment_type_name;

    @ApiModelProperty(value = "支付方式value")
    private String payment_type_value;

    @ApiModelProperty(value = "支付方式key")
    private String payment_type_key;

    @ApiModelProperty(value = "信息所属机构")
    private BigInteger organ_id;
}
