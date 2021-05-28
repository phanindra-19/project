package com.cg.ovms.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.ovms.entities.User;
import com.cg.ovms.repository.IUserRepository;
import com.cg.ovms.service.IUserService;

@Service
public class CUserService implements IUserService{

	@Autowired
	private IUserRepository urepo;
	
	@Override
	public User validateUser(User user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User addUser(User user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User removeUser(User user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User signOut(User user) {
		// TODO Auto-generated method stub
		return null;
	}

}
