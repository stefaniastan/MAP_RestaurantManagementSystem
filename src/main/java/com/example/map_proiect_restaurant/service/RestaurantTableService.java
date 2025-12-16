package com.example.map_proiect_restaurant.service;

import com.example.map_proiect_restaurant.model.RestaurantTable;
import com.example.map_proiect_restaurant.model.TableStatusEnum;
import com.example.map_proiect_restaurant.repository.RestaurantTableRepository;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RestaurantTableService {

    private final RestaurantTableRepository tableRepository;

    public RestaurantTableService(RestaurantTableRepository tableRepository) {
        this.tableRepository = tableRepository;
    }

    // 🔍 FILTER AND SORT method
    public List<RestaurantTable> filterAndSortTables(
            Integer number,
            TableStatusEnum status,
            String sortBy,
            String direction
    ) {
        Sort sort = Sort.by(
                direction.equalsIgnoreCase("desc") ? Sort.Direction.DESC : Sort.Direction.ASC,
                sortBy
        );

        // Filter by table number
        if (number != null) {
            return tableRepository.findByNumber(number);
        }

        // Filter by status
        if (status != null) {
            return tableRepository.findByStatus(status);
        }

        // Default: return all with sorting
        return tableRepository.findAll(sort);
    }

    public RestaurantTable addTable(RestaurantTable table) {
        if (tableRepository.existsByNumber(table.getNumber())) {
            throw new IllegalStateException("Table number already exists");
        }
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