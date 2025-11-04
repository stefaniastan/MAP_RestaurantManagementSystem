package com.example.map_proiect_restaurant.repository;

import com.example.map_proiect_restaurant.model.Order;
import com.example.map_proiect_restaurant.model.OrderAssignment;
import com.example.map_proiect_restaurant.model.OrderLine;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Repository
public class OrderRepository implements AbstractRepository<Order> {

    private final List<Order> orders = new ArrayList<>(Arrays.asList(
            new Order("Order1", "Customer1", "Table1", "Open",
                    new ArrayList<OrderLine>(), new ArrayList<OrderAssignment>()),
            new Order("Order2", "Customer2", "Table2", "Closed",
                    new ArrayList<OrderLine>(), new ArrayList<OrderAssignment>())
    ));

    @Override
    public Order save(Order order) {
        orders.add(order);
        return order;
    }

    @Override
    public List<Order> findAll() {
        // return the live list so Thymeleaf can display them
        return new ArrayList<>(orders);
    }

    @Override
    public Order findById(String id) {
        return orders.stream()
                .filter(o -> o.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    @Override
    public void deleteById(String id) {
        orders.removeIf(o -> o.getId().equals(id));
    }
}