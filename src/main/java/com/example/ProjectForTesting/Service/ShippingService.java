package com.example.ProjectForTesting.Service;


import com.example.ProjectForTesting.Entity.Orders;
import com.example.ProjectForTesting.Entity.Shipping;
import com.example.ProjectForTesting.Repository.ShippingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ShippingService {

    private final ShippingRepository shippingRepository;

    @Autowired
    public ShippingService(ShippingRepository shippingRepository) {
        this.shippingRepository = shippingRepository;
    }


    public Shipping createShipping(Shipping shipping) {
        return shippingRepository.save(shipping);
    }

    public Optional<Shipping> getShippingById(int id) {
        return shippingRepository.findById(id);
    }

    public Optional<Shipping> getShippingByOrder(Orders orders) {
        return shippingRepository.findByOrders(orders);
    }

    public Shipping updateShipping(int id, Shipping updatedShipping) {
        return shippingRepository.findById(id)
                .map(shipping -> {
                    shipping.setOrders(updatedShipping.getOrders());
                    shipping.setAdress(updatedShipping.getAdress());
                    shipping.setCity(updatedShipping.getCity());
                    shipping.setPostal_code(updatedShipping.getPostal_code());
                    shipping.setCountry(updatedShipping.getCountry());
                    shipping.setStatus(updatedShipping.getStatus());
                    shipping.setCreated_at(updatedShipping.getCreated_at());
                    return shippingRepository.save(shipping);
                })
                .orElseThrow(() -> new RuntimeException("Shipping record not found"));
    }

    public void deleteShipping(int id) {
        shippingRepository.deleteById(id);
    }

    public List<Shipping> getAllShipping() {
        return shippingRepository.findAll();
    }
}