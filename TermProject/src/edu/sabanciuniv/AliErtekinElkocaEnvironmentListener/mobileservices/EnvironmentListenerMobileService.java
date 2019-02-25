package edu.sabanciuniv.AliErtekinElkocaEnvironmentListener.mobileservices;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.faces.bean.ManagedProperty;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import edu.sabanciuniv.AliErtekinElkocaEnvironmentListener.business.EnvironmentListenerBusinessService;
import edu.sabanciuniv.AliErtekinElkocaEnvironmentListener.business.EnvironmentListenerUserBusinessService;
import edu.sabanciuniv.AliErtekinElkocaEnvironmentListener.domain.AirCondition;
import edu.sabanciuniv.AliErtekinElkocaEnvironmentListener.mbeans.LoginBean;

@Path("/evlmobileservice")
@Stateless
public class EnvironmentListenerMobileService {
	
	@ManagedProperty("#{loginBean}")
	private LoginBean loginBean;
	
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
	public void getWarningRange(@FormParam("tempWarningRangeMax")int tempWarningRangeMax,@FormParam("tempWarningRangeMin")int tempWarningRangeMin) {
		
		
	
		envlisbu.setMinMaxTempRange(tempWarningRangeMax, tempWarningRangeMin, loginBean.getUser().getId(), loginBean.getEmail());
	
	}
		
}
