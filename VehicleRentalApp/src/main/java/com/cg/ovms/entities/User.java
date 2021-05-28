package com.cg.ovms.entities;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="user")
public class User {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer userId;
	@Column(name="password")
	private String password;
	@Column(name="role")
	private String role;
	
	public User() {
		
	}
	
	public User(Integer userId) {
		super();
		this.userId = userId;
	}

	public User(String password, String role) {
		super();
		this.password = password;
		this.role = role;
	}

	public User(Integer userId, String password, String role) {
		super();
		this.userId = userId;
		this.password = password;
		this.role = role;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	@Override
	public String toString() {
		return "User[userId="+userId+",password="+password+",role="+role+"]";

	}
	
}
