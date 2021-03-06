package com.customer.ms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.customer.ms.model.Customer;
import com.customer.ms.model.CustomerM;
import com.customer.ms.service.CustomerService;

@RestController
public class CustomerController {

	@Value("${msg:Hello Brijesh...}")
	private String msg;

	@Autowired
	private CustomerService customerService;

	@GetMapping("/msg")
	public String getMsg() {
		return this.msg;
	}

	// URL - http://localhost:8081/hello
	@RequestMapping("/hello")
	public String hello() {
		return "Greetings from Spring Boot Application 1.0";
	}

	// URL - http://localhost:8081/customers
	@RequestMapping(value = "/customers", method = RequestMethod.GET, produces = { MediaType.APPLICATION_JSON_VALUE })
	public List<Customer> getCustomers() {
		List<Customer> list = customerService.findAll();
		return list;
	}

	// URL - http://localhost:8081/customer/{cusId}
	@RequestMapping(value = "/customer/{cusId}", method = RequestMethod.GET, produces = {
			MediaType.APPLICATION_JSON_VALUE })
	public Customer getCustomer(@PathVariable("cusId") String cusId) {
		return customerService.findById(cusId);
	}

	// URL - POST http://localhost:8081/customer}
	@RequestMapping(value = "/customer", method = RequestMethod.POST, produces = { MediaType.APPLICATION_JSON_VALUE })
	public Customer addCustomer(@RequestBody Customer customer) {
		return customerService.addCustomer(customer);
	}

	@RequestMapping(value = "/updatecustomer", method = RequestMethod.POST, produces = {
			MediaType.APPLICATION_JSON_VALUE })
	public Customer updateCustomer(@RequestBody Customer customer) {
		return customerService.updateCustomer(customer);
	}

	@RequestMapping(value = "/customer/delete/{cusId}", method = RequestMethod.DELETE, produces = {
			MediaType.APPLICATION_JSON_VALUE })
	public String getDeleteCustomer(@PathVariable("cusId") String cusId) {
		return customerService.deleteCustomer(cusId);
	}

	// URL - http://localhost:8081/mongoCustomers
	@RequestMapping(value = "/mongoCustomers", //
			method = RequestMethod.GET, //
			produces = { MediaType.APPLICATION_JSON_VALUE })
	public List<CustomerM> getMongoCustomers() {
		List<CustomerM> list = customerService.findAllFromDatabase();
		return list;
	}

	// URL - http://localhost:8081/mongoCustomer/{cusId}
	@RequestMapping(value = "/mongoCustomer/{cusId}", //
			method = RequestMethod.GET, //
			produces = { MediaType.APPLICATION_JSON_VALUE })
	public CustomerM getMongoCustomer(@PathVariable("cusId") String cusId) {
		return customerService.findByIdFromDatabase(cusId);
	}

	// URL - POST http://localhost:8081/mongoCustomer}
	@RequestMapping(value = "/mongoCustomer", method = RequestMethod.POST, produces = {
			MediaType.APPLICATION_JSON_VALUE })
	public CustomerM addMongoCustomer(@RequestBody CustomerM customerM) {
		return customerService.saveCustomer(customerM);
	}

	@RequestMapping(value = "/mongoCustomer/delete/{cusId}", method = RequestMethod.DELETE, produces = {
			MediaType.APPLICATION_JSON_VALUE })
	public String getDeleteDbCustomer(@PathVariable("cusId") String cusId) {
		return customerService.deleteDbCustomer(cusId);
	}

	@RequestMapping(value = "/mongoCustomer/update", method = RequestMethod.POST, produces = {
			MediaType.APPLICATION_JSON_VALUE })
	public CustomerM updateMongoCustomer(@RequestBody CustomerM customerM) {
		return customerService.updateDbCustomer(customerM);
	}

}