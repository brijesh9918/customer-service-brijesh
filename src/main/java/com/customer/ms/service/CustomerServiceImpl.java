package com.customer.ms.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.customer.ms.dao.CustomerDAO;
import com.customer.ms.model.Customer;
import com.customer.ms.model.CustomerM;
import com.customer.ms.repository.CustomerRepository;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerDAO customerDAO;
	
	@Autowired
	private CustomerRepository customerRepository;

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
	
	

	@Override
	public List<CustomerM> findAllFromDatabase() {
		return customerRepository.findAll();
	}

	@Override
	public CustomerM findByIdFromDatabase(String cusId) {
		Optional<CustomerM> opt = customerRepository.findById(cusId);
		if (opt.isPresent()) {
			return opt.get();
		}
		return null;
	}

	@Override
	public CustomerM saveCustomer(CustomerM customerM) {
		return customerRepository.save(customerM);
	}
	
	@Override
	public String deleteDbCustomer(String cusId) {
		 customerRepository.deleteById(cusId);
		 return "Customer deleted successfully.";
	}
	
	@Override
	public CustomerM updateDbCustomer(CustomerM customerM) {
		
		Optional<CustomerM> customer = customerRepository.findById(customerM.getCusId());
		if(customer.isPresent()) {
			CustomerM cust =customer.get();
			cust.setCusName(customerM.getCusName());
			cust.setAddress(customerM.getAddress());
			customerRepository.save(cust);
			return customerM;
		}		
		return null;
	}

}
