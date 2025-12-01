package com.example.map_proiect_restaurant.repository;

import com.example.map_proiect_restaurant.model.OrderLine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderLineRepository extends JpaRepository<OrderLine, Long> {
    List<OrderLine> findByOrderId(Long orderId);
    List<OrderLine> findByMenuItemId(Long menuItemId);
}