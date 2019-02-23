package edu.sabanciuniv.AliErtekinElkocaEnvironmentListener.mbeans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import org.primefaces.model.chart.MeterGaugeChartModel;
import edu.sabanciuniv.AliErtekinElkocaEnvironmentListener.business.EnvironmentListenerBusinessService;
import edu.sabanciuniv.AliErtekinElkocaEnvironmentListener.domain.AirCondition;

@ManagedBean
public class ShowMeterBean implements Serializable{
		
		@EJB
		EnvironmentListenerBusinessService envservicesc;
	 
	 
		private static final long serialVersionUID = 1L;
		private MeterGaugeChartModel meterGaugeModel1;
	    private MeterGaugeChartModel meterGaugeModel2;
	    private MeterGaugeChartModel meterGaugeModel3;
	    private AirCondition lastCondition = new AirCondition();
	    
	    
	    
	    @PostConstruct
	    public void init() {
	    	
	    		
	        createMeterGaugeModels();
	  
	        
	    }
	 
	    public MeterGaugeChartModel getMeterGaugeModel1() {
	        return meterGaugeModel1;
	    }
	     
	    public MeterGaugeChartModel getMeterGaugeModel2() {
	        return meterGaugeModel2;
	    }
	 


	    private MeterGaugeChartModel initMeterGaugeModelTemp(int current) {
	        List<Number> intervals = new ArrayList<Number>();
	        
	        intervals.add(10);

	        intervals.add(20);

	        intervals.add(30);

	        intervals.add(40);

	        intervals.add(50);
	        
	        intervals.add(60);
	        
	        intervals.add(70);
	        
	        intervals.add(80);
	        
	        intervals.add(90);
	        
	        intervals.add(100);
	        
	        
	        return new MeterGaugeChartModel(current, intervals);
	        
	    }
	    
	    private MeterGaugeChartModel initMeterGaugeModelHum(int current) {
	        List<Number> intervals = new ArrayList<Number>();
	        
	        intervals.add(10);

	        intervals.add(20);

	        intervals.add(30);

	        intervals.add(40);

	        intervals.add(50);
	        
	        intervals.add(60);
	        
	        intervals.add(70);
	        
	        intervals.add(80);
	        
	        intervals.add(90);
	        
	        intervals.add(100);
	        
	        
	        return new MeterGaugeChartModel(current, intervals);
	        
	    }
	    
	    
	    private MeterGaugeChartModel initMeterGaugeModelPres(int current) {
	        List<Number> intervals = new ArrayList<Number>();
	        
	        intervals.add(250);

	        intervals.add(500);

	        intervals.add(750);

	        intervals.add(1000);

	        intervals.add(1250);
	        
	        intervals.add(1500);
	        
	        intervals.add(1750);
	        
	        intervals.add(2000);
	        
	        intervals.add(2250);
	        
	        intervals.add(2500);
	        
	        
	        return new MeterGaugeChartModel(current, intervals);
	        
	    }
	 
	    private void createMeterGaugeModels() {
	    	
	    	lastCondition = envservicesc.getLastCondition();  
	    	int temp = (int) lastCondition.getTemperature();
	    	int hum = (int) lastCondition.getHumidity();
	    	int pres = (int) lastCondition.getPressure();
	    	String date = (String) lastCondition.getDate();
	    	
	        meterGaugeModel1 = initMeterGaugeModelTemp(temp);
	        meterGaugeModel1.setTitle("Temperature");
	        meterGaugeModel1.setGaugeLabel("Celcius");
	        
	        
	        meterGaugeModel2 = initMeterGaugeModelHum(hum);
	        meterGaugeModel2.setTitle("Humidity");
	        meterGaugeModel2.setGaugeLabel("%100");
	        
	        meterGaugeModel3 = initMeterGaugeModelPres(pres);
	        meterGaugeModel3.setTitle("Pressure");
	        meterGaugeModel3.setGaugeLabel("Mbar");
	         
	        
	    }

		public void setMeterGaugeModel1(MeterGaugeChartModel meterGaugeModel1) {
			this.meterGaugeModel1 = meterGaugeModel1;
		}

		public void setMeterGaugeModel2(MeterGaugeChartModel meterGaugeModel2) {
			this.meterGaugeModel2 = meterGaugeModel2;
		}

		
		
		public MeterGaugeChartModel getMeterGaugeModel3() {
			return meterGaugeModel3;
		}

		public void setMeterGaugeModel3(MeterGaugeChartModel meterGaugeModel3) {
			this.meterGaugeModel3 = meterGaugeModel3;
		}

		public AirCondition getLastCondition() {
			return lastCondition;
		}

		public void setLastCondition(AirCondition lastCondition) {
			this.lastCondition = lastCondition;
		}
	    
	    
	 
	}



