package com.mohsenfn.orderservice.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;

@Entity
@Table(name = "ORDER_DETAILS")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long productId;
    private Long quantity;
    private Instant orderDATE;
    private String orderStatus;
    @Enumerated(EnumType.STRING)
    private  PaymentMode paymentMode;
    private Long amount;
}
