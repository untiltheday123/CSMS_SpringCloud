package com.userservice.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.userservice.domain.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserDaoMP extends BaseMapper<User> {
}
