package com.mohsenfn.orderservice.Repository;

import com.mohsenfn.orderservice.Entity.Order;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends CrudRepository<Order,Long> {
}
