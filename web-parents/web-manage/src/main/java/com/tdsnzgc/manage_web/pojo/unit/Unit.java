package com.tdsnzgc.manage_web.pojo.unit;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigInteger;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Unit {
    @ApiModelProperty(value = "单位id")
    private BigInteger unit_id;

    @ApiModelProperty("单位名")
    private String unit_name;

    @ApiModelProperty("单位key")
    private String unit_key;

}
