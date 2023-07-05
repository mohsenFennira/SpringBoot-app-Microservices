package com.mohsenfn.paymentservice.controller;

import com.mohsenfn.paymentservice.entity.Payment;
import com.mohsenfn.paymentservice.services.PaymentIService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.Instant;
@RequestMapping("/Payment")
@RestController
public class PaymentController {
    @Autowired
    PaymentIService pis;
    @PostMapping
    public Payment DoPayment(@RequestBody Payment payment) {
        return pis.DoPayment(payment);
    }
}
