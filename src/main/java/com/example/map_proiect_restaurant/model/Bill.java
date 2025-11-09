package com.example.map_proiect_restaurant.model;

import com.example.map_proiect_restaurant.repository.InFileRepository;

public class Bill implements InFileRepository.IdProvider {
    private String Id;
    private String orderId;
    private double totalAmount;

    public Bill(){}

    public Bill(String Id, String orderId, double totalAmount) {
        this.Id = Id;
        this.orderId = orderId;
        this.totalAmount = totalAmount;

    }
    @Override
    public String getId() {
        return Id;
    }

    @Override
    public void setId(String Id) {
        this.Id = Id;
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
