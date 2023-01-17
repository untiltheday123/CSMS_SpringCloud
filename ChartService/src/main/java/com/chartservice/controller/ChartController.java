package com.chartservice.controller;

import com.chartservice.domain.Profile;
import com.chartservice.service.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/charts")
public class ChartController {

    @Autowired
    private ProfileService profileService;

    /**
     * 查询销售总量
     * @return
     */
    @RequestMapping(path="/querySaleTotal",method = RequestMethod.GET)
    public Result querySaleTotal(){
        List<Profile> saleTotal = profileService.querySaleTotal();
        return new Result(saleTotal != null ? Code.GET_OK :Code.GET_ERR,saleTotal,null);
    }

    /**
     * 查询客户数量
     * @return
     */
    @RequestMapping(path="/queryUserNum",method = RequestMethod.GET)
    public Result queryUserNum(){
        List<Profile> userNum = profileService.queryUserNum();
        return new Result(userNum != null ? Code.GET_OK :Code.GET_ERR,userNum,null);
    }
}
