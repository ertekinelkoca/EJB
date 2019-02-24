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
	
	@EJB
	EnvironmentListenerBusinessService envlisbu;
	
	@EJB
	EnvironmentListenerUserBusinessService envlisus;
	
	@POST
	@Path("/userregistration")
	@Consumes("application/json")
	@Produces(MediaType.APPLICATION_JSON)
	public void userRegistration(@FormParam("name")String name,@FormParam("lastName")String lastName,@FormParam("email")String email,@FormParam("password")String password,@FormParam("roleName")String roleName){
		
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
	

}
