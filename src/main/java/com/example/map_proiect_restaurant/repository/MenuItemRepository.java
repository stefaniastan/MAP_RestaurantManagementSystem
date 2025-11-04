package com.example.map_proiect_restaurant.repository;
import com.example.map_proiect_restaurant.model.MenuItem;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Repository
public class MenuItemRepository implements AbstractRepository <MenuItem>{
    private final List<MenuItem> menuItems = new ArrayList<>(Arrays.asList(
            new MenuItem("MenuItem1", "Pizza Diavola", 30),
            new MenuItem("MenuItem2", "Pasta Carbonara", 46)
    ));


    @Override
    public MenuItem save(MenuItem menuItem) {
        menuItems.add(menuItem);
        return menuItem;
    }

    @Override
    public List<MenuItem> findAll() {
        return menuItems;
    }

    @Override
    public MenuItem findById(String id) {
        for (MenuItem menuItem : menuItems) {
            if (menuItem.getId().equals(id)) {
                return menuItem;
            }
        }
        return null;
    }

    @Override
    public void deleteById(String id) {
        menuItems.removeIf(menuItem -> menuItem.getId().equals(id));
    }

}
