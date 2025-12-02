package com.example.map_proiect_restaurant.controller;

import com.example.map_proiect_restaurant.model.Chef;
import com.example.map_proiect_restaurant.service.ChefService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/chefs")
public class ChefController {

    private final ChefService chefService;

    public ChefController(ChefService chefService) {
        this.chefService = chefService;
    }

    @GetMapping
    public String listChefs(Model model) {
        List<Chef> chefs = chefService.getAllChefs();
        model.addAttribute("chefs", chefs);
        return "chefs/index";
    }

    @GetMapping("/new")
    public String showCreateForm(Model model) {
        model.addAttribute("chef", new Chef());
        return "chefs/form";
    }

    @PostMapping
    public String createChef(@Valid @ModelAttribute("chef") Chef chef, BindingResult result) {
        if (result.hasErrors()) {
            return "chefs/form";
        }
        chefService.addChef(chef);
        return "redirect:/chefs";
    }

    @GetMapping("/{id}/edit")
    public String showEditForm(@PathVariable Long id, Model model) {
        Chef chef = chefService.getChefById(id);
        model.addAttribute("chef", chef);
        return "chefs/form";
    }

    @PostMapping("/{id}")
    public String updateChef(@PathVariable Long id, @Valid @ModelAttribute("chef") Chef chef, BindingResult result) {
        if (result.hasErrors()) {
            return "chefs/form";
        }
        chef.setId(id);
        chefService.updateChef(chef);
        return "redirect:/chefs";
    }

    @PostMapping("/{id}/delete")
    public String deleteChef(@PathVariable Long id) {
        chefService.deleteChef(id);
        return "redirect:/chefs";
    }
}
