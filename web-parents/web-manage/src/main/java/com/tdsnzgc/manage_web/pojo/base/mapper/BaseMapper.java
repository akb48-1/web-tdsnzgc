package com.tdsnzgc.manage_web.pojo.base.mapper;


import java.math.BigInteger;
import java.util.List;
import java.util.Map;

public interface BaseMapper<T> {
    T queryById(BigInteger id);
    List<T> queryByPage(Map map);
    int insert(T t);
    int update(T t);
    int delete(BigInteger id);
}
