package com.example.map_proiect_restaurant.controller;

import com.example.map_proiect_restaurant.model.Order;
import com.example.map_proiect_restaurant.model.OrderStatusEnum;
import com.example.map_proiect_restaurant.service.OrderService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@Controller
@RequestMapping("/orders")
public class OrderController {

    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping
    public String getAllOrders(Model model) {
        model.addAttribute("orders", orderService.getAllOrders());
        return "order/index";
    }

    @GetMapping("/new")
    public String createForm(Model model) {
        model.addAttribute("order", new Order(
                "", // Id
                "", // customerId
                "", // tableId
                OrderStatusEnum.pending, // status
                new ArrayList<>(), // orderLines
                new ArrayList<>()  // assignments
        ));
        return "order/form";
    }

    @PostMapping
    public String createOrder(@ModelAttribute Order order) {
        orderService.addOrder(order);
        return "redirect:/orders";
    }

    @PostMapping("/{id}/delete")
    public String deleteOrder(@PathVariable String id) {
        orderService.deleteOrder(id);
        return "redirect:/orders";
    }
}

