package com.example.map_proiect_restaurant.controller;

import com.example.map_proiect_restaurant.model.Customer;
import com.example.map_proiect_restaurant.service.CustomerService;
import jakarta.validation.Valid;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/customers")
public class CustomerController {

    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping
    public String listCustomers(
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String email,
            @RequestParam(defaultValue = "name") String sortBy,
            @RequestParam(defaultValue = "asc") String direction,
            Model model
    ) {

        Sort sort = direction.equals("asc")
                ? Sort.by(sortBy).ascending()
                : Sort.by(sortBy).descending();

        List<Customer> customers =
                customerService.findCustomers(name, email, sort);

        model.addAttribute("customers", customers);

        // ca să păstreze valorile în form
        model.addAttribute("name", name);
        model.addAttribute("email", email);
        model.addAttribute("sortBy", sortBy);
        model.addAttribute("direction", direction);

        return "customer/index";
    }


    @GetMapping("/new")
    public String showCreateForm(Model model) {
        model.addAttribute("customer", new Customer());
        return "customer/form";
    }

    @PostMapping
    public String createCustomer(@Valid @ModelAttribute("customer") Customer customer, BindingResult result) {
        if (result.hasErrors()) {
            return "customer/form";
        }
        customerService.addCustomer(customer);
        return "redirect:/customers";
    }

    @GetMapping("/{id}/edit")
    public String showEditForm(@PathVariable Long id, Model model) {
        Customer customer = customerService.getCustomerById(id);
        model.addAttribute("customer", customer);
        return "customer/form";
    }

    @PostMapping("/{id}")
    public String updateCustomer(@PathVariable Long id, @Valid @ModelAttribute("customer") Customer customer, BindingResult result) {
        if (result.hasErrors()) {
            return "customer/form";
        }
        customer.setId(id);
        customerService.updateCustomer(customer);
        return "redirect:/customers";
    }

    @PostMapping("/{id}/delete")
    public String deleteCustomer(@PathVariable Long id) {
        customerService.deleteCustomer(id);
        return "redirect:/customers";
    }
    @GetMapping("/{id}")
    public String showCustomerDetails(@PathVariable Long id, Model model) {
        Customer customer = customerService.getCustomerById(id);

        // Fallback if customer is not found
        if (customer == null) {
            return "redirect:/customers";
        }

        model.addAttribute("customer", customer);
        return "customer/details";
    }
}