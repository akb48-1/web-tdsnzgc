package com.tdsnzgc.manage_web.pojo.goods.mapper;

import com.tdsnzgc.manage_web.pojo.base.mapper.BaseMapper;
import com.tdsnzgc.manage_web.pojo.goods.Goods;
import com.tdsnzgc.manage_web.pojo.goods.GoodsRecord;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;
import java.util.List;

@Mapper
@Repository
public interface GoodsRecordMapper extends BaseMapper<GoodsRecord> {
    int genBuyRecord(List recordList);
    List<GoodsRecord> queryByUniqueId(@Param(value="goods_unique_ids") String goods_unique_ids, @Param(value="organ_id") String organ_id);
}
