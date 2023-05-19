package com.edu.iuh.services.impl;

import com.edu.iuh.repositories.OrderRepository;
import com.edu.iuh.entities.Order_;
import com.edu.iuh.services.OrderServices;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServicesImpl implements OrderServices {
    private final OrderRepository orderRepository;

    public OrderServicesImpl(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Override
    public Order_ findOneById(String id) {
        return orderRepository.findById(id).orElse(null);
    }

    @Override
    public Order_ add(Order_ order_) {
        return orderRepository.save(order_);
    }

    @Override
    public Order_ deleteById(String id) {
        Order_ order_ = findOneById(id);
        orderRepository.deleteById(id);
        return order_;
    }

    @Override
    public Order_ update(Order_ order_) {
        return orderRepository.save(order_);
    }

    @Override
    public List<Order_> findOrdersByUserEmail(String userEmail) {
        return orderRepository.findOrdersByUserEmail(userEmail);
    }

    @Override
    public Order_ findOrder_ByOrderId(String orderId){
        return orderRepository.findOrder_ByOrderId(orderId);
    }

    @Override
    public Integer countOrder_By() {
        return orderRepository.countOrder_By();
    }
}