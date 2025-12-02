package com.example.map_proiect_restaurant.repository;

import com.example.map_proiect_restaurant.model.MenuItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MenuItemRepository extends JpaRepository<MenuItem, Long> {
    List<MenuItem> findByNameContainingIgnoreCase(String name);
    List<MenuItem> findByPriceBetween(Double minPrice, Double maxPrice);
}