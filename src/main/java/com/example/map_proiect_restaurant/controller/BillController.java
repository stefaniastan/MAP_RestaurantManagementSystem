package com.example.map_proiect_restaurant.controller;

import com.example.map_proiect_restaurant.model.Bill;
import com.example.map_proiect_restaurant.model.Order;
import com.example.map_proiect_restaurant.service.BillService;
import com.example.map_proiect_restaurant.service.OrderService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/bill")
public class BillController {

    private final BillService billService;
    private final OrderService orderService;

    @Autowired
    public BillController(BillService billService, OrderService orderService) {
        this.billService = billService;
        this.orderService = orderService;
    }

    @GetMapping({"", "/"})
    public String listBills(Model model) {
        model.addAttribute("bills", billService.getAllBills());
        return "bill/index";
    }

    @GetMapping("/new")
    public String showCreateForm(Model model) {
        model.addAttribute("bill", new Bill());
        model.addAttribute("orders", orderService.getAllOrders());
        return "bill/form";
    }

    @PostMapping

    public String createBill(@Valid @ModelAttribute("bill") Bill bill,
                             BindingResult result,
                             @RequestParam("order") Long orderId,
                             Model model) {

        Order order = orderService.getOrderById(orderId);

        if (order == null) {
            result.rejectValue("order", "error.bill", "The selected order could not be found.");
        }


        bill.setOrder(order);
        if (order != null) {
            order.setBill(bill);
        }

        if (result.hasErrors()) {
            model.addAttribute("orders", orderService.getAllOrders());
            return "bill/form";
        }

        billService.addBill(bill);
        return "redirect:/bill";
    }

    @GetMapping("/{id}/edit")
    public String showEditForm(@PathVariable Long id, Model model) {
        Bill bill = billService.getBillById(id);

        model.addAttribute("bill", bill);
        model.addAttribute("orders", orderService.getAllOrders());

        return "bill/form";
    }

    @PostMapping("/{id}")
    public String updateBill(@PathVariable Long id,
                             @Valid @ModelAttribute("bill") Bill bill,
                             BindingResult result,
                             @RequestParam("order") Long orderId,
                             Model model) {

        Order order = orderService.getOrderById(orderId);

        if (order == null) {
            result.rejectValue("order", "error.bill", "The selected order could not be found.");
        }

        bill.setId(id);
        bill.setOrder(order);
        if (order != null) {
            order.setBill(bill); // <--- ADD THIS LINE
        }

        if (result.hasErrors()) {
            model.addAttribute("orders", orderService.getAllOrders());
            return "bill/form";
        }

        billService.updateBill(bill);
        return "redirect:/bill";
    }

    @PostMapping("/{id}/delete")
    public String deleteBill(@PathVariable Long id) {
        billService.deleteBill(id);
        return "redirect:/bill";
    }
}
