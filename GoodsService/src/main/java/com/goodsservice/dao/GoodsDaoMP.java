package com.goodsservice.dao;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.goodsservice.domain.Goods;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface GoodsDaoMP {
//public interface GoodsDaoMP extends BaseMapper<Goods> {

    @Select("select product.pro_id,product.pro_name,product.pro_detail,product.pro_price,order_pro.pro_num,order_pro.pro_total,orders.order_state,product.pro_url " +
            "from order_pro,product,orders " +
            "where orders.order_id=order_pro.order_id " +
            "and order_pro.order_id=#{order_id} " +
            "and order_pro.pro_id=product.pro_id")
    List<Goods> queryGoodsByOrderId(@Param("order_id") String orderId);
}
