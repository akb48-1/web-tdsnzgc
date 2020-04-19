package com.tdsnzgc.manage_web.service.organ.impl;

import com.github.pagehelper.PageHelper;
import com.tdsnzgc.common_web.vo.PageVo;
import com.tdsnzgc.manage_web.pojo.organ.Organ;
import com.tdsnzgc.manage_web.pojo.organ.mapper.OrganMapper;
import com.tdsnzgc.manage_web.service.organ.OrganService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.List;
import java.util.Map;

@Service
public class OrganServiceImpl implements OrganService {

    @Autowired
    OrganMapper organMapper;


    @Override
    public Organ queryById(BigInteger organ_id) {
        return organMapper.queryById(organ_id);
    }

    @Override
    public Map queryByPage(Map map) {
        PageHelper.startPage((int) map.get("pageNo"), (int) map.get("pageSize"));

        List<Organ> organs = organMapper.queryByPage(map);

        return new PageVo().setPageResult(organs);
    }

    @Override
    public int insert(Organ organ) {
        return organMapper.insert(organ);
    }

    @Override
    public int update(Organ organ) {
        return 0;
    }


    @Override
    public int delete(BigInteger id) {
        return 0;
    }

}
