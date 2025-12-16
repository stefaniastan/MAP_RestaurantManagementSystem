package com.example.map_proiect_restaurant.service;

import com.example.map_proiect_restaurant.model.MenuItem;
import com.example.map_proiect_restaurant.repository.MenuItemRepository;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MenuItemService {

    private final MenuItemRepository menuItemRepository;

    public MenuItemService(MenuItemRepository menuItemRepository) {
        this.menuItemRepository = menuItemRepository;
    }

    // 🔍 FILTER AND SORT method
    public List<MenuItem> filterAndSortMenuItems(
            String name,
            Double minPrice,
            Double maxPrice,
            String sortBy,
            String direction
    ) {
        Sort sort = Sort.by(
                direction.equalsIgnoreCase("desc") ? Sort.Direction.DESC : Sort.Direction.ASC,
                sortBy
        );

        // Filter by name
        if (name != null && !name.isEmpty()) {
            return menuItemRepository.findByNameContainingIgnoreCase(name);
        }

        // Filter by price range
        if (minPrice != null && maxPrice != null) {
            return menuItemRepository.findByPriceBetween(minPrice, maxPrice);
        }

        // Default: return all with sorting
        return menuItemRepository.findAll(sort);
    }

    public MenuItem addMenuItem(MenuItem menuItem) {
        return menuItemRepository.save(menuItem);
    }

    public MenuItem updateMenuItem(MenuItem menuItem) {
        return menuItemRepository.save(menuItem);
    }

    public List<MenuItem> getAllMenuItems() {
        return menuItemRepository.findAll();
    }

    public MenuItem getMenuItemById(Long id) {
        return menuItemRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Menu item not found"));
    }

    public void deleteMenuItem(Long id) {
        menuItemRepository.deleteById(id);
    }

    public List<MenuItem> getMenuItemsByName(String name) {
        return menuItemRepository.findByNameContainingIgnoreCase(name);
    }

    public List<MenuItem> getMenuItemsByPriceRange(Double minPrice, Double maxPrice) {
        return menuItemRepository.findByPriceBetween(minPrice, maxPrice);
    }
}