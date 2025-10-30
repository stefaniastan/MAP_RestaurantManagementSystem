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

    public OrderLine addOrderLine(OrderLine orderLine){
        return orderLineRepository.save(orderLine);
    }

    public OrderLine updateOrderLine(OrderLine orderLine){
        return orderLineRepository.save(orderLine);
    }

    public void deleteOrderLine(OrderLine orderLine){
        orderLineRepository.deleteById(orderLine.getId());
    }

    public OrderLine getOrderLineById(String id){
        return orderLineRepository.findById(id);
    }

    public List<OrderLine> getAllOrderLines(){
        return orderLineRepository.findAll();
    }

}
