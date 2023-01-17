package com.salesmanservice.serviceImpl;//package com.csms.service.impl;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.salesmanservice.dao.SalesmanDaoMP;
import com.salesmanservice.domain.Salesman;
import com.salesmanservice.service.SalesmanService;
import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class SalesmanServiceImpl implements SalesmanService {

    @Autowired
    private SalesmanDaoMP salesmanDaoMP;


    @Override
    public Salesman salesmanLogin(Salesman salesman) {
        Map<String,Object> map = new HashMap<>();
        map.put("sale_username",salesman.getSaleUsername());
        map.put("sale_password",salesman.getSalePassword());
        List<Salesman> salesmanList = salesmanDaoMP.selectByMap(map);
        return salesmanList.size() == 1 ? salesmanList.get(0):null;
    }

    @Override
    public IPage<Salesman> queryAllSalesman(int start) {
        IPage page = new Page(start,10);
        salesmanDaoMP.selectPage(page,null);
//        System.out.println(page.getRecords());
        return page;
    }

    @Override
    public Boolean updateSalesman(Salesman salesman) {
        int flag = salesmanDaoMP.updateById(salesman);
        return flag > 0;
    }

    @Override
    public IPage<Salesman> querySalesmanCondition(int start, Salesman salesman) {
        LambdaQueryWrapper<Salesman> lqw = new LambdaQueryWrapper<Salesman>();
        lqw.like(Strings.isNotEmpty(salesman.getSaleUsername()),Salesman::getSaleUsername,salesman.getSaleUsername());
        lqw.like(Strings.isNotEmpty(salesman.getSaleName()),Salesman::getSaleName,salesman.getSaleName());
        lqw.like(Strings.isNotEmpty(salesman.getSalePhone()),Salesman::getSalePhone,salesman.getSalePhone());
        lqw.like(Strings.isNotEmpty(salesman.getSaleId()),Salesman::getSaleId,salesman.getSaleId());
        IPage page = new Page(start,10);
        salesmanDaoMP.selectPage(page,lqw);
        return null;
    }
}
