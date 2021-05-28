package com.cg.ovms.serviceImpl;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.cg.ovms.entities.Booking;
import com.cg.ovms.entities.Customer;
import com.cg.ovms.entities.Payment;
import com.cg.ovms.entities.Vehicle;
import com.cg.ovms.exception.ResourceNotFound;
import com.cg.ovms.repository.IBookingRepository;
import com.cg.ovms.repository.IPaymentRepository;
import com.cg.ovms.repository.IVehicleRepository;
import com.cg.ovms.service.IPaymentService;

@Service
public class CPaymentService implements IPaymentService{

	@Autowired
	private IPaymentRepository prepo;
	@Autowired
	private IBookingRepository brepo;
	@Autowired
	private IVehicleRepository vrepo;
	@Override
	public Booking addPayment(Payment payment,Integer bid) {
		Booking b1=brepo.findById(bid).orElseThrow(()->new ResourceNotFound("Booking with id"+bid+"not found"));
		payment.setBooking(b1);
		Payment p1=prepo.save(payment);
		b1.setPayment(p1);
		return p1.getBooking();
	}
	
	@Override
	public ResponseEntity<String> cancelPayment(Integer pid) {
		Payment p1=prepo.findById(pid).orElseThrow(()->new ResourceNotFound("Payment with id"+pid+"not found"));
		prepo.delete(p1);
		String response="Payment with id"+pid+"is deleted";
		return ResponseEntity.ok(response);
	}

	@Override
	public ResponseEntity<?> viewPaymentByBooking(Integer bid) {
		ResponseEntity<?> resp=null;
		Optional<Booking> b1=brepo.findById(bid);
		if(b1.isPresent()) {
			List<Payment> p1=prepo.findByBooking(b1.get());
			if(!(p1.isEmpty())) {
				resp=new ResponseEntity<List<Payment>>(p1,HttpStatus.OK);
			}
			else {
				String s1="Payment with bid"+bid+"not found";
				resp=new ResponseEntity<String>(s1,HttpStatus.OK);
			}
		}
		else
		{
			String s1="Booking with bid"+bid+"not found";
			resp=new ResponseEntity<String>(s1,HttpStatus.OK);
		}
		return resp;		
}
	@Override
	public ResponseEntity<?> viewAllPaymentsByVehicle(Integer vid) {
		ResponseEntity<?> resp=null;
	/*	Optional<Vehicle> v1=vrepo.findById(vid);
		if(v1.isPresent()) {
			List<Payment> p1=prepo.findByVehicle(v1.get());
			if(!(p1.isEmpty())) {
				resp=new ResponseEntity<List<Payment>>(p1,HttpStatus.OK);
			}
			else {
				String s1="Payment with vid"+vid+"not found";
				resp=new ResponseEntity<String>(s1,HttpStatus.OK);
			}
		}
		else
		{
			String s1="Vehicle with vid"+vid+"not found";
			resp=new ResponseEntity<String>(s1,HttpStatus.OK);
		}  */
		
		
		Optional<Vehicle> v1=vrepo.findById(vid);
		if(v1.isPresent()) {
			Optional<Booking> b1=brepo.findByVehicle(v1.get());
		if(b1.isPresent()){
			List<Payment> p1=prepo.findByBooking(b1.get());
			if(!(p1.isEmpty())) {
				resp=new ResponseEntity<List<Payment>>(p1,HttpStatus.OK);
			}
			else {
				String s1="Payment with vid"+vid+"not found";
				resp=new ResponseEntity<String>(s1,HttpStatus.OK);
			}
		}
		else{
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

	@Override
	public double calculateMonthlyRevenue(LocalDate d1, LocalDate d2) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double calculateTotalPayment(Integer v) {
		// TODO Auto-generated method stub
		return 0;
	}
	


}
