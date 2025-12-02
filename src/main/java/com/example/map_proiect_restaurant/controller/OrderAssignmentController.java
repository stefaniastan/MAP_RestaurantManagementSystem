package com.example.map_proiect_restaurant.controller;

import com.example.map_proiect_restaurant.model.OrderAssignment;
import com.example.map_proiect_restaurant.model.Order;
import com.example.map_proiect_restaurant.model.Staff;
import com.example.map_proiect_restaurant.service.OrderAssignmentService;
import com.example.map_proiect_restaurant.service.OrderService;
import com.example.map_proiect_restaurant.service.StaffService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/assignments")
public class OrderAssignmentController {

    private final OrderAssignmentService assignmentService;
    private final OrderService orderService;
    private final StaffService staffService;

    public OrderAssignmentController(OrderAssignmentService assignmentService, OrderService orderService, StaffService staffService) {
        this.assignmentService = assignmentService;
        this.orderService = orderService;
        this.staffService = staffService;
    }

    @GetMapping
    public String listAssignments(Model model) {
        List<OrderAssignment> assignments = assignmentService.getAllOrderAssignments();
        model.addAttribute("assignments", assignments);
        return "assignments/index";
    }

    @GetMapping("/new")
    public String showCreateForm(Model model) {
        model.addAttribute("assignment", new OrderAssignment());
        model.addAttribute("orders", orderService.getAllOrders());
        model.addAttribute("staffList", staffService.getAllStaff());
        return "assignments/form";
    }

    @PostMapping
    public String createAssignment(@Valid @ModelAttribute("assignment") OrderAssignment assignment, BindingResult result) {
        if (result.hasErrors()) {
            return "assignments/form";
        }
        assignmentService.addOrderAssignment(assignment);
        return "redirect:/assignments";
    }

    @GetMapping("/{id}/edit")
    public String showEditForm(@PathVariable Long id, Model model) {
        OrderAssignment assignment = assignmentService.getOrderAssignmentById(id);
        model.addAttribute("assignment", assignment);
        model.addAttribute("orders", orderService.getAllOrders());
        model.addAttribute("staffList", staffService.getAllStaff());
        return "assignments/form";
    }

    @PostMapping("/{id}")
    public String updateAssignment(@PathVariable Long id, @Valid @ModelAttribute("assignment") OrderAssignment assignment, BindingResult result) {
        if (result.hasErrors()) {
            return "assignments/form";
        }
        assignment.setId(id);
        assignmentService.updateOrderAssignment(assignment);
        return "redirect:/assignments";
    }

    @PostMapping("/{id}/delete")
    public String deleteAssignment(@PathVariable Long id) {
        assignmentService.deleteOrderAssignment(id);
        return "redirect:/assignments";
    }
}
