package com.webstore.service;

import com.webstore.domain.Customer;

import java.util.List;

/**
 * Created by yubraj on 7/19/16.
 */
public interface CustomerService {
    List<Customer> getAllCustomers();
    Customer getCustomerById(String customerId);
}
