package com.example.map_proiect_restaurant.model;

import com.example.map_proiect_restaurant.repository.InFileRepository;

import java.util.List;

public class Table implements InFileRepository.IdProvider{

    private String Id;
    private Integer number;
    private String occupiedStatus;
    private List<Order> orders;

    public Table(){}

    public Table(String Id, String occupiedStatus, Integer number, List<Order> orders) {
        this.Id = Id;
        this.occupiedStatus = occupiedStatus;
        this.number = number;
        this.orders = orders;

    }
    @Override
    public String getId(){
        return Id;
    }

    @Override
    public void setId(String Id){
        this.Id = Id;
    }

    public String getOccupiedStatus(){
        return occupiedStatus;
    }

    public void setOccupiedStatus(String occupiedStatus){
        this.occupiedStatus = occupiedStatus;
    }

    public Integer getNumber(){
        return number;
    }

    public void setNumber(Integer number){
        this.number = number;
    }

    public List<Order> getOrders(){
        return orders;
    }

    public void setOrders(List<Order> orders){
        this.orders = orders;
    }
}

