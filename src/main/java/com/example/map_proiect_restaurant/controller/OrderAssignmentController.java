package com.example.map_proiect_restaurant.controller;

import com.example.map_proiect_restaurant.model.OrderAssignment;
import com.example.map_proiect_restaurant.service.OrderAssignmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/order-assignments")
public class OrderAssignmentController {

    private final OrderAssignmentService orderAssignmentService;

    @Autowired
    public OrderAssignmentController(OrderAssignmentService orderAssignmentService) {
        this.orderAssignmentService = orderAssignmentService;
    }

    @GetMapping
    public List<OrderAssignment> getAllOrderAssignments() {
        return orderAssignmentService.getAllOrderAssignments();
    }

    @GetMapping("/{id}")
    public OrderAssignment getOrderAssignmentById(@PathVariable Long id) {
        return orderAssignmentService.getOrderAssignmentById(id);
    }

    @PostMapping
    public OrderAssignment createOrderAssignment(@RequestBody OrderAssignment assignment) {
        return orderAssignmentService.addOrderAssignment(assignment);
    }

    @PutMapping("/{id}")
    public OrderAssignment updateOrderAssignment(@PathVariable Long id, @RequestBody OrderAssignment assignment) {
        assignment.setId(id);
        return orderAssignmentService.updateOrderAssignment(assignment);
    }

    @DeleteMapping("/{id}")
    public String deleteOrderAssignment(@PathVariable Long id) {
        orderAssignmentService.deleteOrderAssignment(id);
        return "Order assignment deleted successfully";
    }

    @GetMapping("/order/{orderId}")
    public List<OrderAssignment> getOrderAssignmentsByOrderId(@PathVariable Long orderId) {
        return orderAssignmentService.getOrderAssignmentsByOrderId(orderId);
    }

    @GetMapping("/staff/{staffId}")
    public List<OrderAssignment> getOrderAssignmentsByStaffId(@PathVariable Long staffId) {
        return orderAssignmentService.getOrderAssignmentsByStaffId(staffId);
    }
}
