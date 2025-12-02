package com.example.map_proiect_restaurant.service;

import com.example.map_proiect_restaurant.model.RestaurantTable;
import com.example.map_proiect_restaurant.model.TableStatusEnum;
import com.example.map_proiect_restaurant.repository.RestaurantTableRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RestaurantTableService {

    private final RestaurantTableRepository tableRepository;

    public RestaurantTableService(RestaurantTableRepository tableRepository) {
        this.tableRepository = tableRepository;
    }

    public RestaurantTable addTable(RestaurantTable table) {
        return tableRepository.save(table);
    }

    public RestaurantTable updateTable(RestaurantTable table) {
        return tableRepository.save(table);
    }

    public List<RestaurantTable> getAllTables() {
        return tableRepository.findAll();
    }

    public RestaurantTable getTableById(Long id) {
        return tableRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Table not found"));
    }

    public void deleteTable(Long id) {
        tableRepository.deleteById(id);
    }

    public List<RestaurantTable> getTablesByStatus(TableStatusEnum status) {
        return tableRepository.findByStatus(status);
    }
}