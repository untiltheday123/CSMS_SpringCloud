package com.orderservice.domain;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.feign.domain.Goods;
import lombok.Data;

import java.util.List;

@Data
public class Orders {
    @TableId
    String orderId;
    String orderTime;
    String orderState;
    Float orderTotal;
    String saleId;
    String userId;

    @TableField(exist = false)
    List<Goods> goodsList;
}
