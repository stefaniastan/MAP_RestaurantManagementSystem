package com.example.map_proiect_restaurant.controller;

import com.example.map_proiect_restaurant.model.Server;
import com.example.map_proiect_restaurant.service.ServerService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/servers")
public class ServerController {

    private final ServerService serverService;

    public ServerController(ServerService serverService) {
        this.serverService = serverService;
    }

    @GetMapping
    public String listServers(Model model) {
        model.addAttribute("servers", serverService.getAllServers());
        return "server/index";
    }

    @GetMapping("/new")
    public String showCreateForm(Model model) {
        model.addAttribute("server", new Server());
        return "server/form";
    }

    @PostMapping
    public String createServer(@Valid @ModelAttribute("server") Server server,
                               BindingResult result) {
        if (result.hasErrors()) {
            return "server/form";
        }

        try {
            serverService.addServer(server);
        } catch (IllegalStateException e) {
            result.rejectValue("name", "duplicate", e.getMessage());
            return "server/form";
        }

        return "redirect:/servers";
    }

    @GetMapping("/{id}/edit")
    public String showEditForm(@PathVariable Long id, Model model) {
        model.addAttribute("server", serverService.getServerById(id));
        return "server/form";
    }

    @PostMapping("/{id}")
    public String updateServer(@PathVariable Long id,
                               @Valid @ModelAttribute("server") Server server,
                               BindingResult result) {
        if (result.hasErrors()) {
            return "server/form";
        }
        server.setId(id);
        serverService.updateServer(server);
        return "redirect:/servers";
    }

    @PostMapping("/{id}/delete")
    public String deleteServer(@PathVariable Long id) {
        serverService.deleteServer(id);
        return "redirect:/servers";
    }
}