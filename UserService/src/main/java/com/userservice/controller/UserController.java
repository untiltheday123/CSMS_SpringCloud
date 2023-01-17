package com.userservice.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.userservice.domain.User;
import com.userservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * 查询saleId管理的客户
     * @param saleId
     * @param start
     * @return
     */
    @GetMapping("/{saleId}/{start}")
    public Result queryUserBySaleId(@PathVariable String saleId,@PathVariable int start){
        IPage<User> userIPage = userService.queryUserBySaleId(saleId, start);
        return new Result(userIPage!=null?Code.GET_OK:Code.GET_ERR,userIPage,null);
    }

    /**
     * 查询所有用户
     * @param start
     * @return
     */
    @GetMapping("/{start}")
    public Result queryAllUser(@PathVariable int start){
        IPage<User> userIPage = userService.queryAllUser(start);
        return new Result(userIPage!=null?Code.GET_OK:Code.GET_ERR,userIPage,null);
    }

    /**
     * 修改客户信息
     * @param user
     * @return
     */
    @PutMapping
    public Result updateUser(@RequestBody User user){
        Boolean flag = userService.updateUser(user);
        return new Result(flag?Code.UPDATE_OK:Code.UPDATE_ERR,flag,null);
    }

    /**
     * 条件查询user
     * @param start
     * @param user
     * @return
     */
    @GetMapping("/queryUserCondition/{start}")
    public Result queryUserCondition(@PathVariable int start,  User user){
        IPage<User> userIPage = userService.queryUserCondition(start, user);
        return new Result(userIPage!=null?Code.GET_OK:Code.GET_ERR,userIPage,null);
    }
}
