package edu.sabanciuniv.AliErtekinElkocaEnvironmentListener.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;


@Entity
public class User {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	private String name;
	private String lastName;
	private String email;
	private String password;
	private String status;
	private String roleName;
	
	
	@ManyToOne
	private Role role;
	
	

	public User() {
		super();
	}

	public User(String name, String lastName, String email, String password) {
		
		this.name = name;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
		this.status = "pending";
			
	}
	
	public User(String name, String lastName, String email, String password,String roleName) {
		
		this.name = name;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
		this.status = "pending";
		this.roleName = roleName;
			
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	
	
	
}

	

