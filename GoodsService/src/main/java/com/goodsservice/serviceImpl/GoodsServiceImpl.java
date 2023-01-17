package com.goodsservice.serviceImpl;

import com.goodsservice.dao.GoodsDaoMP;
import com.goodsservice.domain.Goods;
import com.goodsservice.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class GoodsServiceImpl implements GoodsService {

    @Autowired
    private GoodsDaoMP goodsDaoMP;

    @Override
    public List<Goods> queryGoodsByOrderId(String orderId) {
        List<Goods> goodsList = goodsDaoMP.queryGoodsByOrderId(orderId);
        System.out.println(goodsList);
        return goodsList;
    }
}
