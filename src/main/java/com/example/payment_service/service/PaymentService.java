package com.example.payment_service.service;

import com.example.payment_service.dao.PaymentRepository;
import com.example.payment_service.entity.Payment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Random;
import java.util.UUID;

@Service
public class PaymentService {

    @Autowired
    private PaymentRepository paymentRepository;

    public Payment doPayment(Payment payment) {
        payment.setTransactionId(UUID.randomUUID().toString());
        payment.setPaymentStatus(paymentProcessing());
        return paymentRepository.save(payment);
    }

    private String paymentProcessing() {
        return new Random().nextBoolean() ? "success" : "false";
    }
}
