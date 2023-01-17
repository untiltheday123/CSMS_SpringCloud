package com.salesmanservice.service;//package com.csms.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.salesmanservice.domain.Salesman;

public interface SalesmanService {

    Salesman salesmanLogin(Salesman salesman);

    IPage<Salesman> queryAllSalesman(int start);

    Boolean updateSalesman(Salesman salesman);

    IPage<Salesman> querySalesmanCondition(int start, Salesman salesman);
}
