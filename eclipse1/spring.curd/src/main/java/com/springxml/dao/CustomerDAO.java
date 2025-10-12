package com.springxml.dao;

import java.util.List;

import com.springxml.models.Customer;

public interface CustomerDAO {
    void save(Customer customer);
    Customer findById(int id);
    List<Customer> findAll();
    void update(Customer customer);
    void deleteById(int id);
}
