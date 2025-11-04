package com.example.map_proiect_restaurant.controller;

import com.example.map_proiect_restaurant.model.Table;
import com.example.map_proiect_restaurant.service.TableService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/tables")
public class TableController {

    private final TableService tableService;

    public TableController(TableService tableService) {
        this.tableService = tableService;
    }

    // 🔹 GET all
    @GetMapping
    public String getAllTables(Model model) {
        model.addAttribute("tables", tableService.getAllTables());
        return "table/index";
    }

    // 🔹 GET form (for create)
    @GetMapping("/new")
    public String createForm(Model model) {
        model.addAttribute("table", new Table("", "free", 0, null));
        return "table/form";
    }

    // 🔹 POST create
    @PostMapping
    public String createTable(@ModelAttribute Table table) {
        tableService.addTable(table);
        return "redirect:/tables";
    }

    // 🔹 POST delete
    @PostMapping("/{id}/delete")
    public String deleteTable(@PathVariable String id) {
        tableService.deleteTable(id);
        return "redirect:/tables";
    }
}

