package com.ncgroup2.eventmanager.dao;

import com.ncgroup2.eventmanager.model.Customer;

public interface CustomerDAO {

    void insertCustomer(Customer customer);

    Customer getCustomer(int id);

}
