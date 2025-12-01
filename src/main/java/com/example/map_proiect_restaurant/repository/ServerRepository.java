package com.example.map_proiect_restaurant.repository;

import com.example.map_proiect_restaurant.model.Server;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ServerRepository extends JpaRepository<Server, Long> {
    List<Server> findByDesignation(String designation);
}