package com.cg.ovms.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.http.ResponseEntity;

import com.cg.ovms.entities.Booking;
import com.cg.ovms.entities.Customer;
import com.cg.ovms.entities.Vehicle;

public interface IBookingService {

	public Booking addBooking(Booking booking,Integer cid,Integer vid);
	public ResponseEntity<String> cancelBooking(Integer bid);
	public Booking updateBooking(Booking b);
	public ResponseEntity<?> viewBooking(Integer bid);
	public ResponseEntity<?> viewAllBookingByCustomer(Integer cid);
	public List<Booking> viewAllBookingByDate(LocalDate bookingDate);
	public ResponseEntity<?> viewAllBookingByVehicle(Integer vid);

}
