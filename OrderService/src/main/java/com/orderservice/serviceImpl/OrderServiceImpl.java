package com.orderservice.serviceImpl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.feign.clients.GoodsClient;
import com.feign.domain.Goods;
import com.orderservice.dao.OrderDaoMP;
import com.orderservice.domain.Orders;
import com.orderservice.service.OrderService;
import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderDaoMP orderDaoMP;
//    @Autowired
//    private RestTemplate restTemplate;
    @Autowired
    private GoodsClient goodsClient;

    @Override
    public IPage<Orders> queryOrder(int start) {
        IPage page = new Page(start, 10);
        orderDaoMP.selectPage(page,null);
        return page;
    }

    @Override
    public IPage<Orders> queryOrderBySalesId(String saleId, int start) {
        LambdaQueryWrapper<Orders> lqw = new LambdaQueryWrapper<Orders>();
        lqw.eq(Orders::getSaleId,saleId);
        IPage page = new Page(start, 10);
        orderDaoMP.selectPage(page, lqw);
        return page;
    }

    @Override
    public Boolean deleteOrder(String orderId) {
        int delete = orderDaoMP.deleteById(orderId);
        return delete == 1;
    }

    @Override
    public IPage<Orders> queryOrderCondition(int start, Orders order) {
        LambdaQueryWrapper<Orders> lqw = new LambdaQueryWrapper<Orders>();
        lqw.like(Strings.isNotEmpty(order.getOrderId()), Orders::getOrderId, order.getOrderId());
        lqw.like(Strings.isNotEmpty(order.getOrderState()), Orders::getOrderState, order.getOrderState());
        lqw.like(Strings.isNotEmpty(order.getOrderTime()), Orders::getOrderTime, order.getOrderTime());
        lqw.like(Strings.isNotEmpty(order.getUserId()), Orders::getUserId, order.getUserId());
        lqw.like(Strings.isNotEmpty(order.getSaleId()), Orders::getSaleId, order.getSaleId());
        IPage page = new Page(start, 10);
        orderDaoMP.selectPage(page, lqw);
        return page;
    }

    @Override
    public Orders queryOrdersDetail(String orderId) {
        /*
          使用restTemplate远程调用
         */
////        1.先查询订单
//        Orders orders = orderDaoMP.selectById(orderId);
////        2.利用RestTemplate发起HTTP请求
////        2.1url路径
//        String url = "http://goodsservice/goods/" + orderId;
//        Goods[] goods = restTemplate.getForObject(url, Goods[].class);
////        System.out.println(Arrays.toString(goods));
//        List<Goods> goodsList = goods!=null?Arrays.asList(goods):null;
////        System.out.println(goodsList);
//        orders.setGoodsList(goodsList);

        /*
        使用Feign远程调用
         */
//        1.先查询订单
        Orders orders = orderDaoMP.selectById(orderId);
//        2.利用Feign远程调用
        Goods[] goods = goodsClient.findById(orderId);
        List<Goods> goodsList = goods!=null?Arrays.asList(goods):null;
//        3.封装到order
        orders.setGoodsList(goodsList);
//        4.返回order
        return orders;
    }

}
