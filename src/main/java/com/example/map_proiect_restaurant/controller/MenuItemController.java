package com.example.map_proiect_restaurant.controller;

import com.example.map_proiect_restaurant.model.MenuItem;
import com.example.map_proiect_restaurant.service.MenuItemService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/menuitems")
public class MenuItemController {

    private final MenuItemService menuItemService;

    public MenuItemController(MenuItemService menuItemService) {
        this.menuItemService = menuItemService;
    }

    @GetMapping
    public String listMenuItems(Model model) {
        List<MenuItem> items = menuItemService.getAllMenuItems();
        model.addAttribute("menuItems", items);
        return "menuitems/index";
    }

    @GetMapping("/new")
    public String showCreateForm(Model model) {
        model.addAttribute("menuItem", new MenuItem());
        return "menuitems/form";
    }

    @PostMapping
    public String createMenuItem(@Valid @ModelAttribute("menuItem") MenuItem menuItem, BindingResult result) {
        if (result.hasErrors()) {
            return "menuitems/form";
        }
        menuItemService.addMenuItem(menuItem);
        return "redirect:/menuitems";
    }

    @GetMapping("/{id}/edit")
    public String showEditForm(@PathVariable Long id, Model model) {
        MenuItem item = menuItemService.getMenuItemById(id);
        model.addAttribute("menuItem", item);
        return "menuitems/form";
    }

    @PostMapping("/{id}")
    public String updateMenuItem(@PathVariable Long id, @Valid @ModelAttribute("menuItem") MenuItem menuItem, BindingResult result) {
        if (result.hasErrors()) {
            return "menuitems/form";
        }
        menuItem.setId(id);
        menuItemService.updateMenuItem(menuItem);
        return "redirect:/menuitems";
    }

    @PostMapping("/{id}/delete")
    public String deleteMenuItem(@PathVariable Long id) {
        menuItemService.deleteMenuItem(id);
        return "redirect:/menuitems";
    }
}
