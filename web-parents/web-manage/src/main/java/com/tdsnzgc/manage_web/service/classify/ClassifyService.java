package com.tdsnzgc.manage_web.service.classify;

import com.tdsnzgc.manage_web.pojo.base.service.BaseService;
import com.tdsnzgc.manage_web.pojo.classify.Classify;

import java.util.List;

public interface ClassifyService extends BaseService<Classify> {
    List<Classify> queryAll();
}
