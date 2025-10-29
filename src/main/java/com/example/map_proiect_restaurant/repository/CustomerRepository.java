package com.example.map_proiect_restaurant.repository;

import com.example.map_proiect_restaurant.model.Customer;
import com.example.map_proiect_restaurant.model.Order;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

@Repository
public class CustomerRepository implements AbstractRepository<Customer> {
    private final List<Customer> customers = new ArrayList<>(Arrays.asList(
            new Customer("Customer1", "Stefania", new ArrayList<Order>(), "Str.Avram Iancu", "stefania@email.com"),
            new Customer("Customer2", "Andrei", new ArrayList<Order>(), "Str.Balcescu", "andrei@email.com")
    ));

    @Override
    public Customer save(Customer customer) {
        customers.add(customer);
        return customer;
    }

    @Override
    public List<Customer> findAll() {
        return customers;
    }

    @Override
    public Customer findById(String id) {
        for(Customer customer : customers) {
            if(customer.getId().equals(id)) {
                return customer;
            }
        }
        return null;
    }

    @Override
    public void deleteById(String id) {
        for(Customer customer : customers) {
            if(customer.getId().equals(id)) {
                customers.remove(customer);
            }
        }
    }
}
