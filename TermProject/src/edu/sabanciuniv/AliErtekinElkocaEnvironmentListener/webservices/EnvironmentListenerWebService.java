package edu.sabanciuniv.AliErtekinElkocaEnvironmentListener.webservices;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import edu.sabanciuniv.AliErtekinElkocaEnvironmentListener.business.EnvironmentListenerBusinessService;
import edu.sabanciuniv.AliErtekinElkocaEnvironmentListener.business.EnvironmentListenerUserBusinessService;
import edu.sabanciuniv.AliErtekinElkocaEnvironmentListener.domain.AirCondition;

@Path("/evlwebservice")
@Stateless
public class EnvironmentListenerWebService {
	
	@EJB
	EnvironmentListenerBusinessService envlisbu;
	
	@EJB
	EnvironmentListenerUserBusinessService envlisus;
	
	
	
	@GET
	@Path("/addservice/{temperature}/{humidity}/{pressure}/{date}")
	public void addCondition(@PathParam("temperature")float t,
			@PathParam("humidity")float h,
			@PathParam("pressure")float p,
			@PathParam("date")String d){
		
		AirCondition air = new AirCondition(t, h, p,d);	
		envlisbu.addCondition(air);
		
	}	
	

	@GET
	@Path("/lasttempcondition")
	public float lastTempCondition(){
		
		return envlisbu.getLastCondition().getTemperature();
		
	}	
	
	@GET
	@Path("/lasthumcondition")
	public float lastHumidityCondition(){
		
		return envlisbu.getLastCondition().getHumidity();
		
	}	
	

	@GET
	@Path("/setmintempwarningcondition")
	public float setMinTempWarningCondition(){
		
		float min = (float)envlisbu.getMinMaxTempRange().getTemperatureMin();
		
		return min;
		
	}	
	
	@GET
	@Path("/setmaxtempwarningcondition")
	public float setMaxTempWarningCondition(){

		float max = (float)envlisbu.getMinMaxTempRange().getTemperatureMax();
		
		return max;
		
	}
	
	@GET
	@Path("/getuserlist")
	public String getUserList(){
		
		String mail = (String)envlisus.getauthorizedUsersMails();		
		
		return mail;
		
	}
	


}
