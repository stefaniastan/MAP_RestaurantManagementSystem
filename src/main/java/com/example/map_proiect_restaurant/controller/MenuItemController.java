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

    // 🔍 Updated listMenuItems with filter and sort parameters
    @GetMapping({"", "/"})
    public String listMenuItems(
            @RequestParam(required = false) String name,
            @RequestParam(required = false) Double minPrice,
            @RequestParam(required = false) Double maxPrice,
            @RequestParam(defaultValue = "id") String sortBy,
            @RequestParam(defaultValue = "asc") String direction,
            Model model
    ) {
        model.addAttribute(
                "menuItems",
                menuItemService.filterAndSortMenuItems(name, minPrice, maxPrice, sortBy, direction)
        );

        // Add filter parameters back to the model for the view
        model.addAttribute("name", name);
        model.addAttribute("minPrice", minPrice);
        model.addAttribute("maxPrice", maxPrice);
        model.addAttribute("sortBy", sortBy);
        model.addAttribute("direction", direction);

        return "menuitem/index";
    }

    @GetMapping("/new")
    public String showCreateForm(Model model) {
        model.addAttribute("menuItem", new MenuItem());
        return "menuitem/form";
    }

    @PostMapping
    public String createMenuItem(@Valid @ModelAttribute("menuItem") MenuItem menuItem, BindingResult result) {
        if (result.hasErrors()) {
            return "menuitem/form";
        }
        menuItemService.addMenuItem(menuItem);
        return "redirect:/menuitems";
    }

    @GetMapping("/{id}/edit")
    public String showEditForm(@PathVariable Long id, Model model) {
        MenuItem item = menuItemService.getMenuItemById(id);
        model.addAttribute("menuItem", item);
        return "menuitem/form";
    }

    @PostMapping("/{id}")
    public String updateMenuItem(@PathVariable Long id, @Valid @ModelAttribute("menuItem") MenuItem menuItem, BindingResult result) {
        if (result.hasErrors()) {
            return "menuitem/form";
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