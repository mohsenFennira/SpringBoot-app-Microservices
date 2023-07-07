package com.mohsenfn.paymentservice.services;

import com.mohsenfn.paymentservice.entity.Payment;

public interface PaymentIService {
    public Payment DoPayment(Payment payment);
    public Payment GetPaymentById(Long id);
    public Payment GetPaymentByOrderId(long orderId);
}
