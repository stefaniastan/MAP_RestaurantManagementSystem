package com.example.map_proiect_restaurant.repository;

import com.example.map_proiect_restaurant.model.OrderLine;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Repository
public class OrderLineRepository implements AbstractRepository<OrderLine>{
    private final List<OrderLine> orderLines = new ArrayList<>(Arrays.asList(
            new OrderLine("OrderLine1", "MenuItem1", 3),
            new OrderLine("OrderLine2", "MenuItem2", 10)
    ));

    @Override
    public OrderLine save(OrderLine orderLine) {
        orderLines.add(orderLine);
        return orderLine;
    }

    @Override
    public List<OrderLine> findAll() {
        return orderLines;
    }

    @Override
    public OrderLine findById(Integer id) {
        for (OrderLine orderLine : orderLines) {
            if (orderLine.getId().equals(id)) {
                return orderLine;
            }
        }
        return null;
    }

    @Override
    public void deleteById(Integer id) {
        for (OrderLine orderLine : orderLines) {
            if (orderLine.getId().equals(id)) {
                orderLines.remove(orderLine);
            }
        }
    }
}
