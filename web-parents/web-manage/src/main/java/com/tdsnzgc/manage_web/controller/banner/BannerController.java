package com.tdsnzgc.manage_web.controller.banner;


import com.tdsnzgc.common_web.config.account.service.impl.AccountServiceImpl;
import com.tdsnzgc.common_web.config.resultUtil.Result;
import com.tdsnzgc.common_web.config.resultUtil.ResultUtil;
import com.tdsnzgc.common_web.vo.PageVo;
import com.tdsnzgc.manage_web.pojo.banner.Banner;
import com.tdsnzgc.manage_web.pojo.carType.CarType;
import com.tdsnzgc.manage_web.pojo.goods.Goods;
import com.tdsnzgc.manage_web.service.banner.BannerService;
import com.tdsnzgc.manage_web.service.carType.CarTypeService;
import com.tdsnzgc.manage_web.service.goods.GoodsService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigInteger;
import java.util.List;
import java.util.Map;

@Api(tags = "轮播图Controller")
@RestController
@RequestMapping("/banner")
public class BannerController {

    @Autowired
    BannerService bannerService;

    @Autowired
    AccountServiceImpl accountServiceImpl;

    @ApiOperation("轮播图详情")
    @PostMapping("/queryById/{id}")
    public Result queryByPage(@PathVariable(name ="id") BigInteger banner_id) {
        Banner banner = bannerService.queryById(banner_id);
        return new ResultUtil().setData(banner);
    }

    @ApiOperation("轮播图列表翻页")
    @PostMapping("/queryByPage")
    public Result queryByPage(@RequestBody Map map, Banner banner, PageVo pageVo) {
        Map data = bannerService.queryByPage(new PageVo().setParams(map));
        return new ResultUtil().setData(data);
    }

    @ApiOperation("新增轮播图")
    @PostMapping("/addBanner")
    public Result addBanner(@RequestBody Banner banner) {
        banner.setCreateer_name();
        int row = bannerService.insert(banner);

        if(row == 1) {
            return new ResultUtil().setSuccessMsg("添加轮播图成功");
        }
        return new ResultUtil().setErrorMsg("添加轮播图失败");
    }

    @PostMapping("/updateBanner")
    public Result updateGoods(@RequestBody Banner banner) {

        banner.setUpdateer_name();

        int row = bannerService.update(banner);

        if(row == 1) {
            return new ResultUtil().setSuccessMsg("修改轮播图成功");
        }
        return new ResultUtil().setErrorMsg("修改失败，未找到此轮播图");
    }

    @PostMapping("/deleteBanner/{id}")
    public Result deleteBanner(@PathVariable(name ="id") BigInteger banner_id) {

        int row = bannerService.delete(banner_id);

        if(row == 1) {
            return new ResultUtil().setSuccessMsg("删除轮播图成功");
        }
        return new ResultUtil().setErrorMsg("删除失败，未找到此轮播图");
    }

    @PostMapping("/queryAll")
    public Result queryAll(@RequestBody Map map) {

        List<Banner> bannerList = bannerService.queryAll(map);

        return new ResultUtil().setData(bannerList);
    }
}
