package com.webstore.domain;

/**
 * Created by yubraj on 7/19/16.
 */

public class Customer {
    private String customerId;
    private String fname;
    private String lname;
    private String email;
    private String address;
    private int noOfOrders;

    public Customer(){super();}

    public Customer(String customerId, String fname, String lname, String email, String address) {
        this.customerId = customerId;
        this.fname = fname;
        this.lname = lname;
        this.email = email;
        this.address = address;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Customer)) return false;

        Customer customer = (Customer) o;

        if (noOfOrders != customer.noOfOrders) return false;
        if (customerId != null ? !customerId.equals(customer.customerId) : customer.customerId != null) return false;
        if (fname != null ? !fname.equals(customer.fname) : customer.fname != null) return false;
        if (lname != null ? !lname.equals(customer.lname) : customer.lname != null) return false;
        if (email != null ? !email.equals(customer.email) : customer.email != null) return false;
        return address != null ? address.equals(customer.address) : customer.address == null;

    }

    @Override
    public int hashCode() {
        int result = customerId != null ? customerId.hashCode() : 0;
        result = 31 * result + (fname != null ? fname.hashCode() : 0);
        result = 31 * result + (lname != null ? lname.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (address != null ? address.hashCode() : 0);
        result = 31 * result + noOfOrders;
        return result;
    }

    //Getters and Setters

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getNoOfOrders() {
        return noOfOrders;
    }

    public void setNoOfOrders(int noOfOrders) {
        this.noOfOrders = noOfOrders;
    }
}
