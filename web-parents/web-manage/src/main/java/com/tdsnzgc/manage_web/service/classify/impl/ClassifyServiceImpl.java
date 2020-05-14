package com.tdsnzgc.manage_web.service.classify.impl;

import com.github.pagehelper.PageHelper;
import com.tdsnzgc.common_web.vo.PageVo;
import com.tdsnzgc.manage_web.pojo.classify.Classify;
import com.tdsnzgc.manage_web.pojo.classify.mapper.ClassifyMapper;
import com.tdsnzgc.manage_web.pojo.organ.Organ;
import com.tdsnzgc.manage_web.pojo.unit.Unit;
import com.tdsnzgc.manage_web.service.classify.ClassifyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.List;
import java.util.Map;

@Service
public class ClassifyServiceImpl implements ClassifyService {

    @Autowired
    ClassifyMapper classifyMapper;

    @Override
    public Classify queryById(BigInteger id) {
        return classifyMapper.queryById(id);
    }

    @Override
    public Map<String, Object> queryByPage(Map map) {
        PageHelper.startPage((int) map.get("pageNo"), (int) map.get("pageSize"));

        List<Classify> organs = classifyMapper.queryByPage(map);

        return new PageVo().setPageResult(organs);
    }

    @Override
    public int insert(Classify classify) {
        return classifyMapper.insert(classify);
    }

    @Override
    public int update(Classify classify) {
        return classifyMapper.update(classify);
    }

    @Override
    public int delete(BigInteger id) {
        return classifyMapper.delete(id);
    }

    @Override
    public List<Classify> queryAll() {
        return classifyMapper.queryAll();
    }
}
