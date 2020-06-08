package com.tdsnzgc.manage_web.service.goods.impl;

import com.github.pagehelper.PageHelper;
import com.tdsnzgc.common_web.config.account.service.impl.AccountServiceImpl;
import com.tdsnzgc.common_web.vo.PageVo;
import com.tdsnzgc.manage_web.pojo.goods.Goods;
import com.tdsnzgc.manage_web.pojo.goods.GoodsRecord;
import com.tdsnzgc.manage_web.pojo.goods.mapper.GoodsMapper;
import com.tdsnzgc.manage_web.pojo.goods.mapper.GoodsRecordMapper;
import com.tdsnzgc.manage_web.service.goods.GoodsRecordService;
import com.tdsnzgc.manage_web.service.goods.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.List;
import java.util.Map;

@Service
public class GoodsRecordServiceImpl implements GoodsRecordService {

    @Autowired
    GoodsRecordMapper goodsRecordMapper;

    @Autowired
    AccountServiceImpl accountServiceImpl;

    @Override
    public List<GoodsRecord> queryByUniqueId(String goods_unique_ids, String organ_id) {
        return goodsRecordMapper.queryByUniqueId(goods_unique_ids, organ_id);
    }

}
