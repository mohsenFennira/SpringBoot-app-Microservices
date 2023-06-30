package com.mohsenfn.orderservice.Services;

import com.mohsenfn.orderservice.Entity.Order;
import com.mohsenfn.orderservice.External.client.ProductService;
import com.mohsenfn.orderservice.Repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;

@Service
public class OrderService implements OrderIService {
    @Autowired
    OrderRepository or;
    @Autowired
    ProductService ps;
    @Override
    public Long addOrder(Order order) {
        order.setOrderDATE(Instant.now());
        ps.ReduceQuantity(order.getProductId(),order.getQuantity());
        return or.save(order).getId();
    }
}
