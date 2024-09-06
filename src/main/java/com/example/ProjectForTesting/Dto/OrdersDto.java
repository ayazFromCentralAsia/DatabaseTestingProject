package com.example.ProjectForTesting.Dto;

import com.example.ProjectForTesting.Entity.User;

public class OrdersDto {

    private User user;

    private int total_price;

    private String status;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public int getTotal_price() {
        return total_price;
    }

    public void setTotal_price(int total_price) {
        this.total_price = total_price;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
