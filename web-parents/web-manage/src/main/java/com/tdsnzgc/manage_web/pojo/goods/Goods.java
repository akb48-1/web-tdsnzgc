package com.tdsnzgc.manage_web.pojo.goods;

import com.tdsnzgc.manage_web.pojo.base.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.math.BigInteger;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(value = "Goods",description = "商品信息")
public class Goods extends BaseEntity {
    @ApiModelProperty(value = "商品id")
    private BigInteger goods_id;

    @ApiModelProperty("商品名称")
    private String goods_name;

    @ApiModelProperty("商品价格")
    private BigDecimal goods_price;

    @ApiModelProperty("商品描述")
    private String goods_desc;

    @ApiModelProperty("商品缩略图")
    private String goods_picture;

    @ApiModelProperty("商品分类ID")
    private String classify_ids;

    @ApiModelProperty("机构id")
    private BigInteger organ_id;

    @ApiModelProperty("单位id")
    private BigInteger unit_id;

    @ApiModelProperty("状态 0 在售 1 停售 2 售馨")
    private int status;
}
