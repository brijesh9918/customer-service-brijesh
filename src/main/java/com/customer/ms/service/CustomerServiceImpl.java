package com.customer.ms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.customer.ms.dao.CustomerDAO;
import com.customer.ms.model.Customer;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerDAO customerDAO;

	@Override
	public List<Customer> findAll() {
		return customerDAO.getAllCustomers();
	}

	@Override
	public Customer findById(String cusId) {
		Customer cust = customerDAO.getCustomer(cusId);
		
		return cust;
	}

	@Override
	public Customer addCustomer(Customer customer) {
		return customerDAO.addCustomer(customer);
	}

	@Override
	public Customer updateCustomer(Customer customer) {
		return customerDAO.updateCustomer(customer);
	}

	@Override
	public String deleteCustomer(String cusId) {
		return customerDAO.deleteCustomer(cusId);
	}

}
