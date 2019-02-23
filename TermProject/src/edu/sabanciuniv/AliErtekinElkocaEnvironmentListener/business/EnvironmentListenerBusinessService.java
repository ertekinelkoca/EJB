package edu.sabanciuniv.AliErtekinElkocaEnvironmentListener.business;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import edu.sabanciuniv.AliErtekinElkocaEnvironmentListener.domain.AirCondition;
import edu.sabanciuniv.AliErtekinElkocaEnvironmentListener.domain.AirConditionRange;


@Stateless
public class EnvironmentListenerBusinessService {

	@PersistenceContext
	private EntityManager entityMananger;
			
	
	public void addCondition(AirCondition air) {
		
		entityMananger.persist(air);
		
	}
	
	
	public AirCondition getLastCondition() {
		
		if(getAllAirDatas().size()>0) {

		AirCondition lastCondition = entityMananger.createQuery("select a from AirCondition a order by a.id desc",AirCondition.class)
				.setFirstResult(0).setMaxResults(1).getSingleResult();
		
		}else {
			
			
		}
		
		return new AirCondition();
		
	}
	
	public List<AirCondition> getAllAirDatas(){
		

		List<AirCondition> conditionHistory = entityMananger.createQuery("select a from AirCondition a",AirCondition.class)
				.getResultList();
		
		return conditionHistory;
		
	}
	
	public void setMinMaxTempRange(float temperatureMax , float temperatureMin ,int adminId,String adminName){
		
		AirConditionRange range = new AirConditionRange(temperatureMax , temperatureMin , adminId,adminName);
		
		entityMananger.persist(range);
		
	
		
	}
	
	
	public AirConditionRange getMinMaxTempRange(){
		
		if(getAllAirDatas().size()>0) {
		
			AirConditionRange lastRange =  entityMananger.createQuery("select a from AirConditionRange a order by a.id desc",AirConditionRange.class)
					.setFirstResult(0).setMaxResults(1).getSingleResult();
			
			return lastRange;
			
		}else {
			
			
			return  new AirConditionRange();
		
		}
		
		
	}
	

}
