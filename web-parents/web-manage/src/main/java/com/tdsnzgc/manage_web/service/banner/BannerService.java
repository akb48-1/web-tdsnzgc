package com.tdsnzgc.manage_web.service.banner;

import com.tdsnzgc.manage_web.pojo.banner.Banner;
import com.tdsnzgc.manage_web.pojo.base.service.BaseService;

import java.util.List;
import java.util.Map;

public interface BannerService extends BaseService<Banner> {
    List<Banner> queryAll(Map map);
}
