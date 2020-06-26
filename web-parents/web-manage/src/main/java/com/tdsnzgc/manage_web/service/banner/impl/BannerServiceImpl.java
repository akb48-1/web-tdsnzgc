package com.tdsnzgc.manage_web.service.banner.impl;

import com.github.pagehelper.PageHelper;
import com.tdsnzgc.common_web.config.account.service.impl.AccountServiceImpl;
import com.tdsnzgc.common_web.vo.PageVo;
import com.tdsnzgc.manage_web.pojo.banner.Banner;
import com.tdsnzgc.manage_web.pojo.banner.mapper.BannerMapper;
import com.tdsnzgc.manage_web.service.banner.BannerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.List;
import java.util.Map;

@Service
public class BannerServiceImpl implements BannerService {

    @Autowired
    BannerMapper bannerMapper;

    @Autowired
    AccountServiceImpl accountServiceImpl;

    @Override
    public Banner queryById(BigInteger id) {

        BigInteger organ_ids = new BigInteger(accountServiceImpl.getOrgan_ids());

        return bannerMapper.queryById(id, organ_ids);

    }

    @Override
    public Map<String, Object> queryByPage(Map map) {

        PageHelper.startPage((int) map.get("pageNo"), (int) map.get("pageSize"));

        map.put("organ_id", accountServiceImpl.getOrgan_ids());

        List<Banner> bannerList = bannerMapper.queryByPage(map);

        return new PageVo().setPageResult(bannerList);
    }

    @Override
    public int insert(Banner banner) {
        banner.setOrgan_id(new BigInteger(accountServiceImpl.getOrgan_ids()));
        return bannerMapper.insert(banner);
    }

    @Override
    public int update(Banner banner) {

        banner.setOrgan_id(new BigInteger(accountServiceImpl.getOrgan_ids()));
        return bannerMapper.update(banner);
    }

    @Override
    public int delete(BigInteger id) {
        String organ_ids = accountServiceImpl.getOrgan_ids();
        return bannerMapper.delete(id, new BigInteger(organ_ids));
    }


    @Override
    public List<Banner> queryAll(Map map) {
        map.put("organ_id", accountServiceImpl.getOrgan_ids());
        List<Banner> bannerList = bannerMapper.queryAll(map);
        return bannerList;
    }
}
