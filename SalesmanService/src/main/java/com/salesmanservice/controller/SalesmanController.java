package com.salesmanservice.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.salesmanservice.domain.Salesman;
import com.salesmanservice.service.SalesmanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/salesmen")
public class SalesmanController {

    @Autowired
    private SalesmanService salesmanService;

    /**
     * 销售员登录
     * @param salesman
     * @return
     */
    @PostMapping
    public Result salesmanLogin(@RequestBody Salesman salesman){
        Salesman salesman1 = salesmanService.salesmanLogin(salesman);
        return new Result(salesman1!=null?Code.GET_OK:Code.GET_ERR,salesman1,null);
    }

    /**
     * 查询所有销售人员
     * @param start
     * @return
     */
    @GetMapping("/{start}")
    public Result queryAllSalesman(@PathVariable int start){
        IPage<Salesman> salesmanIPage = salesmanService.queryAllSalesman(start);
        return new Result(salesmanIPage!=null?Code.GET_OK:Code.GET_ERR,salesmanIPage,null);
    }

    /**
     * 修改销售人员信息
     * @param salesman
     * @return
     */
    @PutMapping
    public Result updateSalesman(@RequestBody Salesman salesman){
        Boolean flag = salesmanService.updateSalesman(salesman);
        return new Result(flag?Code.UPDATE_OK:Code.UPDATE_ERR,flag,null);
    }

    /**
     * 条件查询salesman
     * @param start
     * @param salesman
     * @return
     */
    @GetMapping("/querySalesmanCondition/{start}")
    public Result querySalesmanCondition(@PathVariable int start,Salesman salesman){
        IPage<Salesman> salesmanIPage = salesmanService.querySalesmanCondition(start, salesman);
        return new Result(salesmanIPage!=null?Code.GET_OK:Code.GET_ERR,salesmanIPage,null);
    }

}
