package com.tdsnzgc.manage_web.controller.classify;

import com.tdsnzgc.common_web.config.account.service.impl.AccountServiceImpl;
import com.tdsnzgc.common_web.config.resultUtil.Result;
import com.tdsnzgc.common_web.config.resultUtil.ResultUtil;
import com.tdsnzgc.common_web.vo.PageVo;
import com.tdsnzgc.manage_web.pojo.classify.Classify;
import com.tdsnzgc.manage_web.pojo.organ.Organ;
import com.tdsnzgc.manage_web.pojo.unit.Unit;
import com.tdsnzgc.manage_web.service.classify.ClassifyService;
import com.tdsnzgc.manage_web.service.unit.UnitService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigInteger;
import java.util.List;
import java.util.Map;

@Api(tags = "分类Controller")
@RestController
@RequestMapping("/classify")
public class ClassifyController {

    @Autowired
    ClassifyService classifyService;

    @Autowired
    AccountServiceImpl accountServiceImpl;

    @ApiOperation("所有单分类")
    @PostMapping("/queryAll")
    public Result queryAll() {
        List<Classify> unitList = classifyService.queryAll();
        return new ResultUtil().setData(unitList);
    }

    @ApiOperation("分类列表翻页")
    @PostMapping("/queryByPage")
    public Result queryByPage(@RequestBody Map map, Classify classify, PageVo pageVo) {
        Map data = classifyService.queryByPage(new PageVo().setParams(map));
        return new ResultUtil().setData(data);
    }

    @ApiOperation("新增分类")
    @PostMapping("/addClassify")
    public Result addRole(@RequestBody Classify classify) {
        classify.setCreateer_name();
        classify.setOrgan_id(new BigInteger(accountServiceImpl.getOrgan_ids()));
        int row = classifyService.insert(classify);

        if(row == 1) {
            return new ResultUtil().setSuccessMsg("添加分类成功");
        }
        return new ResultUtil().setErrorMsg("添加分类失败");
    }

    @PostMapping("/updateClassify")
    public Result updateClassify(@RequestBody Classify classify) {

        classify.setUpdateer_name();;

        int row = classifyService.update(classify);

        if(row == 1) {
            return new ResultUtil().setSuccessMsg("修改分类成功");
        }
        return new ResultUtil().setErrorMsg("修改失败，未找到此分类");
    }

//    @ApiOperation("删除分类")
//    @PostMapping("/deleteClassify/{id}")
//    public Result deleteRole(@PathVariable(name ="id") BigInteger role_id) {
//
//        // 查询是否正在启用
//        int qrow = goodsService.queryUsingRoleById(goods_id);
//
//        if(qrow > 0) {
//
//            return new ResultUtil().setErrorMsg("删除失败，还有其他用户在使用该角色");
//        }
//
//        int drow = classifyService.delete(role_id);
//
//        if(drow > 0) {
//            return new ResultUtil().setSuccessMsg("删除角色成功");
//        }
//
//        return new ResultUtil().setErrorMsg("角色不存在");
//    }
}
