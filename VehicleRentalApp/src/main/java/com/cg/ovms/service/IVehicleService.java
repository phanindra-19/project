package com.cg.ovms.service;

import org.springframework.http.ResponseEntity;

import com.cg.ovms.entities.Vehicle;

public interface IVehicleService {
	public Vehicle addVehicle(Vehicle vehicle,Integer did);
	
	
	public ResponseEntity<String> cancelBooking(Integer vid);
	public Vehicle updateVehicle(Vehicle vehicle);
	public ResponseEntity<?> viewVehicle(Integer vid);


}
