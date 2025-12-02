package com.example.map_proiect_restaurant.controller;

import com.example.map_proiect_restaurant.model.RestaurantTable;
import com.example.map_proiect_restaurant.service.RestaurantTableService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/tables")
public class RestaurantTableController {

    private final RestaurantTableService tableService;

    public RestaurantTableController(RestaurantTableService tableService) {
        this.tableService = tableService;
    }

    @GetMapping
    public String listTables(Model model) {
        List<RestaurantTable> tables = tableService.getAllTables();
        model.addAttribute("tables", tables);
        return "tables/index";
    }

    @GetMapping("/new")
    public String showCreateForm(Model model) {
        model.addAttribute("table", new RestaurantTable());
        return "tables/form";
    }

    @PostMapping
    public String createTable(@Valid @ModelAttribute("table") RestaurantTable table, BindingResult result) {
        if (result.hasErrors()) {
            return "tables/form";
        }
        tableService.addTable(table);
        return "redirect:/tables";
    }

    @GetMapping("/{id}/edit")
    public String showEditForm(@PathVariable Long id, Model model) {
        RestaurantTable table = tableService.getTableById(id);
        model.addAttribute("table", table);
        return "tables/form";
    }

    @PostMapping("/{id}")
    public String updateTable(@PathVariable Long id, @Valid @ModelAttribute("table") RestaurantTable table, BindingResult result) {
        if (result.hasErrors()) {
            return "tables/form";
        }
        table.setId(id);
        tableService.updateTable(table);
        return "redirect:/tables";
    }

    @PostMapping("/{id}/delete")
    public String deleteTable(@PathVariable Long id) {
        tableService.deleteTable(id);
        return "redirect:/tables";
    }
}
