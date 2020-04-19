package com.tdsnzgc.common_web.vo;

import com.github.pagehelper.PageInfo;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PageVo {
    @ApiModelProperty(value = "页号")
    private int pageNo = 1;

    @ApiModelProperty(value = "页量")
    private int pageSize = 10;

    @ApiModelProperty(value = "排序字段")
    private String order;

    @ApiModelProperty(value = "排序方式")
    private String sort;


    // 设置默认参数
    public Map setParams(Map map) {

        if(map.get("pageNo") == null) {
            map.put("pageNo", this.pageNo);
        }

        if(map.get("pageSize") == null) {
            map.put("pageSize", this.pageSize);
        }

        return map;
    }

    // 整合结果
    public Map setPageResult(List list) {
        PageInfo pageInfo = new PageInfo(list);

        Map<String, Object> data = new HashMap<>();

        data.put("list", pageInfo.getList());
        data.put("pageNo", pageInfo.getPageNum());
        data.put("pageSize", pageInfo.getPageSize());
        data.put("total", pageInfo.getTotal());

        return data;
    }


}
