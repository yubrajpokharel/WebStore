package com.webstore.domain.repository.impl;

import com.webstore.domain.Customer;
import com.webstore.domain.repository.CustomerRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yubraj on 7/19/16.
 */

@Repository
public class InMemoryCustomerRepository implements CustomerRepository {

    List<Customer> customers = new ArrayList<Customer>();

    public List<Customer> getAllCustomers() {
        return customers;
    }

    public Customer getCustomerById(String customerId) {
        Customer customerById = null;

        for(Customer customer: customers){
            if(customer != null && customer.getCustomerId() != null && customer.getCustomerId().equals(customerId)){
                customerById = customer;
                break;
            }
        }

        if(customerById == null)
            throw new IllegalArgumentException("Customer not found with Customer ID :"+customerId);

        return customerById;
    }

    public InMemoryCustomerRepository(){
        Customer customer1 = new Customer("CS100", "Yubraj", "Pokharel", "yubraj@gmai.com", "1000 N 4th Street");
        Customer customer2 = new Customer("CS101", "Sudhan", "Pokharel", "sudhan@gmai.com", "2000 N 4th Street");
        Customer customer3 = new Customer("CS102", "Umesh", "Pokharel", "umesh@gmai.com", "3000 N 4th Street");
        Customer customer4 = new Customer("CS103", "Bijay", "Pokharel", "bijay@gmai.com", "4000 N 4th Street");

        customers.add(customer1);
        customers.add(customer2);
        customers.add(customer3);
        customers.add(customer4);
    }

}
