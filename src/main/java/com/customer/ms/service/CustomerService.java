package com.customer.ms.service;

import java.util.List;

import com.customer.ms.model.Customer;
import com.customer.ms.model.CustomerM;

public interface CustomerService {

	List<Customer> findAll();

	Customer findById(String cusId);

	Customer addCustomer(Customer customer);
	
	Customer updateCustomer(Customer customer);
	
	String deleteCustomer(String cusId);
	
	CustomerM saveCustomer(CustomerM customerM);
	
	List<CustomerM> findAllFromDatabase();
	
	CustomerM findByIdFromDatabase(String cusId);
	
	String deleteDbCustomer(String cusId);
	
	CustomerM updateDbCustomer(CustomerM customerM);


}
