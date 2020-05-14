package com.tdsnzgc.manage_web.controller.unit;

import com.tdsnzgc.common_web.config.resultUtil.Result;
import com.tdsnzgc.common_web.config.resultUtil.ResultUtil;
import com.tdsnzgc.common_web.vo.PageVo;
import com.tdsnzgc.manage_web.pojo.unit.Unit;
import com.tdsnzgc.manage_web.service.unit.UnitService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@Api(tags = "单位Controller")
@RestController
@RequestMapping("/unit")
public class UnitController {

    @Autowired
    UnitService unitService;

    @ApiOperation("所有单位")
    @PostMapping("/queryAll")
    public Result queryAll() {
        List<Unit> unitList = unitService.queryAll();
        return new ResultUtil().setData(unitList);
    }

    @ApiOperation("单位列表翻页")
    @PostMapping("/queryByPage")
    public Result queryByPage(@RequestBody Map map, Unit unit, PageVo pageVo) {
        Map data = unitService.queryByPage(new PageVo().setParams(map));
        return new ResultUtil().setData(data);
    }

    @ApiOperation("新增单位")
    @PostMapping("/addUnit")
    public Result addRole(@RequestBody Unit unit) {

        int row = unitService.insert(unit);

        if(row == 1) {
            return new ResultUtil().setSuccessMsg("添加单位成功");
        }
        return new ResultUtil().setErrorMsg("添加单位失败");
    }

}
