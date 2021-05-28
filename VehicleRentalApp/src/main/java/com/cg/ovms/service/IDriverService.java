package com.cg.ovms.service;

import org.springframework.http.ResponseEntity;

import com.cg.ovms.entities.Driver;

public interface IDriverService {

	public Driver addDriver(Driver driver);
	public ResponseEntity<String> cancelBooking(Integer did);
	public Driver updateDriver(Driver driver);
	public Driver viewDriver(Integer did);
}

