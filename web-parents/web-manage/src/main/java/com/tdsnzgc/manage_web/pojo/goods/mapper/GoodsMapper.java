package com.tdsnzgc.manage_web.pojo.goods.mapper;

import com.tdsnzgc.manage_web.pojo.base.mapper.BaseMapper;
import com.tdsnzgc.manage_web.pojo.base.service.BaseService;
import com.tdsnzgc.manage_web.pojo.goods.Goods;
import com.tdsnzgc.manage_web.pojo.goods.GoodsRecord;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Mapper
@Repository
public interface GoodsMapper extends BaseMapper<Goods> {
}
