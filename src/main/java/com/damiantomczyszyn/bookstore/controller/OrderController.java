package com.damiantomczyszyn.bookstore.controller;

import com.damiantomczyszyn.bookstore.entity.Order;
import com.damiantomczyszyn.bookstore.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.swing.text.html.parser.Entity;
import java.util.List;

@RestController
@RequestMapping(value = "/v1/order")
public class OrderController {
    @Autowired
    private OrderService orderService;
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }
    @GetMapping
    public ResponseEntity<List<Order>> getOrders() {
        List<Order> orders = orderService.getOrders();
        return ResponseEntity.ok(orders);
    }

}
