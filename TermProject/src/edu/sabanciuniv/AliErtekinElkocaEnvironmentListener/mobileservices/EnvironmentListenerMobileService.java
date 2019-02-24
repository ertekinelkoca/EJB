package edu.sabanciuniv.AliErtekinElkocaEnvironmentListener.mobileservices;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.Consumes;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import edu.sabanciuniv.AliErtekinElkocaEnvironmentListener.business.EnvironmentListenerBusinessService;
import edu.sabanciuniv.AliErtekinElkocaEnvironmentListener.business.EnvironmentListenerUserBusinessService;
import edu.sabanciuniv.AliErtekinElkocaEnvironmentListener.domain.AirCondition;

@Path("/evlmobileservice")
@Stateless
public class EnvironmentListenerMobileService {
	
	@EJB
	EnvironmentListenerBusinessService envlisbu;
	
	@EJB
	EnvironmentListenerUserBusinessService envlisus;

	@Path("/sendCondition")
	@Consumes("application/json")
	@Produces(MediaType.APPLICATION_JSON)
	public AirCondition sendCondition() {
	
		return new AirCondition(envlisbu.getLastCondition().getTemperature(), envlisbu.getLastCondition().getHumidity(), envlisbu.getLastCondition().getPressure(),envlisbu.getLastCondition().getDate());
				
	}
	
	@Path("/getwarningrange")
	@Consumes("application/json")
	@Produces(MediaType.APPLICATION_JSON)
	public String getWarningRange() {
	
		
		
		return "";
	}
	
	
	
	
	
	
	
	
	
}
