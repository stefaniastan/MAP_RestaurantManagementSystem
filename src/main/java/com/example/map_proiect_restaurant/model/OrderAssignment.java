package com.example.map_proiect_restaurant.model;

import com.example.map_proiect_restaurant.repository.InFileRepository;

public class OrderAssignment implements InFileRepository.IdProvider {
    private String Id;
    private String orderId;
    private String staffId;

    public OrderAssignment(){}

    public OrderAssignment(String Id, String orderId, String staffId) {
        this.Id = Id;
        this.orderId = orderId;
        this.staffId = staffId;

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

    public String getStaffId() {
        return staffId;
    }
    public void setStaffId(String staffId) {
        this.staffId = staffId;
    }
}
