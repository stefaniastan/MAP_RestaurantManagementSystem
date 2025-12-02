package com.example.map_proiect_restaurant.repository;

import com.example.map_proiect_restaurant.model.OrderAssignment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderAssignmentRepository extends JpaRepository<OrderAssignment, Long> {
    List<OrderAssignment> findByOrderId(Long orderId);
    List<OrderAssignment> findByStaffId(Long staffId);
}