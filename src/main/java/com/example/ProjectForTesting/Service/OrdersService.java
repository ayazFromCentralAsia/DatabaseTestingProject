package com.example.ProjectForTesting.Service;

import com.example.ProjectForTesting.Entity.Orders;
import com.example.ProjectForTesting.Repository.OrdersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrdersService {

    private final OrdersRepository ordersRepository;

    @Autowired
    public OrdersService(OrdersRepository ordersRepository) {
        this.ordersRepository = ordersRepository;
    }

    public List<Orders> getAllOrders() {
        return ordersRepository.findAll();
    }

    public Orders getOrderById(int id) {
        return ordersRepository.findById(id).orElse(null);
    }

    public Orders createOrder(Orders order) {
        return ordersRepository.save(order);
    }

    public Orders updateOrder(int id, Orders updatedOrder) {
        if (ordersRepository.existsById(id)) {
            updatedOrder.setId(id);
            return ordersRepository.save(updatedOrder);
        } else {
            return null;
        }
    }

    public void deleteOrder(int id) {
        ordersRepository.deleteById(id);
    }
}
