package com.example.map_proiect_restaurant.controller;

import com.example.map_proiect_restaurant.model.OrderLine;
import com.example.map_proiect_restaurant.service.OrderLineService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/orderLines")
public class OrderLineController {

    private final OrderLineService orderLineService;

    public OrderLineController(OrderLineService orderLineService) {
        this.orderLineService = orderLineService;
    }

    @GetMapping
    public String getAllOrderLines(Model model) {
        model.addAttribute("orderLines", orderLineService.getAllOrderLines());
        return "orderLine/orderLine-index";
    }

    @GetMapping("/new")
    public String createForm(Model model) {
        model.addAttribute("orderLine", new OrderLine("", "", 0.0));
        return "orderLine/orderLine-form";
    }

    @PostMapping
    public String createOrderLine(@ModelAttribute OrderLine orderLine) {
        orderLineService.addOrderLine(orderLine);
        return "redirect:/orderLines";
    }

    @PostMapping("/{id}/delete")
    public String deleteOrderLine(@PathVariable String id) {
        orderLineService.deleteOrderLine(id);
        return "redirect:/orderLines";
    }
}
