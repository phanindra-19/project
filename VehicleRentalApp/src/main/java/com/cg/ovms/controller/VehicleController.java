package com.cg.ovms.controller;

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

import com.cg.ovms.entities.Vehicle;
import com.cg.ovms.service.IVehicleService;

@RestController
@RequestMapping("/vehicle")
@CrossOrigin
public class VehicleController {
	@Autowired
	private IVehicleService vservice;
	@PostMapping("/url/{did}")
	public Vehicle addVehicle(@RequestBody Vehicle vehicle,@PathVariable Integer did) {
		return vservice.addVehicle(vehicle,did);
	}
	
	
	@DeleteMapping("/url/{vid}")
	public ResponseEntity<String> cancelBooking(@PathVariable Integer vid) {
	return vservice.cancelBooking(vid);
	}
	@PutMapping("/url")
	public Vehicle updateVehicle(@RequestBody Vehicle v) {
	return vservice.updateVehicle(v);
	}
	@GetMapping("/url/{vid}")
	public ResponseEntity<?> viewVehicle(@PathVariable Integer vid) {
	return vservice.viewVehicle(vid);
	}
	
	
}
