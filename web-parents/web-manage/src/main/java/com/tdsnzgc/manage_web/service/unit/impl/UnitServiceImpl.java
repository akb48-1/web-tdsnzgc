package com.tdsnzgc.manage_web.service.unit.impl;

import com.github.pagehelper.PageHelper;
import com.tdsnzgc.common_web.vo.PageVo;
import com.tdsnzgc.manage_web.pojo.base.service.BaseService;
import com.tdsnzgc.manage_web.pojo.unit.Unit;
import com.tdsnzgc.manage_web.pojo.unit.mapper.UnitMapper;
import com.tdsnzgc.manage_web.service.unit.UnitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.List;
import java.util.Map;

@Service
public class UnitServiceImpl implements UnitService {

    @Autowired
    UnitMapper unitMapper;

    @Override
    public Unit queryById(BigInteger id) {
        return null;
    }

    @Override
    public Map<String, Object> queryByPage(Map map) {
        PageHelper.startPage((int) map.get("pageNo"), (int) map.get("pageSize"));

        List<Unit> roleList = unitMapper.queryByPage(map);

        return new PageVo().setPageResult(roleList);
    }

    @Override
    public int insert(Unit unit) {
        return unitMapper.insert(unit);
    }

    @Override
    public int update(Unit unit) {
        return 0;
    }

    @Override
    public int delete(BigInteger id) {
        return 0;
    }

    @Override
    public List<Unit> queryAll() {
        return unitMapper.queryAll();
    }
}
