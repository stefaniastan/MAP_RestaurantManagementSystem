package com.example.map_proiect_restaurant.controller;

import com.example.map_proiect_restaurant.model.Bill;
import com.example.map_proiect_restaurant.service.BillService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/bills")
public class BillController {

    private final BillService billService;

    public BillController(BillService billService) {
        this.billService = billService;
    }

    @GetMapping
    public String getAllBills(Model model) {
        model.addAttribute("bills", billService.getAllBills());
        return "bill/bill-index";
    }

    @GetMapping("/new")
    public String createForm(Model model) {
        model.addAttribute("bill", new Bill("", "", 0.0));
        return "bill/bill-form";
    }

    @PostMapping
    public String createBill(@ModelAttribute Bill bill) {
        billService.addBill(bill);
        return "redirect:/bills";
    }

    @PostMapping("/{id}/delete")
    public String deleteBill(@PathVariable String id) {
        billService.deleteBill(id);
        return "redirect:/bills";
    }
}
