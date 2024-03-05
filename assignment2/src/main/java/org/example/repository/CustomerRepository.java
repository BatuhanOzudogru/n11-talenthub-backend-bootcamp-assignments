package org.example.repository;

import org.example.entity.Customer;
import java.util.ArrayList;
import java.util.List;

public class CustomerRepository {
    private final List<Customer> customers;

    public CustomerRepository() {
        this.customers = new ArrayList<>();
    }

    public void save(Customer customer) {
        customers.add(customer);
    }

    public List<Customer> findAllCustomers() {
        return new ArrayList<>(customers);
    }
}