package com.example.map_proiect_restaurant.repository;

import com.example.map_proiect_restaurant.model.Bill;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BillRepository extends JpaRepository<Bill, Long> {
    List<Bill> findByOrderId(Long orderId);
    List<Bill> findByOrder_Id(Long orderId);

    List<Bill> findByTotalAmountBetween(Double min, Double max);
}