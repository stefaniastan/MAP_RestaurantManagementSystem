package com.example.map_proiect_restaurant.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public abstract class Staff {
    @JsonProperty("Id")
    private String Id;
    @JsonProperty("Name")
    private String Name;
    @JsonProperty("Rating")
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
