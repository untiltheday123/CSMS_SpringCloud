package com.goodsservice.domain;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("product")
public class Goods {
    private String proId;
    @TableField(value = "")
    private String proName;
    private String proDetail;
    private Float proPrice;
    private String proUrl;

    @TableField(exist = false)
    private int proNum;
    @TableField(exist = false)
    private double proTotal;
    @TableField(exist = false)
    private String orderState;
}
