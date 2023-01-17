package com.feign.clients;

import com.feign.domain.Goods;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient("goodsservice")
public interface GoodsClient {

    @GetMapping("/goods/{orderId}")
    Goods[] findById(@PathVariable("orderId") String orderId);
}
