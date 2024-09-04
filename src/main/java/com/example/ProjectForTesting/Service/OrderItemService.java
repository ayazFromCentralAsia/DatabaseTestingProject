package com.example.ProjectForTesting.Service;

import com.example.ProjectForTesting.Entity.OrderItem;
import com.example.ProjectForTesting.Entity.Orders;
import com.example.ProjectForTesting.Repository.OrderItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderItemService {

    private final OrderItemRepository orderItemRepository;

    @Autowired
    public OrderItemService(OrderItemRepository orderItemRepository) {
        this.orderItemRepository = orderItemRepository;
    }

    public OrderItem createOrderItem(OrderItem orderItem) {
        return orderItemRepository.save(orderItem);
    }

    public Optional<OrderItem> getOrderItemById(int id) {
        return orderItemRepository.findById(id);
    }

    public List<OrderItem> getOrderItemsByOrder(Orders orders) {
        return orderItemRepository.findByOrders(orders);
    }

    public OrderItem updateOrderItem(int id, OrderItem updatedOrderItem) {
        return orderItemRepository.findById(id)
                .map(orderItem -> {
                    orderItem.setOrders(updatedOrderItem.getOrders());
                    orderItem.setProduct(updatedOrderItem.getProduct());
                    orderItem.setQuantity(updatedOrderItem.getQuantity());
                    orderItem.setPrice(updatedOrderItem.getPrice());
                    return orderItemRepository.save(orderItem);
                })
                .orElseThrow(() -> new RuntimeException("Order item not found"));
    }

    public void deleteOrderItem(int id) {
        orderItemRepository.deleteById(id);
    }
}