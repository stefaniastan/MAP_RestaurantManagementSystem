package com.example.map_proiect_restaurant.model;

public abstract class Staff {
    private String Id;
    private String Name;

    public  Staff(String id, String name) {
        this.Id = this.Id;
        this.Name = this.Name;
    }
    public String getId() {return this.Id;}
    public void setId(String id) {this.Id = id;}

    public String getName() {return this.Name;}
    public void setName(String name) { this.Name = name;}
}
