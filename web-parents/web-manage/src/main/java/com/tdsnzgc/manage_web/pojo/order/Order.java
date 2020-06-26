package com.tdsnzgc.manage_web.pojo.order;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.tdsnzgc.manage_web.pojo.base.BaseEntity;
import com.tdsnzgc.manage_web.pojo.goods.GoodsRecord;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(value = "Order",description = "订单信息")
public class Order extends BaseEntity {
    @ApiModelProperty(value = "订单id")
    private BigInteger order_id;

    @ApiModelProperty(value = "订单全部商品金额")
    private BigDecimal order_price;

    @ApiModelProperty(value = "订单交易价格")
    private BigDecimal real_price;

    @ApiModelProperty(value = "实际支付金额")
    private BigDecimal payment_price;

    @ApiModelProperty(value = "支付方式(1 现金 2 支付宝 3 微信 4 赊账 5  其他)")
    private BigInteger payment_type;

    @ApiModelProperty(value = "订单状态 (1 已付清 2 部分支付 3 未支付)")
    private BigInteger payment_status;

    @ApiModelProperty(value = "订单描述")
    private String order_desc;

    @ApiModelProperty(value = "订单产品唯一ID集合")
    private String order_goods_unique_ids;

    @ApiModelProperty(value = "订单物料唯一ID集合")
    private String order_material_unique_ids;

    @ApiModelProperty(value = "销售员ID")
    private BigInteger seller_id;

    @ApiModelProperty(value = "销售员名称")
    private String seller_name;

    @ApiModelProperty(value = "物流方式 (1 买家付运费 2 卖家付运费)")
    private BigInteger shipping_methods;

    @ApiModelProperty(value = "运费")
    private BigDecimal carriage;

    @ApiModelProperty(value = "司机ID")
    private BigInteger chauffeur_id;

    @ApiModelProperty(value = "司机名称")
    private String chauffeur_name;

    @ApiModelProperty(value = "车型ID")
    private BigInteger car_type;

    @ApiModelProperty(value = "车型名称")
    private String car_type_name;

    @ApiModelProperty(value = "信息所属机构")
    private BigInteger organ_id;

    @ApiModelProperty(value = "商品交易记录")
    private List<GoodsRecord> GoodsRecords;

    @ApiModelProperty("订单交易时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone="GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date order_time;

}
