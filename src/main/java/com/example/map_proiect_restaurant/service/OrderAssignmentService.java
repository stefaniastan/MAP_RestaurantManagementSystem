package com.example.map_proiect_restaurant.service;

import com.example.map_proiect_restaurant.model.MenuItem;
import com.example.map_proiect_restaurant.model.OrderAssignment;
import com.example.map_proiect_restaurant.repository.MenuItemRepository;
import com.example.map_proiect_restaurant.repository.OrderAssignmentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderAssignmentService {

    private OrderAssignmentRepository orderAssignmentRepository;

    public OrderAssignmentService(OrderAssignmentRepository orderAssignmentRepository) {
        this.orderAssignmentRepository = orderAssignmentRepository;
    }

    public List<OrderAssignment> findAllOrderAssignments(){
        return orderAssignmentRepository.findAll();
    }

    public OrderAssignment findOrderAssignmentById(String id){
        return orderAssignmentRepository.findById(id);
    }

    public OrderAssignment addOrderAssignment(OrderAssignment orderAssignment){
        return orderAssignmentRepository.save(orderAssignment);
    }

    public void deleteOrderAssignment(String id){
        orderAssignmentRepository.deleteById(id);
    }
}
