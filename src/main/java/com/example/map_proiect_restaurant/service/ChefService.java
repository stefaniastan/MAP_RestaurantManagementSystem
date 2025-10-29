package com.example.map_proiect_restaurant.service;

import com.example.map_proiect_restaurant.model.Chef;
import com.example.map_proiect_restaurant.repository.ChefRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChefService {

    private final ChefRepository chefRepository;

    public ChefService(ChefRepository chefRepository) {
        this.chefRepository = chefRepository;
    }

    public Chef getChefById(String id){
        return chefRepository.findById(id);
    }

    public void deleteChef(String id)
    {
        chefRepository.deleteById(id);
    }

    public Chef addChef(Chef chef) {
        return chefRepository.save(chef);
    }

    public Chef updateChef(Chef chef) {
        return chefRepository.save(chef);
    }

    public List<Chef> getAllChefs() {
        return chefRepository.findAll();
    }
}
