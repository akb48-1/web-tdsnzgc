package com.tdsnzgc.manage_web.service.seller.impl;

import com.tdsnzgc.common_web.config.account.service.impl.AccountServiceImpl;
import com.tdsnzgc.manage_web.pojo.seller.Seller;
import com.tdsnzgc.manage_web.pojo.seller.mapper.SellerMapper;
import com.tdsnzgc.manage_web.service.seller.SellerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class SellerServiceImpl implements SellerService {

    @Autowired
    AccountServiceImpl accountServiceImpl;

    @Autowired
    SellerMapper sellerMapper;

    @Override
    public List<Seller> queryAll() {
        Map map = new HashMap<>();
        map.put("organ_id", accountServiceImpl.getOrgan_ids());
        return sellerMapper.queryAll(map);
    }
}
