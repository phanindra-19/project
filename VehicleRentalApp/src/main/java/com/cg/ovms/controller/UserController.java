package com.cg.ovms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.ovms.entities.User;
import com.cg.ovms.service.IUserService;

@RestController
@RequestMapping("/user")
@CrossOrigin
public class UserController {

	@Autowired
	private IUserService uservice;
	@GetMapping("/validate")
	public User validateUser(User user) {
		return uservice.validateUser(user);
	}
	@PostMapping("/url")
	public User addUser(User user) {
		return uservice.addUser(user);
	}
	@DeleteMapping("/url")
	public User removeUser(User user) {
		return uservice.removeUser(user);
	}
	@GetMapping("/signout")
	public User signOut(User user) {
		return uservice.signOut(user);
	}
	
}
