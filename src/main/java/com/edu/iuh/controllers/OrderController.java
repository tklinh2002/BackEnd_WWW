package com.edu.iuh.controllers;

import com.edu.iuh.entities.Order_;
import com.edu.iuh.services.OrderServices;
import com.edu.iuh.services.UserServices;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/order_s")
public class OrderController {
    private final OrderServices orderServices;
    private final UserServices userServices;

    public OrderController(OrderServices orderServices, UserServices userServices) {
        this.orderServices = orderServices;
        this.userServices = userServices;
    }

    @PostMapping("/add")
    public ResponseEntity<String> addOrder(@RequestBody Order_ order) {
        order.setUser_(userServices.findUser_ByUserEmail(order.getUser_().getUserEmail()));
        orderServices.add(order);
        return ResponseEntity.ok(order.getOrderId());
    }
}