package com.salesmanservice.domain;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

@Data
public class Salesman {
    @TableId
    String saleId;
    String saleName;
    String saleUsername;
    String salePassword;
    String saleSex;
    String salePhone;
}
