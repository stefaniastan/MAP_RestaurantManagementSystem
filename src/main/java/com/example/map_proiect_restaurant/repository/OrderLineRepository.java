package com.example.map_proiect_restaurant.repository;

import com.example.map_proiect_restaurant.model.OrderLine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderLineRepository extends JpaRepository<OrderLine, Long> {

    @Query("SELECT ol FROM OrderLine ol " +
            "JOIN FETCH ol.menuItem " +
            "JOIN FETCH ol.order o " +
            "LEFT JOIN FETCH o.customer " +
            "LEFT JOIN FETCH o.table")
    List<OrderLine> findAllWithMenuItemAndOrder();
}
