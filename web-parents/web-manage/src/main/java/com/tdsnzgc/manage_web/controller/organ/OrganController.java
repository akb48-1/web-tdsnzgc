package com.tdsnzgc.manage_web.controller.organ;

import com.tdsnzgc.common_web.config.account.pojo.Account;
import com.tdsnzgc.common_web.config.account.service.AccountService;
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

    @Autowired
    AccountService accountService;

    @ApiOperation("机构详情")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id",value = "机构id")
    })
    @PostMapping("/queryMyOrgan")
    public Result queryMyOrgan(@RequestHeader(name ="token") String token) {
        Account userInfo = accountService.getUserInfo(token);
        String organ_ids = userInfo.getOrgan_ids();
        Organ organ = organService.queryById(new BigInteger(organ_ids));

        if(organ != null) {
            return new ResultUtil().setData(organ);
        }
        return new ResultUtil().setErrorMsg("账户未配置分店");
    }

    @ApiOperation("机构详情")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id",value = "机构id")
    })
    @PostMapping("/queryById/{id}")
    public Result queryById(@PathVariable(name ="id") BigInteger organ_id) {
        Organ organ = organService.queryById(organ_id);
        return new ResultUtil().setData(organ);
    }

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

    @PostMapping("/updateOrgan")
    public Result updateOrgan(@RequestBody Organ organ) {

        organ.setUpdateer_name();;

        int row = organService.update(organ);

        if(row == 1) {
            return new ResultUtil().setSuccessMsg("修改分店成功");
        }
        return new ResultUtil().setErrorMsg("修改失败，未找到此分店");
    }

}
