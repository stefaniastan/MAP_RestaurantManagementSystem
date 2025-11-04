package com.example.map_proiect_restaurant.controller;

import com.example.map_proiect_restaurant.model.MenuItem;
import com.example.map_proiect_restaurant.service.MenuItemService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/menuItems")
public class MenuItemController {

    private final MenuItemService menuItemService;

    public MenuItemController(MenuItemService menuItemService) {
        this.menuItemService = menuItemService;
    }

    @GetMapping
    public String getAllMenuItems(Model model) {
        model.addAttribute("menuItems", menuItemService.findAllMenuItems());
        return "menuItem/menuItem-index";
    }

    @GetMapping("/new")
    public String createForm(Model model) {
        model.addAttribute("menuItem", new MenuItem("", "", 0.0));
        return "menuItem/menuItem-form";
    }

    @PostMapping
    public String createMenuItem(@ModelAttribute MenuItem menuItem) {
        menuItemService.addMenuItem(menuItem);
        return "redirect:/menuItems";
    }

    @PostMapping("/{id}/delete")
    public String deleteMenuItem(@PathVariable String id) {
        menuItemService.deleteMenuItem(id);
        return "redirect:/menuItems";
    }
}
