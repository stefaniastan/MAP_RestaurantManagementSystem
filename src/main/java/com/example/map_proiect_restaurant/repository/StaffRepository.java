package com.example.map_proiect_restaurant.repository;

import com.example.map_proiect_restaurant.model.Staff;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StaffRepository extends JpaRepository<Staff, Long> {
}
