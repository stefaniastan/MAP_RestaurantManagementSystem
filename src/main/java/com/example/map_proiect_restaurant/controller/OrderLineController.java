package com.example.map_proiect_restaurant.controller;

import com.example.map_proiect_restaurant.model.MenuItem;
import com.example.map_proiect_restaurant.model.OrderLine;
import com.example.map_proiect_restaurant.model.Order;
import com.example.map_proiect_restaurant.service.MenuItemService;
import com.example.map_proiect_restaurant.service.OrderLineService;
import com.example.map_proiect_restaurant.service.OrderService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/orderlines")
public class OrderLineController {

    private final OrderLineService orderLineService;
    private final OrderService orderService;
    private final MenuItemService menuItemService;

    public OrderLineController(OrderLineService orderLineService, OrderService orderService, MenuItemService menuItemService) {
        this.orderLineService = orderLineService;
        this.orderService = orderService;
        this.menuItemService = menuItemService;
    }

    // 🔍 Updated listOrderLines with filter and sort parameters
    @GetMapping
    public String listOrderLines(
            @RequestParam(required = false) Long orderId,
            @RequestParam(required = false) Long menuItemId,
            @RequestParam(required = false) Integer minQuantity,
            @RequestParam(defaultValue = "id") String sortBy,
            @RequestParam(defaultValue = "asc") String direction,
            Model model
    ) {
        model.addAttribute(
                "orderLines",
                orderLineService.filterAndSortOrderLines(orderId, menuItemId, minQuantity, sortBy, direction)
        );

        // Add filter parameters back to the model for the view
        model.addAttribute("orderId", orderId);
        model.addAttribute("menuItemId", menuItemId);
        model.addAttribute("minQuantity", minQuantity);
        model.addAttribute("sortBy", sortBy);
        model.addAttribute("direction", direction);

        return "orderlines/index";
    }

    @GetMapping("/new")
    public String showCreateForm(Model model) {
        model.addAttribute("orderLine", new OrderLine());
        model.addAttribute("orders", orderService.getAllOrders());
        model.addAttribute("menuItems", menuItemService.getAllMenuItems());
        return "orderlines/form";
    }

    @PostMapping
    public String createOrderLine(@Valid @ModelAttribute("orderLine") OrderLine orderLine, BindingResult result) {
        if (result.hasErrors()) {
            return "orderlines/form";
        }

        // Fetch entities by ID
        MenuItem menuItem = menuItemService.getMenuItemById(orderLine.getMenuItem().getId());
        Order order = orderService.getOrderById(orderLine.getOrder().getId());

        orderLine.setMenuItem(menuItem);
        orderLine.setOrder(order);

        orderLineService.addOrderLine(orderLine);
        return "redirect:/orderlines";
    }

    @GetMapping("/{id}/edit")
    public String showEditForm(@PathVariable Long id, Model model) {
        OrderLine orderLine = orderLineService.getOrderLineById(id);
        model.addAttribute("orderLine", orderLine);
        model.addAttribute("orders", orderService.getAllOrders());
        model.addAttribute("menuItems", menuItemService.getAllMenuItems());
        return "orderlines/form";
    }

    @PostMapping("/{id}")
    public String updateOrderLine(@PathVariable Long id, @Valid @ModelAttribute("orderLine") OrderLine orderLine, BindingResult result) {
        if (result.hasErrors()) {
            return "orderlines/form";
        }

        MenuItem menuItem = menuItemService.getMenuItemById(orderLine.getMenuItem().getId());
        Order order = orderService.getOrderById(orderLine.getOrder().getId());

        orderLine.setMenuItem(menuItem);
        orderLine.setOrder(order);

        orderLine.setId(id);
        orderLineService.updateOrderLine(orderLine);
        return "redirect:/orderlines";
    }

    @PostMapping("/{id}/delete")
    public String deleteOrderLine(@PathVariable Long id) {
        orderLineService.deleteOrderLine(id);
        return "redirect:/orderlines";
    }
}