package com.example.map_proiect_restaurant.controller;

import com.example.map_proiect_restaurant.model.RestaurantTable;
import com.example.map_proiect_restaurant.model.TableStatusEnum;
import com.example.map_proiect_restaurant.service.RestaurantTableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tables")
public class RestaurantTableController {

    private final RestaurantTableService tableService;

    @Autowired
    public RestaurantTableController(RestaurantTableService tableService) {
        this.tableService = tableService;
    }

    @GetMapping
    public List<RestaurantTable> getAllTables() {
        return tableService.getAllTables();
    }

    @GetMapping("/{id}")
    public RestaurantTable getTableById(@PathVariable Long id) {
        return tableService.getTableById(id);
    }

    @PostMapping
    public RestaurantTable createTable(@RequestBody RestaurantTable table) {
        return tableService.addTable(table);
    }

    @PutMapping("/{id}")
    public RestaurantTable updateTable(@PathVariable Long id, @RequestBody RestaurantTable table) {
        table.setId(id);
        return tableService.updateTable(table);
    }

    @DeleteMapping("/{id}")
    public String deleteTable(@PathVariable Long id) {
        tableService.deleteTable(id);
        return "Table deleted successfully";
    }

    @GetMapping("/number/{number}")
    public RestaurantTable getTableByNumber(@PathVariable Long number) {
        return tableService.getTableById(number);
    }

    @GetMapping("/status/{status}")
    public List<RestaurantTable> getTablesByStatus(@PathVariable TableStatusEnum status) {
        return tableService.getTablesByStatus(status);
    }
}
