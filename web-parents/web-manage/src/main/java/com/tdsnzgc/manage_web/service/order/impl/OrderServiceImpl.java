package com.tdsnzgc.manage_web.service.order.impl;

import cn.hutool.core.date.DateUtil;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import com.github.pagehelper.PageHelper;
import com.tdsnzgc.common_web.config.account.service.impl.AccountServiceImpl;
import com.tdsnzgc.common_web.config.resultUtil.Result;
import com.tdsnzgc.common_web.config.resultUtil.ResultUtil;
import com.tdsnzgc.common_web.vo.PageVo;
import com.tdsnzgc.manage_web.pojo.goods.GoodsRecord;
import com.tdsnzgc.manage_web.pojo.goods.mapper.GoodsMapper;
import com.tdsnzgc.manage_web.pojo.goods.mapper.GoodsRecordMapper;
import com.tdsnzgc.manage_web.pojo.order.Order;
import com.tdsnzgc.manage_web.pojo.order.mapper.OrderMapper;
import com.tdsnzgc.manage_web.service.order.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.*;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    OrderMapper orderMapper;

    @Autowired
    GoodsMapper goodsMapper;

    @Autowired
    GoodsRecordMapper goodsRecordMapper;

    @Autowired
    AccountServiceImpl accountServiceImpl;

    @Override
    public Order queryById(BigInteger id) {
        String organ_id = accountServiceImpl.getOrgan_ids();
        BigInteger organ_ids = new BigInteger(accountServiceImpl.getOrgan_ids());
        Order order = orderMapper.queryById(id, organ_ids);

        List<GoodsRecord> goodsRecords = goodsRecordMapper.queryByUniqueId(order.getOrder_goods_unique_ids(), organ_id);
        order.setGoodsRecords(goodsRecords);
        return order;
    }



    @Override
    public Map<String, Object> queryByPage(Map map) {

        PageHelper.startPage((int) map.get("pageNo"), (int) map.get("pageSize"));

        String organ_id = accountServiceImpl.getOrgan_ids();
        map.put("organ_id", organ_id);

        List<Order>  orderList = orderMapper.queryByPage(map);

        for (Order order:orderList) {
            List<GoodsRecord> goodsRecords = goodsRecordMapper.queryByUniqueId(order.getOrder_goods_unique_ids(), organ_id);
            order.setGoodsRecords(goodsRecords);
        }


        return new PageVo().setPageResult(orderList);
    }

    @Override
    public int insert(Order order) {
        return 0;
    }

    @Override
    public int update(Order order) {
        return 0;
    }

    @Override
    public int delete(BigInteger id) {
        return 0;
    }

    @Override
    public Result addOrder(Map map) {
        List goodsList = (List<HashMap>) map.get("goodsList");
        if(goodsList == null || goodsList.size() == 0) {
            return new ResultUtil().setErrorMsg("未选购商品");
        }

        List<GoodsRecord> list = new ArrayList<>();
        String order_time = map.get("order_time").toString();
        Date parseDate = DateUtil.parseDate(order_time);

        for (Object goods : goodsList) {
            JSONObject jsonObject = JSONUtil.parseObj(goods);
            BigInteger goods_id = new BigInteger(jsonObject.get("goods_id").toString());
            String goods_name = (String) jsonObject.get("goods_name");
            String goods_desc = (String) jsonObject.get("goods_desc");
            int type = (int) jsonObject.get("type");
            int amount = (int) jsonObject.get("amount");
            BigInteger unit_id = new BigInteger(jsonObject.get("unit_id").toString());
            String unit_name = (String) jsonObject.get("unit_name");
            BigInteger organ_id = new BigInteger(jsonObject.get("organ_id").toString());
            BigDecimal goods_price = new BigDecimal(jsonObject.get("goods_price").toString());
            BigDecimal goods_total_price = new BigDecimal(jsonObject.get("goods_total_price").toString());

            GoodsRecord g = new GoodsRecord();
            g.setCreateer_name();
            g.setGoods_id(goods_id);
            g.setGoods_name(goods_name);
            g.setGoods_desc(goods_desc);
            g.setGoods_price(goods_price);
            g.setGoods_total_price(goods_total_price);
            g.setType(type);
            g.setUnit_id(unit_id);
            g.setUnit_name(unit_name);
            g.setOrgan_id(organ_id);
            g.setAmount(amount);
            g.setOrder_time(parseDate);

            list.add(g);
        }

        int row = goodsRecordMapper.genBuyRecord(list);

        if(row == 0) {
            return new ResultUtil().setErrorMsg("生成商品交易记录失败");
        } else {
            String goods_unique_id = ",";
            for (GoodsRecord g: list) {
                goods_unique_id += g.getGoods_unique_id() + ",";
            }
            map.put("order_goods_unique_ids", goods_unique_id);
            map.put("createer_name", accountServiceImpl.getPrincipal());
            map.put("organ_id", accountServiceImpl.getOrgan_ids());

            int row2 = orderMapper.insert(map);

            if(row2 > 0) {
                return new ResultUtil().setSuccessMsg("新增订单成功");
            } else {
                return new ResultUtil().setErrorMsg("新增订单失败");
            }
        }

    }

    @Override
    public Map queryReport(Map map) {

        map.put("organ_id", accountServiceImpl.getOrgan_ids());
        List<Order> allOrderList = orderMapper.queryReport(map); // 查所有

        PageHelper.startPage((int) map.get("pageNo"), (int) map.get("pageSize"));
        List<Order> pageOrderList = orderMapper.queryReport(map); // 查分页

        BigDecimal total_order_price = new BigDecimal("0.00");
        BigDecimal total_real_price = new BigDecimal("0.00");
        BigDecimal total_payment_price = new BigDecimal("0.00");
        for (Order order : allOrderList) {
            total_order_price = total_order_price.add(order.getOrder_price());
            total_real_price = total_real_price.add(order.getReal_price());
            total_payment_price = total_payment_price.add(order.getPayment_price());
        }
        Map<String, Object> totalMap = new HashMap();
        totalMap.put("total_order_price", total_order_price);
        totalMap.put("total_real_price", total_real_price);
        totalMap.put("total_payment_price", total_payment_price);
        totalMap.put("total", allOrderList.size());

        Map pageResult = new PageVo().setPageResult(pageOrderList);
        pageResult.put("totalInfo", totalMap);
        return pageResult;
    }
}
