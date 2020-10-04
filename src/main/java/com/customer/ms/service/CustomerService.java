package com.customer.ms.service;

import java.util.List;

import com.customer.ms.model.Customer;

public interface CustomerService {

	List<Customer> findAll();

	Customer findById(String cusId);

	Customer addCustomer(Customer customer);
	
	Customer updateCustomer(Customer customer);
	
	String deleteCustomer(String cusId);


}
