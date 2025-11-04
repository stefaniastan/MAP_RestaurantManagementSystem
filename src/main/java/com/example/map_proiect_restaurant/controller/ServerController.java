package com.example.map_proiect_restaurant.controller;

import com.example.map_proiect_restaurant.model.Server;
import com.example.map_proiect_restaurant.service.ServerService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/servers")
public class ServerController {

    private final ServerService serverService;

    public ServerController(ServerService serverService) {
        this.serverService = serverService;
    }

    @GetMapping
    public String getAllServers(Model model) {
        model.addAttribute("servers", serverService.getAllServers());
        return "server/index";
    }

    @GetMapping("/new")
    public String createForm(Model model) {
        model.addAttribute("server", new Server("", "", "", ""));
        return "server/form";
    }

    @PostMapping
    public String createServer(@ModelAttribute Server server) {
        serverService.addServer(server);
        return "redirect:/servers";
    }

    @PostMapping("/{id}/delete")
    public String deleteServer(@PathVariable String id) {
        serverService.deleteServer(id);
        return "redirect:/servers";
    }
}
