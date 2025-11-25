package com.example.map_proiect_restaurant.service;

import com.example.map_proiect_restaurant.model.Customer;
import com.example.map_proiect_restaurant.model.Order;
import com.example.map_proiect_restaurant.repository.CustomerRepository;
import com.example.map_proiect_restaurant.repository.OrderRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CustomerService {

    private final CustomerRepository customerRepository;
    private final OrderRepository orderRepository;

    public CustomerService(CustomerRepository customerRepository,
                           OrderRepository orderRepository) {
        this.customerRepository = customerRepository;
        this.orderRepository = orderRepository;
    }

    //attach all related orders to the customer
    private void attachOrders(Customer customer) {
        if (customer == null) return;

        List<Order> allOrders = orderRepository.findAll();

        List<Order> customerOrders = allOrders.stream()
                .filter(o -> o.getCustomerId() != null && o.getCustomerId().equals(customer.getId()))
                .collect(Collectors.toList());

        customer.setOrders(customerOrders);
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

    public Customer getCustomerById(String id){
        Customer customer = customerRepository.findById(id);
        attachOrders(customer);
        return customer;
    }

    public List<Customer> getAllCustomers(){
        List<Customer> customers = customerRepository.findAll();
        customers.forEach(this::attachOrders);
        return customers;
    }
}
