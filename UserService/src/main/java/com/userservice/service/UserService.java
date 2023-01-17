package com.userservice.service;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.userservice.domain.User;

public interface UserService {

    IPage<User> queryUserBySaleId(String saleId, int start);

    IPage<User> queryAllUser(int start);

    Boolean updateUser(User user);

    IPage<User> queryUserCondition(int start, User user);
}
