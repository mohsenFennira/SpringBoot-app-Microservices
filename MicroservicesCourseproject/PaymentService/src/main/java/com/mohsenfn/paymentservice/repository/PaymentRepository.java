package com.mohsenfn.paymentservice.repository;

import com.mohsenfn.paymentservice.entity.Payment;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaymentRepository extends CrudRepository<Payment,Long> {
    Payment findByOrderId(long orderId);
}
