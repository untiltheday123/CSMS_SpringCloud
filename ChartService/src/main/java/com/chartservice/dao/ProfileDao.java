package com.chartservice.dao;

import com.chartservice.domain.Profile;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface ProfileDao {

    @Select("select orders.sale_id,sale_name as name,sum(order_total) as value from orders,salesman where orders.sale_id = salesman.sale_id group by orders.sale_id order by value desc ")
    List<Profile> querySaleTotal();

    @Select("select orders.sale_id,sale_name as name, count(distinct user_id) as value from orders,salesman where orders.sale_id = salesman.sale_id group by sale_id")
    List<Profile> queryUserNum();

}




