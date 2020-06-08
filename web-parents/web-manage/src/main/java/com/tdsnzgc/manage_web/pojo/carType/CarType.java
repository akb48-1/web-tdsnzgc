package com.tdsnzgc.manage_web.pojo.carType;

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
@ApiModel(value = "CarType",description = "车辆类型")
public class CarType extends BaseEntity {

    @ApiModelProperty(value = "车辆类型id")
    private BigInteger car_type_id;

    @ApiModelProperty(value = "车辆类型名称")
    private String car_type_name;

    @ApiModelProperty(value = "车辆类型value")
    private String car_type_value;

    @ApiModelProperty(value = "车辆类型key")
    private String car_type_key;

    @ApiModelProperty(value = "信息所属机构")
    private BigInteger organ_id;
}
