package edu.sabanciuniv.AliErtekinElkocaEnvironmentListener.domain;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;



@Entity
public class Role {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	private int userId;
	private String roleName;
		

	@OneToMany(mappedBy="role")
	private List<User> roleUsers;
	
	
	public Role() {
		super();
	}
	
	
	public Role(String roleName) {
		
		this.roleName = roleName;
	}
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getRoleName() {
		return roleName;
	}
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public List<User> getRoleUsers() {
		return roleUsers;
	}

	public void setRoleUsers(List<User> roleUsers) {
		this.roleUsers = roleUsers;
	}


	public int getUserId() {
		return userId;
	}


	public void setUserId(int userId) {
		this.userId = userId;
	}
	
	

}

	
	


