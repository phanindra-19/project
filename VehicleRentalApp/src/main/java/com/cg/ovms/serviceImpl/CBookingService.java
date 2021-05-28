package com.cg.ovms.serviceImpl;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
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
import com.cg.ovms.service.IBookingService;

@Service
public class CBookingService implements IBookingService{

	@Autowired
	private IBookingRepository brepo;
	@Autowired
	private ICustomerRepository crepo;
	@Autowired
	private IVehicleRepository vrepo;
	private Integer Integer;
	@Override
	public Booking addBooking(Booking booking,Integer cid,Integer vid) {
		Customer c1=crepo.findById(cid).orElseThrow(()->new ResourceNotFound("Customer with id"+cid+"not found"));
		booking.setCustomer(c1);
		//c1.setBooking(booking);
		Vehicle v1=vrepo.findById(vid).orElseThrow(()->new ResourceNotFound("Vehicle with id"+vid+"not found"));
		booking.setVehicle(v1);
		//v1.setBooking(booking);
		return brepo.save(booking);
		
	}
	@Transactional
	@Modifying
	@Override
	public ResponseEntity<String> cancelBooking(Integer bid) {
		Booking b1=brepo.findById(bid).orElseThrow(()->new ResourceNotFound("Booking with id"+bid+"not found"));
		brepo.delete(b1);
		//brepo.deleteById(bid);
		String response="Booking with id"+bid+"is deleted";
		return ResponseEntity.ok(response);
	}

	@Override
	public Booking updateBooking(Booking booking) {
		Booking b1=brepo.save(booking);
		return b1;
	}

	@Override
	public ResponseEntity<?> viewBooking(Integer bid) {
		ResponseEntity<?> resp=null;
		Optional<Booking> b1=brepo.findById(bid);
		if(b1.isPresent())
		{
			//Booking b2=b1.get();
			resp=new ResponseEntity<Booking>(b1.get(),HttpStatus.OK);
		}
		else
		{
			String s1="Booking with id"+bid+"not found";
			resp=new ResponseEntity<String>(s1,HttpStatus.OK);
		}
		return resp;
	}

	@Override
	public ResponseEntity<?> viewAllBookingByCustomer(Integer cid) {
			ResponseEntity<?> resp=null;
			Optional<Customer> c1=crepo.findById(cid);
			if(c1.isPresent()) {
				List<Booking> b1=brepo.findByCustomer(c1.get());
				if(!(b1.isEmpty())) {
					resp=new ResponseEntity<List<Booking>>(b1,HttpStatus.OK);
				}
				else {
					String s1="Booking with cid"+cid+"not found";
					resp=new ResponseEntity<String>(s1,HttpStatus.OK);
				}
			}
			else
			{
				String s1="Customer with cid"+cid+"not found";
				resp=new ResponseEntity<String>(s1,HttpStatus.OK);
			}
			return resp;		
	}

	@Override
	public List<Booking> viewAllBookingByDate(LocalDate bookingDate) {
		List<Booking> b1=new ArrayList<>();
		b1=brepo.findByBookingDate(bookingDate);
		return b1;
	}
	@Override
	public ResponseEntity<?> viewAllBookingByVehicle(Integer vid) {
		ResponseEntity<?> resp=null;
		Optional<Vehicle> v1=vrepo.findById(vid);
		if(v1.isPresent()) {
			Optional<Booking> b1=brepo.findByVehicle(v1.get());
			if(b1.isPresent()) {
				resp=new ResponseEntity<Booking>(b1.get(),HttpStatus.OK);
			}
			else {
				String s1="Booking with vid"+vid+"not found";
				resp=new ResponseEntity<String>(s1,HttpStatus.OK);
			}
		}
		else
		{
			String s1="Vehicle with vid"+vid+"not found";
			resp=new ResponseEntity<String>(s1,HttpStatus.OK);
		}
		return resp;		
}


}
