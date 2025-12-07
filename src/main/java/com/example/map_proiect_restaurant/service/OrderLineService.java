package com.example.map_proiect_restaurant.service;

import com.example.map_proiect_restaurant.model.OrderLine;
import com.example.map_proiect_restaurant.repository.OrderLineRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderLineService {

    private final OrderLineRepository orderLineRepository;

    public OrderLineService(OrderLineRepository orderLineRepository) {
        this.orderLineRepository = orderLineRepository;
    }

    public List<OrderLine> getAllOrderLines() {
        // Use optimized query
        return orderLineRepository.findAllWithMenuItemAndOrder();
    }

    public void addOrderLine(OrderLine orderLine) {
        orderLineRepository.save(orderLine);
    }

    public OrderLine getOrderLineById(Long id) {
        return orderLineRepository.findById(id).orElseThrow(() ->
                new RuntimeException("OrderLine not found")
        );
    }

    public void updateOrderLine(OrderLine orderLine) {
        orderLineRepository.save(orderLine);
    }

    public void deleteOrderLine(Long id) {
        orderLineRepository.deleteById(id);
    }
}
