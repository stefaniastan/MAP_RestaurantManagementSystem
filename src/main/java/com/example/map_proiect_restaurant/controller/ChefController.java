package com.example.map_proiect_restaurant.controller;

import com.example.map_proiect_restaurant.model.Chef;
import com.example.map_proiect_restaurant.service.ChefService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/chefs")
public class ChefController {

    private final ChefService chefService;

    @Autowired
    public ChefController(ChefService chefService) {
        this.chefService = chefService;
    }

    @GetMapping
    public List<Chef> getAllChefs() {
        return chefService.getAllChefs();
    }

    @GetMapping("/{id}")
    public Chef getChefById(@PathVariable Long id) {
        return chefService.getChefById(id);
    }

    @PostMapping
    public Chef createChef(@RequestBody Chef chef) {
        return chefService.addChef(chef);
    }

    @PutMapping("/{id}")
    public Chef updateChef(@PathVariable Long id, @RequestBody Chef chef) {
        chef.setId(id);
        return chefService.updateChef(chef);
    }

    @DeleteMapping("/{id}")
    public String deleteChef(@PathVariable Long id) {
        chefService.deleteChef(id);
        return "Chef deleted successfully";
    }

    @GetMapping("/specialization/{specialization}")
    public List<Chef> getChefsBySpecialization(@PathVariable String specialization) {
        return chefService.getChefsBySpecialization(specialization);
    }
}
