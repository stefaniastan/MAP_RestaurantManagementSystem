package com.example.map_proiect_restaurant.repository;

import com.example.map_proiect_restaurant.model.Chef;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ChefRepository extends JpaRepository<Chef, Long> {
    // 🔍 FILTER
    List<Chef> findBySpecialization(String specialization);

    List<Chef> findByAge(Integer age);

    List<Chef> findByRating(String rating);
}