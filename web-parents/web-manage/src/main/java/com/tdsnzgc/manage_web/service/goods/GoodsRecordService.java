package com.tdsnzgc.manage_web.service.goods;

import com.tdsnzgc.manage_web.pojo.base.service.BaseService;
import com.tdsnzgc.manage_web.pojo.goods.Goods;
import com.tdsnzgc.manage_web.pojo.goods.GoodsRecord;

import java.util.List;
import java.util.Map;

public interface GoodsRecordService {
    List<GoodsRecord> queryByUniqueId(String goods_unique_ids, String organ_id);
}
