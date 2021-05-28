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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.ovms.entities.Booking;
import com.cg.ovms.entities.Payment;
import com.cg.ovms.entities.Vehicle;
import com.cg.ovms.service.IPaymentService;

@RestController
@RequestMapping("/payment")
@CrossOrigin
public class PaymentController {

	@Autowired
	private IPaymentService pservice;
	@PostMapping("/url/{bid}")
	public Booking addPayment(@RequestBody Payment payment,@PathVariable Integer bid) {
		return pservice.addPayment(payment,bid);
	}
	@DeleteMapping("/url/{pid}")
	public ResponseEntity<String> cancelPayment(@PathVariable Integer pid) {
		return pservice.cancelPayment(pid);
	}
	@GetMapping("/viewByBooking/{bid}")
	public ResponseEntity<?> viewPaymentByBooking(@PathVariable Integer bid) {
		return pservice.viewPaymentByBooking(bid);
	}
	@GetMapping("/viewByVehicle/{vid}")
	public ResponseEntity<?> viewAllPaymentsByVehicle(@PathVariable Integer vid) {
		return pservice.viewAllPaymentsByVehicle(vid);
	}
	@GetMapping("/calcMonthlyReven/{d1}/{d2}")
	public double calculateMonthlyRevenue(@PathVariable LocalDate d1, @PathVariable LocalDate d2) {
		return pservice.calculateMonthlyRevenue(d1, d2);
	}
	@GetMapping("/calcTotalPmntByVehicle/{v}")
	public double calculateTotalPayment(@PathVariable Integer v) {
		return pservice.calculateTotalPayment(v);
	}
	
	
	
	}
