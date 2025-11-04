package com.example.map_proiect_restaurant.controller;


import com.example.map_proiect_restaurant.model.Customer;
import org.springframework.ui.Model;
import com.example.map_proiect_restaurant.service.CustomerService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/customers")
public class CustomerController {

    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping
    public String getAllCustomers(Model model) {
        model.addAttribute("customers", customerService.getAllCustomers());
        return "customer/index";
    }

    @GetMapping("/new")
    public String createForm(Model model) {
        model.addAttribute("customer", new Customer("", "", null, "", ""));
        return "customer/form";
    }

    @PostMapping
    public String createCustomer(@ModelAttribute Customer customer) {
        customerService.addCustomer(customer);
        return "redirect:/customers";
    }

    @PostMapping("/{id}/delete")
    public String deleteCustomer(@PathVariable String id) {
        customerService.deleteCustomer(id);
        return "redirect:/customers";
    }
}
