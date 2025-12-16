package com.example.map_proiect_restaurant.service;

import com.example.map_proiect_restaurant.model.OrderLine;
import com.example.map_proiect_restaurant.repository.OrderLineRepository;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderLineService {

    private final OrderLineRepository orderLineRepository;

    public OrderLineService(OrderLineRepository orderLineRepository) {
        this.orderLineRepository = orderLineRepository;
    }

    // 🔍 FILTER AND SORT method
    public List<OrderLine> filterAndSortOrderLines(
            Long orderId,
            Long menuItemId,
            Integer minQuantity,
            String sortBy,
            String direction
    ) {
        Sort sort = Sort.by(
                direction.equalsIgnoreCase("desc") ? Sort.Direction.DESC : Sort.Direction.ASC,
                sortBy
        );

        // Filter by order ID
        if (orderId != null) {
            return orderLineRepository.findByOrderId(orderId);
        }

        // Filter by menu item ID
        if (menuItemId != null) {
            return orderLineRepository.findByMenuItemId(menuItemId);
        }

        // Filter by minimum quantity
        if (minQuantity != null) {
            return orderLineRepository.findByQuantityGreaterThanEqual(minQuantity);
        }

        // Default: return all with sorting
        return orderLineRepository.findAll(sort);
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