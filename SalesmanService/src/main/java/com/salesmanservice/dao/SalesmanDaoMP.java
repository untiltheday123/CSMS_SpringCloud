package com.salesmanservice.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.salesmanservice.domain.Salesman;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface SalesmanDaoMP extends BaseMapper<Salesman> {
}
