package com.example.map_proiect_restaurant.controller;

import com.example.map_proiect_restaurant.model.Chef;
import com.example.map_proiect_restaurant.service.ChefService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/chefs")
public class ChefController {

    private final ChefService chefService;

    public ChefController(ChefService chefService) {
        this.chefService = chefService;
    }

    @GetMapping
    public String getAllChefs(Model model) {
        model.addAttribute("chefs", chefService.getAllChefs());
        return "chef/chef-index";
    }

    @GetMapping("/new")
    public String createForm(Model model) {
        model.addAttribute("chef", new Chef("", "", "", "", 0));
        return "chef/chef-form";
    }

    @PostMapping
    public String createChef(@ModelAttribute Chef chef) {
        chefService.addChef(chef);
        return "redirect:/chefs";
    }

    @PostMapping("/{id}/delete")
    public String deleteChef(@PathVariable String id) {
        chefService.deleteChef(id);
        return "redirect:/chefs";
    }
}
