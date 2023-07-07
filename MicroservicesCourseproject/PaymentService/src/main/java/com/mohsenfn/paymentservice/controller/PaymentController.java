package com.mohsenfn.paymentservice.controller;

import com.mohsenfn.paymentservice.entity.Payment;
import com.mohsenfn.paymentservice.services.PaymentIService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    @GetMapping("order")
    public Payment GetPaymentByOrderId(@RequestParam long orderId) {
        return pis.GetPaymentByOrderId(orderId);
    }
}
