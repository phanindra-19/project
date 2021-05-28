package com.cg.ovms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.ovms.entities.Customer;
import com.cg.ovms.service.ICustomerService;

@RestController
@RequestMapping("/customer")
@CrossOrigin
public class CustomerController {

	@Autowired
	private ICustomerService cservice;
	@PostMapping("/url")
	public Customer addCustomer(@RequestBody Customer customer) {
		return cservice.addCustomer(customer);
	}
	@DeleteMapping("/url/{cid}")
	public ResponseEntity<String> removeCustomer(@PathVariable Integer cid) {
		return cservice.removeCustomer(cid);
	}
	@GetMapping("/url/{cid}")
	public ResponseEntity<?> viewCustomer(@PathVariable Integer cid) {
		return cservice.viewCustomer(cid);
	}
	@PutMapping("/url")
	public Customer updateCustomer(@RequestBody Customer c) {
		return cservice.updateCustomer(c);
	}
	@GetMapping("/viewAllByType/{type}")
	public List<Customer> viewAllCustomer(@PathVariable String vtype) {
		return cservice.viewAllCustomer(vtype);
	}
	@GetMapping("/viewAllByLocation/{location}")
	public List<Customer> viewAllCustomersByLocation(@PathVariable String location) {
		return cservice.viewAllCustomersByLocation(location);
	}
		
}
