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

import com.cg.ovms.entities.Driver;
import com.cg.ovms.service.IDriverService;

@RestController
@RequestMapping("/driver")
@CrossOrigin
public class DriverController {
	@Autowired
	private IDriverService dservice;
	@PostMapping("/url")
	public Driver addDriver(@RequestBody Driver driver) {
		return dservice.addDriver(driver);
	}
	@DeleteMapping("/url/{did}")
	public ResponseEntity<String> cancelBooking(@PathVariable Integer did) {
		return dservice.cancelBooking(did);
	}
	@PutMapping("/url")
	public Driver updateDriver(@RequestBody Driver driver) {
		return dservice.updateDriver(driver);
	}
	@GetMapping("/url/{did}")
	public Driver viewDriver(@PathVariable Integer did) {
		return dservice.viewDriver(did);
	}

}
