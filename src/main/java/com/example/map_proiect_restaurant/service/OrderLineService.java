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

    public OrderLine addOrderLine(OrderLine orderLine) {
        return orderLineRepository.save(orderLine);
    }

    public OrderLine updateOrderLine(OrderLine orderLine) {
        return orderLineRepository.save(orderLine);
    }

    public List<OrderLine> getAllOrderLines() {
        return orderLineRepository.findAll();
    }

    public OrderLine getOrderLineById(Long id) {
        return orderLineRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Order line not found"));
    }

    public void deleteOrderLine(Long id) {
        orderLineRepository.deleteById(id);
    }

    public List<OrderLine> getOrderLinesByOrderId(Long orderId) {
        return orderLineRepository.findByOrderId(orderId);
    }

    public List<OrderLine> getOrderLinesByMenuItemId(Long menuItemId) {
        return orderLineRepository.findByMenuItemId(menuItemId);
    }
}