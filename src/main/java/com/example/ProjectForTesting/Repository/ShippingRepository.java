package com.example.ProjectForTesting.Repository;

import com.example.ProjectForTesting.Entity.Orders;
import com.example.ProjectForTesting.Entity.Shipping;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface ShippingRepository extends JpaRepository<Shipping, Integer> {
    Optional<Shipping> findByOrders(Orders orders);
}
