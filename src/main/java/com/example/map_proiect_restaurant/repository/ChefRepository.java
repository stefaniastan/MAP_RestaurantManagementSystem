package com.example.map_proiect_restaurant.repository;

import com.example.map_proiect_restaurant.model.Chef;
import org.springframework.stereotype.Repository;

@Repository
public class ChefRepository extends InFileRepository<Chef> {
    public ChefRepository() {
        super(Chef.class, "src/main/resources/data/chefs.json");
    }
}
