package com.cg.ovms.repository;

import java.time.LocalDate;
import java.util.List;

import com.cg.ovms.entities.Booking;
import com.cg.ovms.entities.Customer;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICustomerRepository extends JpaRepository<Customer,Integer>{


}
