package com.tdsnzgc.common_web.page;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Page {
    @ApiModelProperty(value = "页号")
    private int pageNo;

    @ApiModelProperty(value = "页量")
    private int pageSize = 10;

    @ApiModelProperty(value = "排序字段")
    private String order;

    @ApiModelProperty(value = "排序方式")
    private String sort;
}
