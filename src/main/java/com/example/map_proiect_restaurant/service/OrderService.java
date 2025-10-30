package com.example.map_proiect_restaurant.service;

import com.example.map_proiect_restaurant.model.Order;
import com.example.map_proiect_restaurant.repository.OrderRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {

    private final OrderRepository orderRepository;

    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public Order addOrder(Order order){
        return orderRepository.save(order);
    }

    public Order updateOrder(Order order){
        return orderRepository.save(order);
    }

    public List<Order> getAllOrders(){
        return orderRepository.findAll();
    }

    public Order getOrderById(String id){
        return orderRepository.findById(id);
    }

    public void deleteOrder(String id){
        orderRepository.deleteById(id);
    }
}
