package com.tdsnzgc.manage_web.pojo.goods;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.tdsnzgc.manage_web.pojo.base.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(value = "GoodsRecord",description = "商品记录信息")
public class GoodsRecord extends BaseEntity {

    @ApiModelProperty(value = "商品id")
    private BigInteger goods_unique_id;

    @ApiModelProperty(value = "商品id")
    private BigInteger goods_id;

    @ApiModelProperty("商品名称")
    private String goods_name;

    @ApiModelProperty("商品单价")
    private BigDecimal goods_price;

    @ApiModelProperty("商品总价")
    private BigDecimal goods_total_price;

    @ApiModelProperty("商品描述")
    private String goods_desc;

    @ApiModelProperty("机构id")
    private BigInteger organ_id;

    @ApiModelProperty("单位id")
    private BigInteger unit_id;

    @ApiModelProperty("单位名称")
    private String unit_name;

    @ApiModelProperty("交易类型( 1买入 2卖出)")
    private Integer type;

    @ApiModelProperty("交易数量")
    private Integer amount;

    @ApiModelProperty("订单交易时间")
    @JsonFormat(pattern = "yyyy-MM-dd", timezone="GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date order_time;
}
