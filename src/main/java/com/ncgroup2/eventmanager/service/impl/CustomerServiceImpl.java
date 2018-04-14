package com.ncgroup2.eventmanager.service.impl;

import com.ncgroup2.eventmanager.dao.CustomerDAO;
import com.ncgroup2.eventmanager.model.Customer;
import com.ncgroup2.eventmanager.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    CustomerDAO customerDao;

    @Override
    public void insert(Customer customer) {
        customerDao.insertCustomer(customer);

    }

    @Override
    public Customer getCustomerById(int id) {
        return customerDao.getCustomer(id);

    }
}
