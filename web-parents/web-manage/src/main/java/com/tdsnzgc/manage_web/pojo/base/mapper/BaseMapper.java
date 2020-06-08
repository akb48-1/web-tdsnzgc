package com.tdsnzgc.manage_web.pojo.base.mapper;


import org.apache.ibatis.annotations.Param;

import java.math.BigInteger;
import java.util.List;
import java.util.Map;

public interface BaseMapper<T> {
    T queryById(BigInteger id);
    T queryById(@Param(value="id") BigInteger id, @Param(value="organ_id") BigInteger organ_id);
    List<T> queryByPage(Map map);
    int insert(T t);
    int update(T t);
    int delete(BigInteger id);
    int delete(@Param(value="id") BigInteger id, @Param(value="organ_id") BigInteger organ_id);
}
