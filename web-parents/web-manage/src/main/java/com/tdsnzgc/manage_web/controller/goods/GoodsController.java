package com.tdsnzgc.manage_web.controller.goods;

import com.tdsnzgc.common_web.config.resultUtil.Result;
import com.tdsnzgc.common_web.config.resultUtil.ResultUtil;
import com.tdsnzgc.common_web.vo.PageVo;
import com.tdsnzgc.manage_web.pojo.goods.Goods;
import com.tdsnzgc.manage_web.pojo.role.Role;
import com.tdsnzgc.manage_web.service.goods.GoodsService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigInteger;
import java.util.Map;

@Api(tags = "商品Controller")
@RestController
@RequestMapping("/goods")
public class GoodsController {

    @Autowired
    GoodsService goodsService;

    @ApiOperation("商品列表翻页")
    @PostMapping("/queryById/{id}")
    public Result queryByPage(@PathVariable(name ="id") BigInteger good_id) {
        Goods good = goodsService.queryById(good_id);
        return new ResultUtil().setData(good);
    }

    @ApiOperation("商品列表翻页")
    @PostMapping("/queryByPage")
    public Result queryByPage(@RequestBody Map map, Goods goods, PageVo pageVo) {
        Map data = goodsService.queryByPage(new PageVo().setParams(map));
        return new ResultUtil().setData(data);
    }

    @ApiOperation("商品分类")
    @PostMapping("/addGoods")
    public Result addGoods(@RequestBody Goods goods) {
        goods.setCreateer_name();
        goods.setOrgan_id(new BigInteger("101"));
        int row = goodsService.insert(goods);

        if(row == 1) {
            return new ResultUtil().setSuccessMsg("添加商品成功");
        }
        return new ResultUtil().setErrorMsg("添加商品失败");
    }

    @PostMapping("/updateGoods")
    public Result updateGoods(@RequestBody Goods goods) {

        goods.setUpdateer_name();

        int row = goodsService.update(goods);

        if(row == 1) {
            return new ResultUtil().setSuccessMsg("修改商品成功");
        }
        return new ResultUtil().setErrorMsg("修改失败，未找到此商品");
    }

}

