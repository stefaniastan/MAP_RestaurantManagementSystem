package com.example.map_proiect_restaurant.service;

import com.example.map_proiect_restaurant.model.Server;
import com.example.map_proiect_restaurant.repository.ServerRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServerService {

    private final ServerRepository serverRepository;

    public ServerService(ServerRepository serverRepository) {
        this.serverRepository = serverRepository;
    }

    public Server addServer(Server server) {
        return serverRepository.save(server);
    }

    public Server updateServer(Server server) {
        return serverRepository.save(server);
    }

    public List<Server> getAllServers() {
        return serverRepository.findAll();
    }

    public Server getServerById(Long id) {
        return serverRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Server not found"));
    }

    public void deleteServer(Long id) {
        serverRepository.deleteById(id);
    }

    public List<Server> getServersByDesignation(String designation) {
        return serverRepository.findByDesignation(designation);
    }
}