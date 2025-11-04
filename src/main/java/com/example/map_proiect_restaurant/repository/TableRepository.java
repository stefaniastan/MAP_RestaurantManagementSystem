package com.example.map_proiect_restaurant.repository;

import com.example.map_proiect_restaurant.model.Order;
import com.example.map_proiect_restaurant.model.Table;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Repository
public class TableRepository implements AbstractRepository<Table>{
    private final List<Table> tables = new ArrayList<>(Arrays.asList(
            new Table("Table1", "Occupied", 1, new ArrayList<Order>()),
            new Table("Table2", "Free", 2, new ArrayList<Order>())
    ));

    @Override
    public Table save(Table table) {
        tables.add(table);
        return table;
    }

    @Override
    public List<Table> findAll() {
        return tables;
    }

    @Override
    public Table findById(String id) {
        for (Table table : tables) {
            if (table.getId().equals(id)) {
                return table;
            }
        }
        return null;
    }

    @Override
    public void deleteById(String id) {
        tables.removeIf(table -> table.getId().equals(id));
    }

}
