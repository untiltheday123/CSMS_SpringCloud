package com.goodsservice.controller;


import com.goodsservice.domain.Goods;
import com.goodsservice.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/goods")
public class GoodsController {

    @Autowired
    private GoodsService goodsService;

//    /**
//     * 根据orderId查询商品
//     * @param orderId
//     * @return
//     */
//    @GetMapping("/{orderId}")
//    private Result queryGoodsByIds(@PathVariable String orderId){
//        List<Goods> goodsList = goodsService.queryGoodsByOrderId(orderId);
//
//        return new Result(goodsList!=null?Code.GET_OK:Code.GET_ERR,goodsList,null);
//    }

    /**
     * 根据orderId查询商品
     * @param orderId
     * @return
     */
    @GetMapping("/{orderId}")
    private Result queryGoodsByIds(@PathVariable String orderId){
        List<Goods> goodsList = goodsService.queryGoodsByOrderId(orderId);
        return new Result(goodsList!=null?Code.GET_OK:Code.GET_ERR,goodsList,null);
    }

}
