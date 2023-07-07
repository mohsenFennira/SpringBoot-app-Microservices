package com.mohsenfn.orderservice.Controller;

import com.mohsenfn.orderservice.Entity.Order;
import com.mohsenfn.orderservice.Services.OrderIService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/Order")
public class OrderController {
    @Autowired
    OrderIService ois;

    @PostMapping
    public Long addOrder(@RequestBody Order order) {
        return ois.addOrder(order);
    }

    @GetMapping
    public Order getOrder(@RequestParam Long id) {
        return ois.getOrder(id);
    }
}