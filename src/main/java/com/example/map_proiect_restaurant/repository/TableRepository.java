package com.example.map_proiect_restaurant.repository;

import com.example.map_proiect_restaurant.model.Table;
import org.springframework.stereotype.Repository;

@Repository
public class TableRepository extends InFileRepository<Table> {
    public TableRepository() {
        super(Table.class, "src/main/resources/data/tables.json");
    }
}
