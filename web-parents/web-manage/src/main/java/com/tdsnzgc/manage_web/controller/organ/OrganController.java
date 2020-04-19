package com.tdsnzgc.manage_web.controller.organ;

import com.tdsnzgc.common_web.config.resultUtil.Result;
import com.tdsnzgc.common_web.config.resultUtil.ResultUtil;
import com.tdsnzgc.common_web.vo.PageVo;
import com.tdsnzgc.manage_web.pojo.organ.Organ;
import com.tdsnzgc.manage_web.pojo.role.Role;
import com.tdsnzgc.manage_web.service.organ.OrganService;
import com.tdsnzgc.manage_web.service.role.RoleService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigInteger;
import java.util.Map;

@Api(tags = "机构Controller")
@RestController
@RequestMapping("/organ")
public class OrganController {

    @Autowired
    OrganService organService;

    @ApiOperation("机构列表翻页")
    @PostMapping("/queryByPage")
    public Result queryByPage(@RequestBody Map map, PageVo pageVo, Organ organ) {
        Map data = organService.queryByPage(new PageVo().setParams(map));
        return new ResultUtil().setData(data);
    }

    @ApiOperation("新增机构")
    @PostMapping("/addOrgan")
    public Result addOrgan(@RequestBody Organ organ, @RequestHeader(name = "token") String token) {

        organ.setCreateer_name();

        int row = organService.insert(organ);

        if(row == 1) {
            return new ResultUtil().setSuccessMsg("添加机构成功");
        }
        return new ResultUtil().setErrorMsg("添加机构失败");
    }

}
