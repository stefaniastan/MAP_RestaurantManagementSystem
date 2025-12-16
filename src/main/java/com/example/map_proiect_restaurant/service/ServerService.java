package com.example.map_proiect_restaurant.service;

import com.example.map_proiect_restaurant.model.Server;
import com.example.map_proiect_restaurant.repository.ServerRepository;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServerService {

    private final ServerRepository serverRepository;

    public ServerService(ServerRepository serverRepository) {
        this.serverRepository = serverRepository;
    }

    // 🔍 FILTER + SORT
    public List<Server> filterAndSortServers(
            String designation,
            Integer age,
            String rating,
            String sortBy,
            String direction
    ) {
        Sort sort = Sort.by(
                direction.equalsIgnoreCase("desc") ? Sort.Direction.DESC : Sort.Direction.ASC,
                sortBy
        );

        if (designation != null && !designation.isEmpty()) {
            return serverRepository.findByDesignation(designation);
        }

        if (age != null) {
            return serverRepository.findByAge(age);
        }

        if (rating != null && !rating.isEmpty()) {
            return serverRepository.findByRating(rating);
        }

        // default → toate cu sortare
        return serverRepository.findAll(sort);
    }

    public Server addServer(Server server) {
        if (server.getAge() == null || server.getAge() < 18) {
            throw new IllegalStateException("Server must be at least 18 years old.");
        }
        return serverRepository.save(server);
    }

    public Server updateServer(Server server) {
        if (server.getAge() == null || server.getAge() < 18) {
            throw new IllegalStateException("Server must be at least 18 years old.");
        }
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
//