package com.tdsnzgc.manage_web.controller.goods;

import com.tdsnzgc.common_web.config.account.service.impl.AccountServiceImpl;
import com.tdsnzgc.common_web.config.resultUtil.Result;
import com.tdsnzgc.common_web.config.resultUtil.ResultUtil;
import com.tdsnzgc.common_web.vo.PageVo;
import com.tdsnzgc.manage_web.pojo.goods.Goods;
import com.tdsnzgc.manage_web.pojo.goods.GoodsRecord;
import com.tdsnzgc.manage_web.service.goods.GoodsRecordService;
import com.tdsnzgc.manage_web.service.goods.GoodsService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigInteger;
import java.util.Map;

@Api(tags = "商品记录Controller")
@RestController
@RequestMapping("/goodsRecord")
public class GoodsRecordController {

    @Autowired
    GoodsRecordService goodsRecordService;

    @Autowired
    AccountServiceImpl accountServiceImpl;


}

