package com.mohsenfn.orderservice.Controller;

import com.mohsenfn.orderservice.Entity.Order;
import com.mohsenfn.orderservice.Services.OrderIService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/Order")
public class OrderController {
    @Autowired
    OrderIService ois;
    @PostMapping
    public Long addOrder(@RequestBody Order order) {
        return ois.addOrder(order);
    }
}
