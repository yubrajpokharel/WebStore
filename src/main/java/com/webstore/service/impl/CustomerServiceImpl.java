package com.webstore.service.impl;

import com.webstore.domain.Customer;
import com.webstore.domain.repository.CustomerRepository;
import com.webstore.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by yubraj on 7/19/16.
 */

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    public List<Customer> getAllCustomers() {
        return customerRepository.getAllCustomers();
    }

    public Customer getCustomerById(String customerId) {
        return customerRepository.getCustomerById(customerId);
    }
}
