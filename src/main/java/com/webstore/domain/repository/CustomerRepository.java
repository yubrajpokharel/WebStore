package com.webstore.domain.repository;

import com.webstore.domain.Customer;

import java.util.List;

/**
 * Created by yubraj on 7/19/16.
 */
public interface CustomerRepository {
    List<Customer> getAllCustomers();
    Customer getCustomerById(String customerId);
}
