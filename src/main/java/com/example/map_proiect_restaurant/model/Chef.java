package com.example.map_proiect_restaurant.model;

public class Chef extends Staff{

    private String specialization;
    private Integer Age;

    public Chef(String Id, String Name, String specialization,  Integer Age){
        super(Id, Name);
        this.specialization = specialization;
        this.Age = Age;
    }

    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    public Integer getAge() {
        return Age;
    }
    public void setAge(Integer Age) {
        this.Age = Age;
    }
}
