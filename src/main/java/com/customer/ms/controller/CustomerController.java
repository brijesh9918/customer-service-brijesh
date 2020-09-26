package com.customer.ms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.customer.ms.dao.CustomerDAO;
import com.customer.ms.model.Customer;

@RestController
public class CustomerController {

	@Autowired
	private CustomerDAO customerDAO;

	// URL - http://localhost:8080/hello
	@RequestMapping("/hello")
	public String hello() {
		return "Greetings from Spring Boot Application 1.0";
	}

	// URL - http://localhost:8080/customers
	@RequestMapping(value = "/customers", method = RequestMethod.GET, produces = { MediaType.APPLICATION_JSON_VALUE })
	public List<Customer> getCustomers() {
		List<Customer> list = customerDAO.getAllCustomers();
		return list;
	}

	// URL - http://localhost:8080/customer/{cusId}
	@RequestMapping(value = "/customer/{cusId}", method = RequestMethod.GET, produces = { MediaType.APPLICATION_JSON_VALUE })
	public Customer getCustomer(@PathVariable("cusId") String cusId) {
		return customerDAO.getCustomer(cusId);
	}

	// URL - POST http://localhost:8080/customer}
	@RequestMapping(value = "/customer", method = RequestMethod.POST, produces = { MediaType.APPLICATION_JSON_VALUE })
	public Customer addCustomer(@RequestBody Customer customer) {
		return customerDAO.addCustomer(customer);
	}

}