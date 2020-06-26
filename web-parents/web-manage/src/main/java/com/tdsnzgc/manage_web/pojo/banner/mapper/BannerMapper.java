package com.tdsnzgc.manage_web.pojo.banner.mapper;


import com.tdsnzgc.manage_web.pojo.banner.Banner;
import com.tdsnzgc.manage_web.pojo.base.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;
import java.util.List;
import java.util.Map;


@Mapper
@Repository
public interface BannerMapper extends BaseMapper<Banner> {
    List<Banner> queryAll(Map map);
}
