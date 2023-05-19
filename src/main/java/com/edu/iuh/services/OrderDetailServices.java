package com.edu.iuh.services;

import com.edu.iuh.entities.OrderDetail;

import java.util.List;

public interface OrderDetailServices {
    OrderDetail findOneById(String id);

    OrderDetail add(OrderDetail orderDetail);

    OrderDetail deleteById(String id);

    OrderDetail update(OrderDetail orderDetail);

    void saveOrderDetail(double price, int quantity, String orderId, String bookId);

    Integer countBookSell(String bookId);
    List<OrderDetail> findOrderDetailsByOrderId(String orderId);
}