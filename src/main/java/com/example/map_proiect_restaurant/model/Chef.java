package com.example.map_proiect_restaurant.model;

public class Chef extends Staff{

    private String specialization;

    public Chef(String Id, String Name, String specialization){
        super(Id, Name);
        this.specialization = specialization;
    }

    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }
}
