package com.mohsenfn.orderservice.Services;

import com.mohsenfn.orderservice.Entity.Order;

public interface OrderIService {
    public Long addOrder(Order order);
    public Order getOrder(Long id);

}
