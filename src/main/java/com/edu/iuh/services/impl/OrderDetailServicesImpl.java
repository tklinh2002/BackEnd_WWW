package com.edu.iuh.services.impl;

import com.edu.iuh.repositories.OrderDetailRepository;
import com.edu.iuh.entities.OrderDetail;
import com.edu.iuh.services.OrderDetailServices;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderDetailServicesImpl implements OrderDetailServices {
    private final OrderDetailRepository orderDetailRepository;

    public OrderDetailServicesImpl(OrderDetailRepository orderDetailRepository) {
        this.orderDetailRepository = orderDetailRepository;
    }

    @Override
    public OrderDetail findOneById(String id) {
        return orderDetailRepository.findById(id).orElse(null);
    }

    @Override
    public OrderDetail add(OrderDetail orderDetail) {
        return orderDetailRepository.save(orderDetail);
    }

    @Override
    public OrderDetail deleteById(String id) {
        OrderDetail orderDetail = findOneById(id);
        orderDetailRepository.deleteById(id);
        return orderDetail;
    }

    @Override
    public OrderDetail update(OrderDetail orderDetail) {
        return orderDetailRepository.save(orderDetail);
    }

    @Override
    public void saveOrderDetail(double price, int quantity, String orderId, String bookId) {
        orderDetailRepository.saveOrderDetail(price, quantity, orderId, bookId);
    }

    @Override
    public Integer countBookSell(String bookId) {
        Integer count = orderDetailRepository.countBookSell(bookId);
        return count != null ? count : 0;
    }

    @Override
    public List<OrderDetail> findOrderDetailsByOrderId(String orderId) {
        return orderDetailRepository.findOrderDetailsByOrderId(orderId);
    }
}