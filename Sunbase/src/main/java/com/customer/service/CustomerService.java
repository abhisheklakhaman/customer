package com.customer.service;

import java.util.List;

import com.customer.model.Customer;

public interface CustomerService {

	Customer saveCustomer(Customer customer);
	Customer updateCustomer(Customer customer);
	List<Customer> getAllCustomer();
	Customer getCustomerById(Long id);
	void deleteCustomer(Long id);
	
}

