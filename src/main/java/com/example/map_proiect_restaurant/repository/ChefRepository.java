package com.example.map_proiect_restaurant.repository;

import com.example.map_proiect_restaurant.model.Chef;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Repository
public class ChefRepository implements AbstractRepository<Chef> {
    private final List<Chef> chefs = new ArrayList<>(Arrays.asList(
            new Chef("Chef1", "Albert", "desserts", 23),
            new Chef("Chef2", "Marian", "fine dining", 44)
    ));

    @Override
    public Chef save(Chef chef) {
        chefs.add(chef);
        return chef;
    }

    @Override
    public List<Chef> findAll() {
        return chefs;
    }

    @Override
    public Chef findById(Integer id) {
        for (Chef chef : chefs) {
            if (chef.getId().equals(id)) {
                return chef;
            }
        }
        return null;
    }

    @Override
    public void deleteById(Integer id) {
        for (Chef chef : chefs) {
            if (chef.getId().equals(id)) {
                chefs.remove(chef);
            }
        }
    }
}
