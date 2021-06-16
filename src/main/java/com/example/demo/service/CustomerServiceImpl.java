package com.example.demo.service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import org.springframework.stereotype.Service;
import com.example.demo.model.Customer;

@Service("customerService")
public class CustomerServiceImpl implements CustomerService {

  private Map<String, Customer> customers = new HashMap<>();

  @Override
  public String create(final Customer customer) throws Exception {
    if (this.customers.containsKey(customer.getEmail())) {
      throw new Exception(String.format("customer email (%s) already exists.", customer.getEmail()));
    }
    this.customers.put(customer.getEmail(), customer);
    return "hello";
  }

  @Override
  public Collection<Customer> listCustomers() {
    return this.customers.values();
  }

  @Override
  public Customer createCustomer(final Customer customer) throws Exception {
    if (this.customers.containsKey(customer.getEmail())) {
      throw new Exception(String.format("customer email (%s) already exists.", customer.getEmail()));
    }
    this.customers.put(customer.getEmail(), customer);
    return customer;
  }

}
