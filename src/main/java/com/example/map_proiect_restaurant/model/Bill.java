package com.example.map_proiect_restaurant.model;

public class Bill {
    private String Id;
    private String orderId;
    private double totalAmount;

    public Bill(String id, String orderId, double totalAmount) {
        this.Id = Id;
        this.orderId = orderId;
        this.totalAmount = totalAmount;

    }

    public String getId() {return Id;}
    public void setId(String id) {this.Id = id;}

    public String getOrderId() {return orderId;}
    public void setOrderId(String orderId) {this.orderId = orderId;}

    public double getTotalAmount() {return totalAmount;}
    public void setTotalAmount(double totalAmount) {this.totalAmount = totalAmount;}


}
