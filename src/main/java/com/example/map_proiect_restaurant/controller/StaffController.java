package com.example.map_proiect_restaurant.controller;

import com.example.map_proiect_restaurant.model.Staff;
import com.example.map_proiect_restaurant.model.Chef;
import com.example.map_proiect_restaurant.model.Server;
import com.example.map_proiect_restaurant.service.StaffService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/staff")
public class StaffController {

    private final StaffService staffService;

    public StaffController(StaffService staffService) {
        this.staffService = staffService;
    }

    @GetMapping
    public String listStaff(Model model) {
        List<Staff> staffList = staffService.getAllStaff();
        model.addAttribute("staffList", staffList);
        return "staff/index";
    }

    @GetMapping("/new")
    public String showCreateForm(Model model) {
        model.addAttribute("staff", new Staff() {}); // abstract, form will allow selecting type
        return "staff/form";
    }

    @PostMapping
    public String createStaff(@Valid @ModelAttribute("staff") Staff staff, BindingResult result) {
        if (result.hasErrors()) {
            return "staff/form";
        }
        staffService.addStaff(staff);
        return "redirect:/staff";
    }

    @GetMapping("/{id}/edit")
    public String showEditForm(@PathVariable Long id, Model model) {
        Staff staff = staffService.getStaffById(id);
        model.addAttribute("staff", staff);
        return "staff/form";
    }

    @PostMapping("/{id}")
    public String updateStaff(@PathVariable Long id, @Valid @ModelAttribute("staff") Staff staff, BindingResult result) {
        if (result.hasErrors()) {
            return "staff/form";
        }
        staff.setId(id);
        staffService.updateStaff(staff);
        return "redirect:/staff";
    }

    @PostMapping("/{id}/delete")
    public String deleteStaff(@PathVariable Long id) {
        staffService.deleteStaff(id);
        return "redirect:/staff";
    }
}
