package com.mohsenfn.orderservice.Services;

import com.mohsenfn.orderservice.Entity.Order;
import com.mohsenfn.orderservice.External.Request.PaymentRequest;
import com.mohsenfn.orderservice.External.client.PaymentService;
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
    @Autowired
    PaymentService pss;
    @Override
    public Long addOrder(Order order) {
        order.setOrderDATE(Instant.now());
        String orderStatust=null;
        try {
            ps.ReduceQuantity(order.getProductId(), order.getQuantity());
            PaymentRequest paymentRequest= PaymentRequest.builder()
                    .orderId(or.save(order).getId())
                    .paymentMode(order.getPaymentMode().name())
                    .amount(order.getAmount())
                    .build();
            try {
                pss.DoPayment(paymentRequest);
                orderStatust="PLACED";
            }catch (Exception e){
                orderStatust="PAYMENT_FAILED";
            }
        } catch (Exception e) {
            order.setOrderStatus("PAYMENT_FAILED");
            PaymentRequest paymentRequest= PaymentRequest.builder()
                    .orderId(or.save(order).getId())
                    .paymentMode(order.getPaymentMode().name())
                    .amount(order.getAmount())
                    .build();
            pss.DoPayment(paymentRequest);
            return or.save(order).getId();
        }

        order.setOrderStatus(orderStatust);

        return or.save(order).getId();
    }
}
