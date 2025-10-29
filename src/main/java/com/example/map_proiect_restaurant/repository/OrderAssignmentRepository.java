package com.example.map_proiect_restaurant.repository;

import com.example.map_proiect_restaurant.model.OrderAssignment;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Repository
public class OrderAssignmentRepository implements AbstractRepository<OrderAssignment>{

    private final List<OrderAssignment> orderAssignments = new ArrayList<>(Arrays.asList(
            new OrderAssignment("OrderAssignment1", "Order1", "Chef1"),
            new OrderAssignment("OrderAssignment2", "Order2", "Server1")
    ));

    @Override
    public OrderAssignment save(OrderAssignment orderAssignment) {
       orderAssignments.add(orderAssignment);
       return orderAssignment;
    }

    @Override
    public List<OrderAssignment> findAll() {
        return orderAssignments;
    }

    @Override
    public OrderAssignment findById(String id) {
        for (OrderAssignment orderAssignment : orderAssignments) {
            if (orderAssignment.getId().equals(id)) {
                return orderAssignment;
            }
        }
        return null;
    }

    @Override
    public void deleteById(String id) {
        for (OrderAssignment orderAssignment : orderAssignments) {
            if (orderAssignment.getId().equals(id)) {
                orderAssignments.remove(orderAssignment);
            }
        }
    }
}
