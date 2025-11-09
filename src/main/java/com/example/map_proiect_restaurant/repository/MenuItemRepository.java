package com.example.map_proiect_restaurant.repository;

import com.example.map_proiect_restaurant.model.MenuItem;
import org.springframework.stereotype.Repository;

@Repository
public class MenuItemRepository extends InFileRepository<MenuItem> {
    public MenuItemRepository() {
        super(MenuItem.class, "src/main/resources/data/menuitems.json");
    }
}
