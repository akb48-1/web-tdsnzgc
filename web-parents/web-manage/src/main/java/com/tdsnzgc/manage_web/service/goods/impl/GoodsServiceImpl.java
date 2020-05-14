package com.tdsnzgc.manage_web.service.goods.impl;

import com.github.pagehelper.PageHelper;
import com.tdsnzgc.common_web.vo.PageVo;
import com.tdsnzgc.manage_web.pojo.classify.Classify;
import com.tdsnzgc.manage_web.pojo.goods.Goods;
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

    @Override
    public Goods queryById(BigInteger id) {
        return goodsMapper.queryById(id);
    }

    @Override
    public Map<String, Object> queryByPage(Map map) {
        PageHelper.startPage((int) map.get("pageNo"), (int) map.get("pageSize"));

        List<Goods> goodsList = goodsMapper.queryByPage(map);

        return new PageVo().setPageResult(goodsList);
    }

    @Override
    public int insert(Goods goods) {
        return goodsMapper.insert(goods);
    }

    @Override
    public int update(Goods goods) {
        return goodsMapper.update(goods);
    }

    @Override
    public int delete(BigInteger id) {
        return goodsMapper.delete(id);
    }
}
