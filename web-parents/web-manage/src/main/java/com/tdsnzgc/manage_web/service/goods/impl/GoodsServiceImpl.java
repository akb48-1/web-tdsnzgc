package com.tdsnzgc.manage_web.service.goods.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.tdsnzgc.common_web.config.account.service.impl.AccountServiceImpl;
import com.tdsnzgc.common_web.vo.PageVo;
import com.tdsnzgc.manage_web.pojo.classify.Classify;
import com.tdsnzgc.manage_web.pojo.goods.Goods;
import com.tdsnzgc.manage_web.pojo.goods.GoodsRecord;
import com.tdsnzgc.manage_web.pojo.goods.mapper.GoodsMapper;
import com.tdsnzgc.manage_web.pojo.organ.mapper.OrganMapper;
import com.tdsnzgc.manage_web.service.goods.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.List;
import java.util.Map;

@Service
public class GoodsServiceImpl implements GoodsService {

    @Autowired
    GoodsMapper goodsMapper;

    @Autowired
    AccountServiceImpl accountServiceImpl;

    @Override
    public Goods queryById(BigInteger id) {

        BigInteger organ_ids = new BigInteger(accountServiceImpl.getOrgan_ids());

        return goodsMapper.queryById(id, organ_ids);

    }

    @Override
    public Map<String, Object> queryByPage(Map map) {

        PageHelper.startPage((int) map.get("pageNo"), (int) map.get("pageSize"));

        map.put("organ_id", accountServiceImpl.getOrgan_ids());

        List<Goods> goodsList = goodsMapper.queryByPage(map);

        return new PageVo().setPageResult(goodsList);
    }

    @Override
    public int insert(Goods goods) {
        if(goods.getClassify_ids() == null) {
            goods.setClassify_ids("");
        }
        goods.setClassify_ids("," + goods.getClassify_ids() + ",");
        goods.setOrgan_id(new BigInteger(accountServiceImpl.getOrgan_ids()));
        return goodsMapper.insert(goods);
    }

    @Override
    public int update(Goods goods) {
        if(goods.getClassify_ids() == null) {
            goods.setClassify_ids("");
        }
        goods.setClassify_ids("," + goods.getClassify_ids() + ",");
        goods.setOrgan_id(new BigInteger(accountServiceImpl.getOrgan_ids()));
        return goodsMapper.update(goods);
    }

    @Override
    public int delete(BigInteger id) {
        return 0;
    }


}
