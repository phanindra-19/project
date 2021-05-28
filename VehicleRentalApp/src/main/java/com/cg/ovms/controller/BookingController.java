package com.cg.ovms.controller;

import java.time.LocalDate;
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

import com.cg.ovms.entities.Booking;
import com.cg.ovms.entities.Customer;
import com.cg.ovms.entities.Vehicle;
import com.cg.ovms.service.IBookingService;

@RestController
@RequestMapping("/booking")
@CrossOrigin
public class BookingController {

	@Autowired
	private IBookingService bservice;
	@PostMapping("/url/{cid}/{vid}")
	public Booking addBooking(@RequestBody Booking booking,@PathVariable Integer cid,@PathVariable Integer vid) {
		return bservice.addBooking(booking,cid,vid);
	}
	@DeleteMapping("/url/{bid}")
	public ResponseEntity<String> cancelBooking(@PathVariable Integer bid) {
		return bservice.cancelBooking(bid);
	}
	@PutMapping("/url")
	public Booking updateBooking(@RequestBody Booking b) {
		return bservice.updateBooking(b);
	}
	@GetMapping("/url/{bid}")
	public ResponseEntity<?> viewBooking(@PathVariable Integer bid) {
		return bservice.viewBooking(bid);
	}
	@GetMapping("/viewAllByCustomer/{cid}")
	public ResponseEntity<?> viewAllBookingByCustomer(@PathVariable Integer cid) {
		return bservice.viewAllBookingByCustomer(cid);
	}
	@GetMapping("/viewAllByDate/{date}")
	public List<Booking> viewAllBookingByDate(@PathVariable LocalDate bookingDate) {
		return bservice.viewAllBookingByDate(bookingDate);
	}
	@GetMapping("/viewAllByVehicle/{vid}")
	public ResponseEntity<?> viewAllBookingByVehicle(@PathVariable Integer vid) {
		return bservice.viewAllBookingByVehicle(vid);
	}
	
		
}

