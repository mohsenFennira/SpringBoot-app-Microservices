package com.mohsenfn.paymentservice.services;

import com.mohsenfn.paymentservice.entity.Payment;
import com.mohsenfn.paymentservice.repository.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;

@Service
public class PaymentService implements PaymentIService{
    @Autowired
    PaymentRepository pr;
    @Override
    public Payment DoPayment(Payment payment) {
        payment.setPaymentDate(Instant.now());
        payment.setPaymentStatus("SUCCESS");
        return pr.save(payment);
    }
}
