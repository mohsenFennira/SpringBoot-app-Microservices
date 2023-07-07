package com.mohsenfn.orderservice.Services;

import com.mohsenfn.orderservice.Entity.Order;
import com.mohsenfn.orderservice.External.Request.PaymentRequest;
import com.mohsenfn.orderservice.External.client.PaymentService;
import com.mohsenfn.orderservice.External.client.ProductService;
import com.mohsenfn.orderservice.Repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.time.Instant;

@Service
public class OrderService implements OrderIService {
    @Autowired
    OrderRepository or;
    @Autowired
    ProductService ps;
    @Autowired
    PaymentService pss;
    @Autowired
    RestTemplate restTemplate;
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

    @Override
    public Order getOrder(Long id) {
        Order order =or.findById(id).get();
        Order.Productdetails pr=restTemplate.getForObject("http://PRODUCT-SERVICE/product?id="+order.getProductId()
        , Order.Productdetails.class);
        PaymentRequest paymentRequest=restTemplate.getForObject("http://PAYMENT-SERVICE/Payment/order?orderId="+id, PaymentRequest.class);
        Order.PaymentDetails paymentDetails=Order.PaymentDetails
                .builder()
                .paymentDate(paymentRequest.getPaymentDate())
                .paymentStatus(paymentRequest.getPaymentStatus())
                .build();
        order.setPaymentDetails(paymentDetails);
        Order.Productdetails productdetails=
                Order.Productdetails.builder()
                        .productName(pr.getProductName())
                        .price(pr.getPrice())
                        .build();
        order.setProductdetails(productdetails);
        return order;
    }
}
