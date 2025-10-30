package com.example.map_proiect_restaurant.service;

import com.example.map_proiect_restaurant.model.Table;
import com.example.map_proiect_restaurant.repository.TableRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TableService {

    private final TableRepository tableRepository;

    public TableService(TableRepository tableRepository) {
        this.tableRepository = tableRepository;
    }

    public Table addTable(Table table){
        return tableRepository.save(table);
    }

    public Table updateTable(Table table){
        return tableRepository.save(table);
    }

    public List<Table> getAllTables(){
        return tableRepository.findAll();
    }

    public Table getTableById(String id){
        return tableRepository.findById(id);
    }

    public void deleteTable(String id){
        tableRepository.deleteById(id);
    }
}
