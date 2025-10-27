package com.example.map_proiect_restaurant.repository;

import com.example.map_proiect_restaurant.model.Server;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Repository
public class ServerRepository implements AbstractRepository<Server>{
    private final List<Server> servers = new ArrayList<>(Arrays.asList(
            new Server("Server1", "Ana", "Hall1"),
            new Server("Server2", "Alex", "Hall2")
    ));

    @Override
    public Server save(Server server) {
        servers.add(server);
        return server;
    }

    @Override
    public List<Server> findAll() {
        return servers;
    }

    @Override
    public Server findById(Integer id) {
        for (Server server : servers) {
            if (server.getId().equals(id)) {
                return server;
            }
        }
        return null;
    }

    @Override
    public void deleteById(Integer id) {
        for (Server server : servers) {
            if (server.getId().equals(id)) {
                servers.remove(server);
            }
        }
    }
}
