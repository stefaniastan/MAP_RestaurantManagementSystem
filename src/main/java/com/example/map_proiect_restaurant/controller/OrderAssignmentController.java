package com.example.map_proiect_restaurant.controller;

import com.example.map_proiect_restaurant.model.OrderAssignment;
import com.example.map_proiect_restaurant.service.OrderAssignmentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/orderAssignments")
public class OrderAssignmentController {

    private final OrderAssignmentService orderAssignmentService;

    public OrderAssignmentController(OrderAssignmentService orderAssignmentService) {
        this.orderAssignmentService = orderAssignmentService;
    }

    @GetMapping
    public String getAllAssignments(Model model) {
        model.addAttribute("orderAssignments", orderAssignmentService.findAllOrderAssignments());
        return "orderAssignment/orderAssignment-index";
    }

    @GetMapping("/new")
    public String createForm(Model model) {
        model.addAttribute("orderAssignment", new OrderAssignment("", "", ""));
        return "orderAssignment/orderAssignment-form";
    }

    @PostMapping
    public String createOrderAssignment(@ModelAttribute OrderAssignment orderAssignment) {
        orderAssignmentService.addOrderAssignment(orderAssignment);
        return "redirect:/orderAssignments";
    }

    @PostMapping("/{id}/delete")
    public String deleteOrderAssignment(@PathVariable String id) {
        orderAssignmentService.deleteOrderAssignment(id);
        return "redirect:/orderAssignments";
    }
}
