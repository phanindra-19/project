package com.cg.ovms.serviceImpl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.cg.ovms.entities.Driver;
import com.cg.ovms.entities.Vehicle;
import com.cg.ovms.exception.ResourceNotFound;
import com.cg.ovms.repository.IDriverRepository;
import com.cg.ovms.repository.IVehicleRepository;
import com.cg.ovms.service.IVehicleService;

@Service
public class CVehicleService implements IVehicleService{
	@Autowired
	private IVehicleRepository vrepo;
	@Autowired
	private IDriverRepository drepo;
	@Override
	public Vehicle addVehicle(Vehicle vehicle,Integer did) {
		//Optional<Driver> d1=drepo.findById(did);
		Driver d1=drepo.findById(did).orElseThrow(()->new ResourceNotFound("Driver with id"+did+"not found"));
		vehicle.setDriver(d1);
		Vehicle v1=vrepo.save(vehicle);
		d1.setVehicle(v1);
		return vrepo.save(v1);
	}



	@Override
	public ResponseEntity<String> cancelBooking(Integer vid) {
		// TODO Auto-generated method stub
		Vehicle v1=vrepo.findById(vid).orElseThrow(()->new ResourceNotFound("Vehicle with id"+vid+"not found"));
		vrepo.delete(v1);
		String response="Vehicle with id"+vid+"is deleted";
		return ResponseEntity.ok(response);
	}
	@Override
	public Vehicle updateVehicle(Vehicle vehicle) {
		// TODO Auto-generated method stub
		Vehicle v1=vrepo.save(vehicle);
		return v1;
	}
	@Override
	public ResponseEntity<?> viewVehicle(Integer vid) {
		// TODO Auto-generated method stub
		ResponseEntity<?> resp=null;
		Optional<Vehicle> v1=vrepo.findById(vid);
		if(v1.isPresent())
		{
			//Booking b2=b1.get();
			resp=new ResponseEntity<Vehicle>(v1.get(),HttpStatus.OK);
		}
		else
		{
			String s1="Vehicle with id"+vid+"not found";
			resp=new ResponseEntity<String>(s1,HttpStatus.OK);
		}
		return resp;
	}


}

