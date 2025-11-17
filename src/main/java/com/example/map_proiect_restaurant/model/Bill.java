package com.example.map_proiect_restaurant.model;

import com.example.map_proiect_restaurant.repository.InFileRepository;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Bill implements InFileRepository.IdProvider {
    private String id;
    private String orderId;
    private double totalAmount;

    public Bill(){}

    public Bill(String id, String orderId, double totalAmount) {
        this.id = id;
        this.orderId = orderId;
        this.totalAmount = totalAmount;

    }
    @Override
    public String getId() {
        return id;
    }

    @Override
    public void setId(String id) {
        this.id = id;
    }

    public String getOrderId() {
        return orderId;
    }
    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public double getTotalAmount() {
        return totalAmount;
    }
    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }


}
