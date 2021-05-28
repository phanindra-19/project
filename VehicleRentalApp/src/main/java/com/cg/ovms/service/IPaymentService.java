package com.cg.ovms.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.http.ResponseEntity;

import com.cg.ovms.entities.Booking;
import com.cg.ovms.entities.Payment;
import com.cg.ovms.entities.Vehicle;

public interface IPaymentService {

	public Booking addPayment(Payment payment,Integer bid);
	public ResponseEntity<String> cancelPayment(Integer pid);
	public ResponseEntity<?> viewPaymentByBooking(Integer bid);
	public ResponseEntity<?> viewAllPaymentsByVehicle(Integer vid);
	public double calculateMonthlyRevenue(LocalDate d1,LocalDate d2);
	public double calculateTotalPayment(Integer v);
	
}
 