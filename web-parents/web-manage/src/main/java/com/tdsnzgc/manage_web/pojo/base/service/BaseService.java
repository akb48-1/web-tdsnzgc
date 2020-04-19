package com.tdsnzgc.manage_web.pojo.base.service;

import com.tdsnzgc.common_web.vo.PageVo;

import java.math.BigInteger;
import java.util.Map;

public interface BaseService<T> {
    T queryById(BigInteger id);
    Map<String, Object> queryByPage(Map map);
    int insert(T t);
    int update(T t);
    int delete(BigInteger id);
}
