package com.mohsenfn.orderservice.External.Request;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PaymentRequest {
        private long orderId;
        private String paymentMode;
        private String referenceNumber;
        private Instant paymentDate;
        private String paymentStatus;
        private long amount;
    }

