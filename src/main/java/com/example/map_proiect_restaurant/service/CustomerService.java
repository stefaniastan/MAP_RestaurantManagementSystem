package com.example.map_proiect_restaurant.service;


import com.example.map_proiect_restaurant.model.Customer;
import com.example.map_proiect_restaurant.repository.CustomerRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {

    private final CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public Customer addCustomer(Customer customer){
        return customerRepository.save(customer);
    }

    public Customer updateCustomer(Customer customer){
        return customerRepository.save(customer);
    }

    public void deleteCustomer(String id){
        customerRepository.deleteById(id);
    }

    public Customer findCustomerById(String id){
        return customerRepository.findById(id);
    }

    public List<Customer> findAllCustomers(){
        return customerRepository.findAll();
    }
}
