package com.example.map_proiect_restaurant.repository;

import com.example.map_proiect_restaurant.model.OrderAssignment;
import org.springframework.stereotype.Repository;

@Repository
public class OrderAssignmentRepository extends InFileRepository<OrderAssignment> {
    public OrderAssignmentRepository() {
        super(OrderAssignment.class, "src/main/resources/data/orderassignments.json");
    }
}
