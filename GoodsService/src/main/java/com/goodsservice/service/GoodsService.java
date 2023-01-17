package com.goodsservice.service;


import com.goodsservice.domain.Goods;

import java.util.List;

public interface GoodsService {

    List<Goods> queryGoodsByOrderId(String orderId);

}
