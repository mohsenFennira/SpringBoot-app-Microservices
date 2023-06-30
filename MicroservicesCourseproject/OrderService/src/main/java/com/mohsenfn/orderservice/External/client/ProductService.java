package com.mohsenfn.orderservice.External.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;


@FeignClient(name = "PRODUCT-SERVICE/product")
public interface ProductService {
    @PutMapping("ReduceQuantity")
     void ReduceQuantity(@RequestParam Long id, @RequestParam Long quantity);
}
