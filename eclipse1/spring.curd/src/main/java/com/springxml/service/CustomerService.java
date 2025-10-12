package com.springxml.service;

import java.util.List;

import com.springxml.models.Customer;

public interface CustomerService {
    void createCustomer(Customer customer);
    Customer getCustomerById(int id);
    List<Customer> getAllCustomers();
    void updateCustomer(Customer customer);
    void deleteCustomer(int id);
}
