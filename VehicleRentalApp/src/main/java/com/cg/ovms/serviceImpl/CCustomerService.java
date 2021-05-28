package com.cg.ovms.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.cg.ovms.entities.Booking;
import com.cg.ovms.entities.Customer;
import com.cg.ovms.entities.Vehicle;
import com.cg.ovms.exception.ResourceNotFound;
import com.cg.ovms.repository.IBookingRepository;
import com.cg.ovms.repository.ICustomerRepository;
import com.cg.ovms.repository.IVehicleRepository;
import com.cg.ovms.service.ICustomerService;

@Service
public class CCustomerService implements ICustomerService{

	@Autowired
	private ICustomerRepository crepo;
	@Autowired
	private IVehicleRepository vrepo;
	@Autowired
	private IBookingRepository brepo;
	
	@Override
	public Customer addCustomer(Customer customer) {
		Customer c1=crepo.save(customer);
		return c1;
	}

	@Override
	public ResponseEntity<String> removeCustomer(Integer cid) {
		Customer c1=crepo.findById(cid).orElseThrow(()->new ResourceNotFound("customer with id"+cid+"not found"));
		crepo.delete(c1);
		String response="Customer with id"+cid+"is deleted";
		return ResponseEntity.ok(response);

	}

	@Override
	public ResponseEntity<?> viewCustomer(Integer cid) {
		ResponseEntity<?> resp=null;
		Optional<Customer> c1=crepo.findById(cid);
		if(c1.isPresent())
		{
			resp=new ResponseEntity<Customer>(c1.get(),HttpStatus.OK);
		}
		else
		{
			String s1="Customer with id"+cid+"not found";
			resp=new ResponseEntity<String>(s1,HttpStatus.OK);
		}
		return resp;
	}

	@Override
	public Customer updateCustomer(Customer c) {
		Customer c1=crepo.save(c);
		return c1;
	}

	@Override
	public List<Customer> viewAllCustomer(String vtype) {
		/*List<Vehicle>v1=vrepo.findByType(vtype);
		Optional<Booking> b1 =brepo.findByVehicle(v1);
		*/
		return null;
	}

	@Override
	public List<Customer> viewAllCustomersByLocation(String location) {
	/*	List<Vehicle> v1=vrepo.findByLocation(location);
		Optional<Booking> b1=brepo.findByVehicle(v1);
		*/
		return null;
	}
	


}
