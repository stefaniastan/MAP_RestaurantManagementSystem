package com.example.map_proiect_restaurant.repository;

import com.example.map_proiect_restaurant.model.RestaurantTable;
import com.example.map_proiect_restaurant.model.TableStatusEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RestaurantTableRepository extends JpaRepository<RestaurantTable, Long> {
    List<RestaurantTable> findByStatus(TableStatusEnum status);
    boolean existsByNumber(Integer number);
}
//