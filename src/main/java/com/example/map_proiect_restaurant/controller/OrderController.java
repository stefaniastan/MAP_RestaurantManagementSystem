package com.example.map_proiect_restaurant.controller;

import com.example.map_proiect_restaurant.model.Order;
import com.example.map_proiect_restaurant.service.OrderService;
import com.example.map_proiect_restaurant.service.CustomerService;
import com.example.map_proiect_restaurant.service.RestaurantTableService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/orders")
public class OrderController {

    private final OrderService orderService;
    private final CustomerService customerService;
    private final RestaurantTableService tableService;

    public OrderController(OrderService orderService, CustomerService customerService, RestaurantTableService tableService) {
        this.orderService = orderService;
        this.customerService = customerService;
        this.tableService = tableService;
    }

    @GetMapping
    public String listOrders(Model model) {
        List<Order> orders = orderService.getAllOrders();
        model.addAttribute("orders", orders);
        return "orders/index";
    }

    @GetMapping("/new")
    public String showCreateForm(Model model) {
        model.addAttribute("order", new Order());
        model.addAttribute("customers", customerService.getAllCustomers());
        model.addAttribute("tables", tableService.getAllTables());
        return "orders/form";
    }

    @PostMapping
    public String createOrder(@Valid @ModelAttribute("order") Order order, BindingResult result) {
        if (result.hasErrors()) {
            return "orders/form";
        }
        orderService.addOrder(order);
        return "redirect:/orders";
    }

    @GetMapping("/{id}/edit")
    public String showEditForm(@PathVariable Long id, Model model) {
        Order order = orderService.getOrderById(id);
        model.addAttribute("order", order);
        model.addAttribute("customers", customerService.getAllCustomers());
        model.addAttribute("tables", tableService.getAllTables());
        return "orders/form";
    }

    @PostMapping("/{id}")
    public String updateOrder(@PathVariable Long id, @Valid @ModelAttribute("order") Order order, BindingResult result) {
        if (result.hasErrors()) {
            return "orders/form";
        }
        order.setId(id);
        orderService.updateOrder(order);
        return "redirect:/orders";
    }

    @PostMapping("/{id}/delete")
    public String deleteOrder(@PathVariable Long id) {
        orderService.deleteOrder(id);
        return "redirect:/orders";
    }
}
