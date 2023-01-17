package com.orderservice.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.orderservice.domain.Orders;
import com.orderservice.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    private OrderService orderService;
//    @Autowired
//    private RestTemplate restTemplate;

    /**
     * 查询所有订单
     * @param start
     * @return
     */
    @GetMapping("/{start}")
    public Result queryOrder(@PathVariable int start){
        IPage<Orders> ordersIPage = orderService.queryOrder(start);
        return new Result(ordersIPage!=null?Code.GET_OK:Code.GET_ERR,ordersIPage,null);
    }


    /**
     * 查询saleId管理的订单
     * @param saleId
     * @param start
     * @return
     */
    @GetMapping("/{saleId}/{start}")
    public Result queryOrdersBySaleId(@PathVariable String saleId, @PathVariable int start){
        IPage<Orders> ordersIPage = orderService.queryOrderBySalesId(saleId,start);
        return new Result(ordersIPage!=null?Code.GET_OK:Code.GET_ERR,ordersIPage,null);
    }

    /**
     * 删除订单
     * @param orderId
     * @return
     */
    @DeleteMapping("/{orderId}")
    public Result deleteOrder(@PathVariable String orderId){
        Boolean flag = orderService.deleteOrder(orderId);
        return new Result(flag?Code.DELETE_OK:Code.DELETE_ERR,flag,null);
    }

    /**
     * 条件查询order
     * @param start
     * @param order
     * @return
     */
    @GetMapping( "/queryOrderCondition/{start}")
    public Result queryOrderCondition(@PathVariable int start,  Orders order){
        IPage<Orders> orderIPage = orderService.queryOrderCondition(start, order);
        return new Result(orderIPage!=null?Code.GET_OK:Code.GET_ERR,orderIPage,null);
    }

    /**
     * 查询订单详情
     * @param orderId
     * @return
     */
    @RequestMapping(path = "/queryOrdersDetail/{orderId}",method = RequestMethod.GET)
    public Result queryOrdersDetail(@PathVariable String orderId,
                                    @RequestHeader(value = "Truth", required = false) String truth){
        System.out.println(truth);
        Orders orders = orderService.queryOrdersDetail(orderId);
//        System.out.println(orders);
        return new Result(orders.getGoodsList()!=null?Code.GET_OK:Code.GET_ERR,orders,null);
    }

}
