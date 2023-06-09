package com.damiantomczyszyn.bookstore.service;

import com.damiantomczyszyn.bookstore.entity.Order;
import com.damiantomczyszyn.bookstore.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {
    @Autowired
    OrderRepository repository;

    public List<Order> getOrders() {
        return (List<Order>) repository.findAll();
    }
}
