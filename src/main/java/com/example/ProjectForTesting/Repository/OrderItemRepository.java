package com.example.ProjectForTesting.Repository;


import com.example.ProjectForTesting.Entity.OrderItem;
import com.example.ProjectForTesting.Entity.Orders;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public interface OrderItemRepository extends JpaRepository<OrderItem,Integer> {
    List<OrderItem> findByOrders(Orders orders);
}
