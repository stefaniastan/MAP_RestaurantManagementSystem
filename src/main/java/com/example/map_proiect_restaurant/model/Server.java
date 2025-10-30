package com.example.map_proiect_restaurant.model;

public class Server extends Staff{

    private String designation;

    public Server(String Id, String Name, String designation, String Rating) {
        super(Id,Name, Rating);
        this.designation = designation;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }
}
