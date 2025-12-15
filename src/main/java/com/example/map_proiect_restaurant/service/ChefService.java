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

    public Chef addChef(Chef chef) {
        if (chef.getAge() == null || chef.getAge() < 18) {
            throw new IllegalStateException("Chef must be at least 18 years old.");
        }
        return chefRepository.save(chef);
    }

    public Chef updateChef(Chef chef) {
        if (chef.getAge() == null || chef.getAge() < 18) {
            throw new IllegalStateException("Chef must be at least 18 years old.");
        }
        return chefRepository.save(chef);
    }

    public List<Chef> getAllChefs() {
        return chefRepository.findAll();
    }

    public Chef getChefById(Long id) {
        return chefRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Chef not found"));
    }

    public void deleteChef(Long id) {
        chefRepository.deleteById(id);
    }

    public List<Chef> getChefsBySpecialization(String specialization) {
        return chefRepository.findBySpecialization(specialization);
    }
}