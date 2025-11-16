package com.example.map_proiect_restaurant.model;

import com.example.map_proiect_restaurant.repository.InFileRepository;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Server extends Staff implements InFileRepository.IdProvider{

    private String designation;

    public Server(){
        super("", "", "");
    }

    @Override
    public String getId() {
        return super.getId();
    }

    @Override
    public void setId(String Id) {
        super.setId(Id);
    }

    public Server(String Id, String name, String designation, String Rating) {
        super(Id,name, Rating);
        this.designation = designation;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }
}
