package com.luongvandat.services;

import com.luongvandat.entities.Order_;

import java.util.List;

public interface OrderServices {
    Order_ findOneById(String id);

    Order_ add(Order_ order_);

    Order_ deleteById(String id);

    Order_ update(Order_ order_);

    List<Order_> findOrdersByUserEmail(String userEmail);

    Order_ findOrder_ByOrderId(String orderId);
    Integer countOrder_By();
}