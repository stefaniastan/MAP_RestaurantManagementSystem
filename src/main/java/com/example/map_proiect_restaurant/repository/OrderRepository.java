package com.example.map_proiect_restaurant.repository;

import com.example.map_proiect_restaurant.model.Order;
import org.springframework.stereotype.Repository;

@Repository
public class OrderRepository extends InFileRepository<Order> {
    public OrderRepository() {
        super(Order.class, "src/main/resources/data/orders.json");
    }
}
