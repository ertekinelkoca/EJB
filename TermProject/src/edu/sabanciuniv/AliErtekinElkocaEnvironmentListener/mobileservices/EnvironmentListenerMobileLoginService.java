package edu.sabanciuniv.AliErtekinElkocaEnvironmentListener.mobileservices;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import edu.sabanciuniv.AliErtekinElkocaEnvironmentListener.business.EnvironmentListenerBusinessService;
import edu.sabanciuniv.AliErtekinElkocaEnvironmentListener.business.EnvironmentListenerUserBusinessService;
import edu.sabanciuniv.AliErtekinElkocaEnvironmentListener.domain.User;

@Path("/evlregistrationmobileservice")
@Stateless
public class EnvironmentListenerMobileLoginService {
	
	private String email;
	private String password;
	private String roleName;
	private User user;
	
	@EJB
	EnvironmentListenerBusinessService envlisbu;
	
	@EJB
	EnvironmentListenerUserBusinessService envlisus;
	
	@POST
	@Path("/userregistration")
	@Consumes("application/json")
	public void userRegistration(@FormParam("name")String name
			,@FormParam("lastName")String lastName
			,@FormParam("email")String email
			,@FormParam("password")String password
			,@FormParam("roleName")String roleName){
		
		/*@FormParam("id")int id
		  @POST
		@Path("create")
		@Consumes("application/x-www-form-urlencoded")
		public Order createOrder(@FormParam("id")int id, 
                         @FormParam("name")String name) {
  			Order order = new Order();
  			order.setId(id);
  			order.setName(name);
  			return order;
		}	
*/
		new User(name, lastName, email, password, roleName);
		
	}
	
	@POST
	@Path("/userlogin")
	@Consumes("application/json")
	@Produces(MediaType.APPLICATION_JSON)
	public String userLogin(@FormParam("email")String email ,@FormParam("password")String password)
	
	{

		
		user = envlisus.getUserWithRole(email,password);
		
		if(user==null)
		{	

			return "login";
			
		}	
		
		if(user.getRoleName().equals("admin")&& user.getStatus().equals("approved"))
		{

			return "admin";
		} 
		
		else if(user.getRoleName().equals("user") && user.getStatus().equals("approved"))
		{
			 
			return "user";	
		}
		
		return "login";
	
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

	public EnvironmentListenerBusinessService getEnvlisbu() {
		return envlisbu;
	}

	public void setEnvlisbu(EnvironmentListenerBusinessService envlisbu) {
		this.envlisbu = envlisbu;
	}

	public EnvironmentListenerUserBusinessService getEnvlisus() {
		return envlisus;
	}

	public void setEnvlisus(EnvironmentListenerUserBusinessService envlisus) {
		this.envlisus = envlisus;
	}
	
	
}
