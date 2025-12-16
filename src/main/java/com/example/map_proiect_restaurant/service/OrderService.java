package com.example.map_proiect_restaurant.service;

import com.example.map_proiect_restaurant.model.Order;
import com.example.map_proiect_restaurant.model.OrderStatusEnum;
import com.example.map_proiect_restaurant.repository.OrderRepository;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {

    private final OrderRepository orderRepository;

    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    // 🔍 FILTER AND SORT method
    public List<Order> filterAndSortOrders(
            Long customerId,
            Long tableId,
            OrderStatusEnum status,
            String sortBy,
            String direction
    ) {
        Sort sort = Sort.by(
                direction.equalsIgnoreCase("desc") ? Sort.Direction.DESC : Sort.Direction.ASC,
                sortBy
        );

        // Filter by customer ID
        if (customerId != null) {
            return orderRepository.findByCustomer_Id(customerId);
        }

        // Filter by table ID
        if (tableId != null) {
            return orderRepository.findByTable_Id(tableId);
        }

        // Filter by status
        if (status != null) {
            return orderRepository.findByStatus(status);
        }

        // Default: return all with sorting
        return orderRepository.findAll(sort);
    }

    public Order addOrder(Order order) {
        if (order.getCustomer() == null) {
            throw new IllegalStateException("Customer does not exist");
        }
        if (order.getTable() == null) {
            throw new IllegalStateException("Table does not exist");
        }
        return orderRepository.save(order);
    }

    public Order updateOrder(Order order) {
        return orderRepository.save(order);
    }

    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    public Order getOrderById(Long id) {
        return orderRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Order not found"));
    }

    public void deleteOrder(Long id) {
        orderRepository.deleteById(id);
    }

    public List<Order> getOrdersByCustomerId(Long customerId) {
        return orderRepository.findByCustomerId(customerId);
    }

    public List<Order> getOrdersByTableId(Long tableId) {
        return orderRepository.findByTableId(tableId);
    }

    public List<Order> getOrdersByStatus(OrderStatusEnum status) {
        return orderRepository.findByStatus(status);
    }
}