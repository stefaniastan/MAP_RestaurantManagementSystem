package com.example.map_proiect_restaurant.controller;

import com.example.map_proiect_restaurant.model.Order;
import com.example.map_proiect_restaurant.model.OrderStatusEnum;
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

    // 🔍 Updated listOrders with filter and sort parameters
    @GetMapping({"", "/"})
    public String listOrders(
            @RequestParam(required = false) Long customerId,
            @RequestParam(required = false) Long tableId,
            @RequestParam(required = false) OrderStatusEnum status,
            @RequestParam(defaultValue = "id") String sortBy,
            @RequestParam(defaultValue = "asc") String direction,
            Model model
    ) {
        model.addAttribute(
                "orders",
                orderService.filterAndSortOrders(customerId, tableId, status, sortBy, direction)
        );

        // Add filter parameters back to the model for the view
        model.addAttribute("customerId", customerId);
        model.addAttribute("tableId", tableId);
        model.addAttribute("status", status);
        model.addAttribute("sortBy", sortBy);
        model.addAttribute("direction", direction);

        // Add all statuses for dropdown
        model.addAttribute("allStatuses", OrderStatusEnum.values());

        return "order/index";
    }

    @GetMapping("/new")
    public String showCreateForm(Model model) {
        model.addAttribute("order", new Order());
        model.addAttribute("customers", customerService.getAllCustomers());
        model.addAttribute("tables", tableService.getAllTables());
        return "order/form";
    }

    @PostMapping
    public String createOrder(@Valid @ModelAttribute("order") Order order,
                              BindingResult result,
                              Model model) {

        if (result.hasErrors()) {
            model.addAttribute("customers", customerService.getAllCustomers());
            model.addAttribute("tables", tableService.getAllTables());
            return "order/form";
        }

        try {
            orderService.addOrder(order);
        } catch (IllegalStateException ex) {
            result.reject("orderError", ex.getMessage());
            model.addAttribute("customers", customerService.getAllCustomers());
            model.addAttribute("tables", tableService.getAllTables());
            return "order/form";
        }

        return "redirect:/orders";
    }

    @GetMapping("/{id}/edit")
    public String showEditForm(@PathVariable Long id, Model model) {
        Order order = orderService.getOrderById(id);
        model.addAttribute("order", order);
        model.addAttribute("customers", customerService.getAllCustomers());
        model.addAttribute("tables", tableService.getAllTables());
        return "order/form";
    }

    @PostMapping("/{id}")
    public String updateOrder(@PathVariable Long id, @Valid @ModelAttribute("order") Order order, BindingResult result) {
        if (result.hasErrors()) {
            return "order/form";
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