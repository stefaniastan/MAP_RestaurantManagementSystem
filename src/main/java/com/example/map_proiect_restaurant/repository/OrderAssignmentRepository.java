package com.example.map_proiect_restaurant.repository;

import com.example.map_proiect_restaurant.model.OrderAssignment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderAssignmentRepository extends JpaRepository<OrderAssignment, Long> {
    List<OrderAssignment> findByOrderId(Long orderId);
    List<OrderAssignment> findByStaffId(Long staffId);
    boolean existsByOrderIdAndStaffId(Long orderId, Long staffId);
    // 🔍 FILTER methods
    List<OrderAssignment> findByOrder_Id(Long orderId);
    List<OrderAssignment> findByStaff_Id(Long staffId);
}