package com.example.map_proiect_restaurant.model;

import com.example.map_proiect_restaurant.repository.InFileRepository;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class Table implements InFileRepository.IdProvider{
    @JsonProperty("Id")
    private String Id;
    private Integer number;
    private TableStatusEnum occupiedStatus;
    private List<Order> orders;

    public Table(){}

    public Table(String Id, TableStatusEnum occupiedStatus, Integer number, List<Order> orders) {
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

    public TableStatusEnum getOccupiedStatus(){
        return occupiedStatus;
    }

    public void setOccupiedStatus(TableStatusEnum occupiedStatus){
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

