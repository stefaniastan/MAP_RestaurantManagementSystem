package com.example.map_proiect_restaurant.repository;

import com.example.map_proiect_restaurant.model.OrderLine;
import org.springframework.stereotype.Repository;

@Repository
public class OrderLineRepository extends InFileRepository<OrderLine> {
    public OrderLineRepository() {
        super(OrderLine.class, "src/main/resources/data/orderlines.json");
    }
}
