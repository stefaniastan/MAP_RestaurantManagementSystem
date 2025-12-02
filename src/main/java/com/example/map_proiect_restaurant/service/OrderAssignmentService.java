package com.example.map_proiect_restaurant.service;

import com.example.map_proiect_restaurant.model.OrderAssignment;
import com.example.map_proiect_restaurant.repository.OrderAssignmentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderAssignmentService {

    private final OrderAssignmentRepository orderAssignmentRepository;

    public OrderAssignmentService(OrderAssignmentRepository orderAssignmentRepository) {
        this.orderAssignmentRepository = orderAssignmentRepository;
    }

    public OrderAssignment addOrderAssignment(OrderAssignment assignment) {
        return orderAssignmentRepository.save(assignment);
    }

    public OrderAssignment updateOrderAssignment(OrderAssignment assignment) {
        return orderAssignmentRepository.save(assignment);
    }

    public List<OrderAssignment> getAllOrderAssignments() {
        return orderAssignmentRepository.findAll();
    }

    public OrderAssignment getOrderAssignmentById(Long id) {
        return orderAssignmentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Order assignment not found"));
    }

    public void deleteOrderAssignment(Long id) {
        orderAssignmentRepository.deleteById(id);
    }

    public List<OrderAssignment> getOrderAssignmentsByOrderId(Long orderId) {
        return orderAssignmentRepository.findByOrderId(orderId);
    }

    public List<OrderAssignment> getOrderAssignmentsByStaffId(Long staffId) {
        return orderAssignmentRepository.findByStaffId(staffId);
    }
}