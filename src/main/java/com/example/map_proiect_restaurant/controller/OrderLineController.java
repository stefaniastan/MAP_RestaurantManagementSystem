package com.example.map_proiect_restaurant.controller;

import com.example.map_proiect_restaurant.model.OrderLine;
import com.example.map_proiect_restaurant.service.OrderLineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/order-lines")
public class OrderLineController {

    private final OrderLineService orderLineService;

    @Autowired
    public OrderLineController(OrderLineService orderLineService) {
        this.orderLineService = orderLineService;
    }

    @GetMapping
    public List<OrderLine> getAllOrderLines() {
        return orderLineService.getAllOrderLines();
    }

    @GetMapping("/{id}")
    public OrderLine getOrderLineById(@PathVariable Long id) {
        return orderLineService.getOrderLineById(id);
    }

    @PostMapping
    public OrderLine createOrderLine(@RequestBody OrderLine orderLine) {
        return orderLineService.addOrderLine(orderLine);
    }

    @PutMapping("/{id}")
    public OrderLine updateOrderLine(@PathVariable Long id, @RequestBody OrderLine orderLine) {
        orderLine.setId(id);
        return orderLineService.updateOrderLine(orderLine);
    }

    @DeleteMapping("/{id}")
    public String deleteOrderLine(@PathVariable Long id) {
        orderLineService.deleteOrderLine(id);
        return "Order line deleted successfully";
    }

    @GetMapping("/order/{orderId}")
    public List<OrderLine> getOrderLinesByOrderId(@PathVariable Long orderId) {
        return orderLineService.getOrderLinesByOrderId(orderId);
    }

    @GetMapping("/menu-item/{menuItemId}")
    public List<OrderLine> getOrderLinesByMenuItemId(@PathVariable Long menuItemId) {
        return orderLineService.getOrderLinesByMenuItemId(menuItemId);
    }
}
