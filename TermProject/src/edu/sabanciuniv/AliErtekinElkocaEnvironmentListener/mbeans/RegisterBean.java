package edu.sabanciuniv.AliErtekinElkocaEnvironmentListener.mbeans;

import java.util.List;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import edu.sabanciuniv.AliErtekinElkocaEnvironmentListener.business.EnvironmentListenerUserBusinessService;
import edu.sabanciuniv.AliErtekinElkocaEnvironmentListener.domain.Role;
import edu.sabanciuniv.AliErtekinElkocaEnvironmentListener.domain.User;

@ManagedBean
@SessionScoped
public class RegisterBean {
	
	@EJB
	private EnvironmentListenerUserBusinessService envlubs;
	
	private String email;
	private String password;
	private String name;
	private String lastname;
	private String roleName;
	private Role role;
	private User user;
	private User userToBeActivated;
	private User userToBeRejected;
	

	private List<User> unauthorizedUsers;
	private List<User> authorizedUsers;
	
	public List<User> statusAuthorization() {
		
		
		
		 unauthorizedUsers = envlubs.getUnauthorizedUsers();
		 return unauthorizedUsers;
		
	}
	
	public List<User> statusUnauthorization() {
		
		
		
		 authorizedUsers = envlubs.getauthorizedUsers();
		 return authorizedUsers;
		
	}
	
	
	
	
	
	public String register() {
		
		
		user = new User(name,lastname,email,password);
		String result = envlubs.userRegistration(user);
		role = new Role(roleName);
		role.setUserId(user.getId());
		envlubs.roleRegistration(role,user.getId());
		
		if(result.equals("register")){
			FacesContext.getCurrentInstance().addMessage(null,new FacesMessage("Wrong credentials!!!"));
			return result.concat("?faces-redirect=true");
		}
		else {
			FacesContext.getCurrentInstance().addMessage(null,new FacesMessage("Registration Success!!!"));
			return result.concat("?faces-redirect=true");
		}
	}
	
	
	public void userApproval(User user) {
		
		
		envlubs.userApproval(user);
		
	}
	
	public void userDeactivation(User user) {
		
		
		envlubs.userDeactivation(user);
		
	}
	
	public void userRejection(User user) {
		
		
		envlubs.userRejection(user);
		
		
	}
	
	public void userRoleChange(User user) {
		
		
		envlubs.userRoleChanger(user);
		
	}

	public EnvironmentListenerUserBusinessService getEnvlubs() {
		return envlubs;
	}




	public void setEnvlubs(EnvironmentListenerUserBusinessService envlubs) {
		this.envlubs = envlubs;
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




	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
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


	public List<User> getUnauthorizedUsers() {
		return unauthorizedUsers;
	}

	public void setUnauthorizedUsers(List<User> unauthorizedUsers) {
		this.unauthorizedUsers = unauthorizedUsers;
	}




	public User getUserToBeActivated() {
		return userToBeActivated;
	}




	public void setUserToBeActivated(User userToBeActivated) {
		this.userToBeActivated = userToBeActivated;
	}




	public User getUserToBeRejected() {
		return userToBeRejected;
	}




	public void setUserToBeRejected(User userToBeRejected) {
		this.userToBeRejected = userToBeRejected;
	}

	public List<User> getAuthorizedUsers() {
		return authorizedUsers;
	}

	public void setAuthorizedUsers(List<User> authorizedUsers) {
		this.authorizedUsers = authorizedUsers;
	}
	
	

}
