package com.cg.ovms.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.cg.ovms.entities.Customer;

public interface ICustomerService {

	public Customer addCustomer(Customer customer);
	public ResponseEntity<String> removeCustomer(Integer cid);
	public ResponseEntity<?> viewCustomer(Integer cid);
	public Customer updateCustomer(Customer c);
	public List<Customer> viewAllCustomer(String vtype);
	public List<Customer> viewAllCustomersByLocation(String location);
	
}
