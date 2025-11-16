package com.example.map_proiect_restaurant.model;

import com.example.map_proiect_restaurant.repository.InFileRepository;
import com.fasterxml.jackson.annotation.JsonProperty;

public class OrderLine implements InFileRepository.IdProvider {
    @JsonProperty("Id")
    private String Id;
    private String menuItemId;
    private double quantity;

    public OrderLine(){}

    public OrderLine(String Id, String menuItemId, double quantity) {
        this.Id = Id;
        this.menuItemId = menuItemId;
        this.quantity = quantity;

    }
    @Override
    public String getId() {return this.Id;}

    @Override
    public void setId(String Id) {this.Id = Id;}

    public String getMenuItemId() {return this.menuItemId;}
    public void setMenuItemId(String menuItemId) {this.menuItemId = menuItemId;}

    public double getQuantity() {return quantity;}
    public void setQuantity(double quantity) {this.quantity = quantity;}

}
