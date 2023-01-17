package com.userservice.serviceImpl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.userservice.dao.UserDaoMP;
import com.userservice.domain.User;
import com.userservice.service.UserService;
import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDaoMP userDaoMP;
//    @Autowired
//    private SearchSalesmanDao searchDao;

    @Override
    public IPage<User> queryUserBySaleId(String saleId, int start) {
        LambdaQueryWrapper<User> lqw = new LambdaQueryWrapper<User>();
        lqw.eq(User::getSaleId,saleId);
        IPage page = new Page(start, 10);
        userDaoMP.selectPage(page, lqw);
        return page;
    }

    @Override
    public IPage<User> queryAllUser(int start) {
        IPage page = new Page(start, 10);
        userDaoMP.selectPage(page,null);
        return page;
    }

    @Override
    public Boolean updateUser(User user) {
        int update = userDaoMP.updateById(user);
        return update > 0;
    }

    @Override
    public IPage<User> queryUserCondition(int start, User user) {
        LambdaQueryWrapper<User> lqw = new LambdaQueryWrapper<User>();
        lqw.like(Strings.isNotEmpty(user.getUserUsername()),User::getUserUsername,user.getUserUsername());
        lqw.like(Strings.isNotEmpty(user.getUserName()),User::getUserName,user.getUserName());
        lqw.like(Strings.isNotEmpty(user.getUserPhone()),User::getUserPhone,user.getUserPhone());
        lqw.like(Strings.isNotEmpty(user.getUserId()),User::getUserId,user.getUserId());
        lqw.like(Strings.isNotEmpty(user.getSaleId()),User::getSaleId,user.getSaleId());
        IPage page = new Page(start,10);
        userDaoMP.selectPage(page,lqw);
        return page;
    }

}
