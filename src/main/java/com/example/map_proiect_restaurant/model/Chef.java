package com.example.map_proiect_restaurant.model;

import com.example.map_proiect_restaurant.repository.InFileRepository;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Chef extends Staff implements InFileRepository.IdProvider {
    @JsonProperty("specialization")
    private String specialization;
    @JsonProperty("Age")
    private Integer Age;

    public Chef(){
        super("", "", "");
    }

    public Chef(String Id, String name, String Rating, String specialization,  Integer Age){
        super(Id, name, Rating);
        this.specialization = specialization;
        this.Age = Age;
    }

    @Override
    public String getId() {
        return super.getId();
    }
    @Override
    public void setId(String Id) {
        super.setId(Id);
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
