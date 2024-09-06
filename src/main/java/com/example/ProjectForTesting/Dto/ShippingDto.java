package com.example.ProjectForTesting.Dto;

import com.example.ProjectForTesting.Entity.Orders;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class ShippingDto {

    private Orders orders;

    private String adress;

    @NotNull
    @Size(max = 200,min = 3)
    private String city;

    @NotNull
    private String postal_code;

    private String country;

    private String status;


    public Orders getOrders() {
        return orders;
    }

    public void setOrders(Orders orders) {
        this.orders = orders;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPostal_code() {
        return postal_code;
    }

    public void setPostal_code(String postal_code) {
        this.postal_code = postal_code;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
