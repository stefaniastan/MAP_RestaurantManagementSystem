package com.example.map_proiect_restaurant.controller;

import com.example.map_proiect_restaurant.model.Server;
import com.example.map_proiect_restaurant.service.ServerService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/server")
public class ServerController {

    private final ServerService serverService;

    public ServerController(ServerService serverService) {
        this.serverService = serverService;
    }

    @GetMapping
    public String listServers(Model model) {
        List<Server> servers = serverService.getAllServers();
        model.addAttribute("servers", servers);
        return "server/index";
    }

    @GetMapping("/new")
    public String showCreateForm(Model model) {
        model.addAttribute("server", new Server());
        return "server/form";
    }

    @PostMapping
    public String createServer(@Valid @ModelAttribute("server") Server server, BindingResult result) {
        if (result.hasErrors()) {
            return "server/form";
        }
        serverService.addServer(server);
        return "redirect:/servers";
    }

    @GetMapping("/{id}/edit")
    public String showEditForm(@PathVariable Long id, Model model) {
        Server server = serverService.getServerById(id);
        model.addAttribute("server", server);
        return "servers/form";
    }

    @PostMapping("/{id}")
    public String updateServer(@PathVariable Long id, @Valid @ModelAttribute("server") Server server, BindingResult result) {
        if (result.hasErrors()) {
            return "servers/form";
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
