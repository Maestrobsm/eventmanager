package com.ncgroup2.eventmanager.service;

import com.ncgroup2.eventmanager.model.Customer;

import java.util.List;

public interface CustomerService {
    void insert(Customer customer);

    Customer getCustomerById(int id);

}
