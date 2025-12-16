package com.example.map_proiect_restaurant.repository;

import com.example.map_proiect_restaurant.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
    Optional<Customer> findByEmail(String email);
    List<Customer> findByNameContainingIgnoreCase(String name);

    List<Customer> findByEmailContainingIgnoreCase(String email);

    List<Customer> findByNameContainingIgnoreCaseAndEmailContainingIgnoreCase(
            String name,
            String email
    );

}