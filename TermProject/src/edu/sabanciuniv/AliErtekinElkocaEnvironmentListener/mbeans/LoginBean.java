package edu.sabanciuniv.AliErtekinElkocaEnvironmentListener.mbeans;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import edu.sabanciuniv.AliErtekinElkocaEnvironmentListener.business.EnvironmentListenerUserBusinessService;
import edu.sabanciuniv.AliErtekinElkocaEnvironmentListener.domain.User;


@ManagedBean
@SessionScoped
public class LoginBean {
	
	private String email;
	private String password;
	private String roleName;
	private User user;
	
	@EJB
	private EnvironmentListenerUserBusinessService userService;
	
	
	public String login()
	{

		
		user = userService.getUserWithRole(email,password);
		
		if(user==null)
		{	

			 FacesContext.getCurrentInstance().addMessage(null,
		                new FacesMessage("Wrong Credentials","Wrong Credentials"));
			return "unauthorized?faces-redirect=true";
			
		}
			
		
		if(user.getRoleName().equals("admin")&& user.getStatus().equals("approved"))
		{

			 FacesContext.getCurrentInstance().addMessage(null,
		                new FacesMessage("Welcome " + user.getName() + " " + user.getLastName(),"Welcome " + user.getName() + " " + user.getLastName()));
			return "admin/admindirection?faces-redirect=true";
		} 
		
		else if(user.getRoleName().equals("user") && user.getStatus().equals("approved"))
		{
			 FacesContext.getCurrentInstance().addMessage(null,
		                new FacesMessage("Welcome " + user.getName() + " " + user.getLastName(),"Welcome " + user.getName() + " " + user.getLastName()));
			return "user/userobservation?faces-redirect=true";	
		}
		 FacesContext.getCurrentInstance().addMessage(null,
	                new FacesMessage("Directing To Login","Directing To Login"));
		
		return "login?faces-redirect=true";
	
	}
	
	
	public String logOut() 
	{
		
		this.email = null;
		this.password = null;
		return "/login?faces-redirect=true";
		
		
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


	public String getRoleName() {
		return roleName;
	}


	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}


	public User getUser() {
		return user;
	}


	public void setUser(User user) {
		this.user = user;
	}

	

	
	

}



