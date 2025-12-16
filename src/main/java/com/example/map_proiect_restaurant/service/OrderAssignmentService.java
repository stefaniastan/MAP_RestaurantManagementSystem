package com.example.map_proiect_restaurant.service;

import com.example.map_proiect_restaurant.model.OrderAssignment;
import com.example.map_proiect_restaurant.repository.OrderAssignmentRepository;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderAssignmentService {

    private final OrderAssignmentRepository orderAssignmentRepository;

    public OrderAssignmentService(OrderAssignmentRepository orderAssignmentRepository) {
        this.orderAssignmentRepository = orderAssignmentRepository;
    }

    // 🔍 FILTER + SORT
    public List<OrderAssignment> filterAndSortAssignments(
            Long orderId,
            Long staffId,
            String sortBy,
            String direction
    ) {
        Sort sort = Sort.by(
                direction.equalsIgnoreCase("desc") ? Sort.Direction.DESC : Sort.Direction.ASC,
                sortBy
        );

        if (orderId != null) {
            return orderAssignmentRepository.findByOrder_Id(orderId);
        }

        if (staffId != null) {
            return orderAssignmentRepository.findByStaff_Id(staffId);
        }

        return orderAssignmentRepository.findAll(sort);
    }

    public OrderAssignment addOrderAssignment(OrderAssignment assignment) {
        if (assignment.getOrder() == null) {
            throw new IllegalStateException("Order does not exist.");
        }

        if (assignment.getStaff() == null) {
            throw new IllegalStateException("Staff member does not exist.");
        }

        Long orderId = assignment.getOrder().getId();
        Long staffId = assignment.getStaff().getId();

        if (orderAssignmentRepository.existsByOrderIdAndStaffId(orderId, staffId)) {
            throw new IllegalStateException("Staff already assigned to this order.");
        }

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