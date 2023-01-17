package com.managerservice.controller;

import com.managerservice.domain.Manager;
import com.managerservice.service.ManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/managers")
public class ManagerController {
    @Autowired
    private ManagerService managerService;

    /**
     * 管理员登录
     * @param manager
     * @return
     */
    @PostMapping
    public Result managerLogin(@RequestBody Manager manager){
        Manager manager1 = managerService.managerLogin(manager);
        return new Result(manager1!=null?Code.GET_OK:Code.GET_ERR,manager1,null);
    }
}
