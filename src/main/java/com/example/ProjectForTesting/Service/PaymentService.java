package com.example.ProjectForTesting.Service;

import com.example.ProjectForTesting.Entity.Payment;
import com.example.ProjectForTesting.Repository.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PaymentService {

    private final PaymentRepository paymentRepository;

    @Autowired
    public PaymentService(PaymentRepository paymentRepository) {
        this.paymentRepository = paymentRepository;
    }

    public Payment createPayment(Payment payment) {
        return paymentRepository.save(payment);
    }

    public Optional<Payment> getPaymentById(int id) {
        return paymentRepository.findById(id);
    }

    public List<Payment> getAllPayments() {
        return paymentRepository.findAll();
    }

    public Payment updatePayment(int id, Payment updatedPayment) {
        return paymentRepository.findById(id)
                .map(payment -> {
                    payment.setOrders(updatedPayment.getOrders());
                    payment.setAmount(updatedPayment.getAmount());
                    payment.setPayment_method(updatedPayment.getPayment_method());
                    payment.setStatus(updatedPayment.getStatus());
                    payment.setLocalDate(updatedPayment.getLocalDate());
                    return paymentRepository.save(payment);
                })
                .orElseThrow(() -> new RuntimeException("Payment not found"));
    }

    public void deletePayment(int id) {
        paymentRepository.deleteById(id);
    }
}
