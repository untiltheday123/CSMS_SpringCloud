package com.orderservice.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.orderservice.domain.Orders;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface OrderDaoMP extends BaseMapper<Orders> {
}
