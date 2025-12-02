package com.example.map_proiect_restaurant;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;

import javax.sql.DataSource;
import java.sql.Connection;

@SpringBootApplication
public class MapProiectRestaurantApplication {

    public static void main(String[] args) {
        SpringApplication.run(MapProiectRestaurantApplication.class, args);
    }

    @Bean
    CommandLineRunner testConnection(DataSource dataSource) {
        return args -> {
            try (Connection connection = dataSource.getConnection()) {
                System.out.println("✅ DATABASE CONNECTION SUCCESSFUL!");
                System.out.println("Database: " + connection.getMetaData().getDatabaseProductName());
                System.out.println("Version: " + connection.getMetaData().getDatabaseProductVersion());
                System.out.println("URL: " + connection.getMetaData().getURL());
            } catch (Exception e) {
                System.err.println("❌ DATABASE CONNECTION FAILED!");
                System.err.println("Error: " + e.getMessage());
                e.printStackTrace();
            }
        };
    }
}