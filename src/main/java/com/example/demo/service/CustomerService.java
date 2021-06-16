package com.example.demo.service;

import java.util.Collection;
import com.example.demo.model.Customer;

public interface CustomerService {

  String create(Customer customer) throws Exception;

  Customer createCustomer(Customer customer) throws Exception;

  Collection<Customer> listCustomers();
}
