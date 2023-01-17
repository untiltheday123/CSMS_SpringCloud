package com.managerservice.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.managerservice.domain.Manager;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ManagerDaoMP extends BaseMapper<Manager> {
}
