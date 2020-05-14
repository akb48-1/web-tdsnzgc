package com.tdsnzgc.manage_web.service.unit;

import com.tdsnzgc.manage_web.pojo.base.service.BaseService;
import com.tdsnzgc.manage_web.pojo.unit.Unit;

import java.util.List;

public interface UnitService extends BaseService<Unit> {
    List<Unit> queryAll();
}
