package com.springxml.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.springxml.dao.CustomerDAO;
import com.springxml.models.Customer;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerDAO customerDAO;

    @Override
    @Transactional
    public void createCustomer(Customer customer) {
        customerDAO.save(customer);
    }

    @Override
    @Transactional(readOnly = true)
    public Customer getCustomerById(int id) {
        return customerDAO.findById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Customer> getAllCustomers() {
        return customerDAO.findAll();
    }

    @Override
    @Transactional
    public void updateCustomer(Customer customer) {
        customerDAO.update(customer);
    }

    @Override
    @Transactional
    public void deleteCustomer(int id) {
        customerDAO.deleteById(id);
    }
}
