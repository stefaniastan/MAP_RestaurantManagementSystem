package com.example.map_proiect_restaurant.repository;

import com.example.map_proiect_restaurant.model.Customer;
import org.springframework.stereotype.Repository;

@Repository
public class CustomerRepository extends InFileRepository<Customer> {

    public CustomerRepository() {
        // calea către fișierul JSON din proiect
        super(Customer.class, "src/main/resources/data/customers.json");
    }
}
