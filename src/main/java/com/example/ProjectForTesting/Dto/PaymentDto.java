package com.example.ProjectForTesting.Dto;

import com.example.ProjectForTesting.Entity.Orders;
import jakarta.validation.constraints.NotNull;

public class PaymentDto {

    private int ordersId;

    private int amount;

    @NotNull
    private String payment_method;

    private String status;

    public int getOrdersId() {
        return ordersId;
    }

    public void setOrdersId(int ordersId) {
        this.ordersId = ordersId;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getPayment_method() {
        return payment_method;
    }

    public void setPayment_method(String payment_method) {
        this.payment_method = payment_method;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
