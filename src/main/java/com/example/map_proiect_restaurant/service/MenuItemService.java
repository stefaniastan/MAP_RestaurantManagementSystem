package com.example.map_proiect_restaurant.service;

import com.example.map_proiect_restaurant.model.MenuItem;
import com.example.map_proiect_restaurant.repository.MenuItemRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MenuItemService {

    private final MenuItemRepository menuItemRepository;

    public MenuItemService(MenuItemRepository menuItemRepository) {
        this.menuItemRepository = menuItemRepository;
    }

    public List<MenuItem> findAllMenuItems(){
        return menuItemRepository.findAll();
    }

    public MenuItem findMenuItemById(String id){
        return menuItemRepository.findById(id);
    }

    public MenuItem addMenuItem(MenuItem menuItem){
        return menuItemRepository.save(menuItem);
    }

    public MenuItem updateMenuItem(MenuItem menuItem){
        return menuItemRepository.save(menuItem);
    }

    public void deleteMenuItem(String id){
        menuItemRepository.deleteById(id);
    }
}
