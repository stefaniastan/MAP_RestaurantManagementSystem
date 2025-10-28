package com.example.map_proiect_restaurant.model;

public abstract class Staff {
    private String Id;
    private String Name;
    private String Rating;

    public  Staff(String Id, String name, String Rating) {
        this.Id = Id;
        this.Name = name;
        this.Rating = Rating;
    }
    public String getId() {return this.Id;}
    public void setId(String Id) {this.Id = Id;}

    public String getName() {return this.Name;}
    public void setName(String name) { this.Name = Name;}

    public String getRating() {return this.Rating;}
    public void setRating(String Rating) {this.Rating = Rating;}
}
