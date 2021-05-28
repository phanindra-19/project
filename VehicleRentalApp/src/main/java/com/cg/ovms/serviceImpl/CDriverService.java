package com.cg.ovms.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.cg.ovms.entities.Driver;
import com.cg.ovms.exception.ResourceNotFound;
import com.cg.ovms.repository.IDriverRepository;
import com.cg.ovms.service.IDriverService;

@Service
public class CDriverService implements IDriverService{

	@Autowired
	private IDriverRepository drepo;
	@Override
	public Driver addDriver(Driver driver) {
		Driver d1=drepo.save(driver);
		return d1;
	}
	@Override
	public ResponseEntity<String> cancelBooking(Integer did) {
		// TODO Auto-generated method stub
		Driver d1=drepo.findById(did).orElseThrow(()->new ResourceNotFound("Booking with id"+did+"not found"));
		drepo.delete(d1);
		String response="Booking with id"+did+"is deleted";
		return ResponseEntity.ok(response);
	}
	@Override
	public Driver updateDriver(Driver driver) {
		// TODO Auto-generated method stub
		Driver d1=drepo.save(driver);
		return d1;

	}
	@Override
	public Driver viewDriver(Integer did) {
		// TODO Auto-generated method stub
		Driver d1=drepo.findById(did)
				.orElseThrow(()->new ResourceNotFound("Booking with id"+did+"not found"));
		return d1;
	}
}
