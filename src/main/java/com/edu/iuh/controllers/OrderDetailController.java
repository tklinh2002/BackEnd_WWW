package com.edu.iuh.controllers;

import com.edu.iuh.services.BookServices;
import com.edu.iuh.services.OrderDetailServices;
import com.edu.iuh.services.OrderServices;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/orderDetails")
public class OrderDetailController {
    private final OrderDetailServices orderDetailServices;
    private final BookServices bookServices;
    private final OrderServices orderServices;

    public OrderDetailController(OrderDetailServices orderDetailServices, BookServices bookServices, OrderServices orderServices) {
        this.orderDetailServices = orderDetailServices;
        this.bookServices = bookServices;
        this.orderServices = orderServices;
    }

    @GetMapping("/add")
    public ResponseEntity<String> add(@RequestParam("price") double price, @RequestParam("quantity") int quantity, @RequestParam("orderId") String orderId, @RequestParam("bookId") String bookId) {
        System.out.println(price);
        System.out.println(quantity);
        System.out.println(orderId);
        System.out.println(bookId);
        orderDetailServices.saveOrderDetail(price, quantity, orderId, bookId);
        return ResponseEntity.ok("Add order detail successfully!");
    }
}