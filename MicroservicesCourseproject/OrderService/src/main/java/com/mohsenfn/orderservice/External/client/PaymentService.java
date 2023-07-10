package com.mohsenfn.orderservice.External.client;

import com.mohsenfn.orderservice.Entity.Order;
import com.mohsenfn.orderservice.External.Request.PaymentRequest;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
@FeignClient(name = "PAYMENT-SERVICE/Payment")
//name of service /endpoint
public interface PaymentService {
    @PostMapping
    public PaymentRequest DoPayment(@RequestBody PaymentRequest payment);

}
