package com.example.map_proiect_restaurant.repository;

import com.example.map_proiect_restaurant.model.Server;
import org.springframework.stereotype.Repository;

@Repository
public class ServerRepository extends InFileRepository<Server> {
    public ServerRepository() {
        super(Server.class, "src/main/resources/data/servers.json");
    }
}
