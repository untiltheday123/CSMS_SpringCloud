package com.orderservice.service;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.orderservice.domain.Orders;

import java.util.List;

public interface OrderService {
    IPage<Orders> queryOrder(int start);

    IPage<Orders> queryOrderBySalesId(String saleId, int start);

    Boolean deleteOrder(String orderId);

    IPage<Orders> queryOrderCondition(int start, Orders order);

    Orders queryOrdersDetail(String orderId);
}
