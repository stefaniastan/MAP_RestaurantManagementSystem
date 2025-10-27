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
            new Order("Order1", "Customer1", "Table1", "Open", new ArrayList<OrderLine>(), new ArrayList<OrderAssignment>()),
            new Order("Order2", "Customer2", "Table2", "Closed", new ArrayList<OrderLine>(), new ArrayList<OrderAssignment>())
    ));

    @Override
    public Order save(Order order) {
        return null;
    }

    @Override
    public List<Order> findAll() {
        return List.of();
    }

    @Override
    public Order findById(Integer id) {
        return null;
    }

    @Override
    public void deleteById(Integer id) {

    }
}
