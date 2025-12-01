package com.example.map_proiect_restaurant.controller;

import com.example.map_proiect_restaurant.model.Server;
import com.example.map_proiect_restaurant.service.ServerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/servers")
public class ServerController {

    private final ServerService serverService;

    @Autowired
    public ServerController(ServerService serverService) {
        this.serverService = serverService;
    }

    @GetMapping
    public List<Server> getAllServers() {
        return serverService.getAllServers();
    }

    @GetMapping("/{id}")
    public Server getServerById(@PathVariable Long id) {
        return serverService.getServerById(id);
    }

    @PostMapping
    public Server createServer(@RequestBody Server server) {
        return serverService.addServer(server);
    }

    @PutMapping("/{id}")
    public Server updateServer(@PathVariable Long id, @RequestBody Server server) {
        server.setId(id);
        return serverService.updateServer(server);
    }

    @DeleteMapping("/{id}")
    public String deleteServer(@PathVariable Long id) {
        serverService.deleteServer(id);
        return "Server deleted successfully";
    }

    @GetMapping("/designation/{designation}")
    public List<Server> getServersByDesignation(@PathVariable String designation) {
        return serverService.getServersByDesignation(designation);
    }
}
