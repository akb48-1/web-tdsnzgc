package com.tdsnzgc.manage_web.pojo.seller.mapper;


import com.tdsnzgc.manage_web.pojo.base.mapper.BaseMapper;
import com.tdsnzgc.manage_web.pojo.seller.Seller;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Mapper
@Repository
public interface SellerMapper extends BaseMapper<Seller> {
    List<Seller> queryAll(Map map);
}
