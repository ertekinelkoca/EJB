package edu.sabanciuniv.AliErtekinElkocaEnvironmentListener.mbeans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import org.primefaces.model.chart.Axis;
import org.primefaces.model.chart.AxisType;
import org.primefaces.model.chart.LineChartModel;
import org.primefaces.model.chart.LineChartSeries;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import edu.sabanciuniv.AliErtekinElkocaEnvironmentListener.business.EnvironmentListenerBusinessService;
import edu.sabanciuniv.AliErtekinElkocaEnvironmentListener.domain.AirCondition;

@ManagedBean
public class ShowLineChartBean implements Serializable{
	
	@EJB
	EnvironmentListenerBusinessService envserviceac;
	
	  
	private static final long serialVersionUID = 1L;
	private LineChartModel lineModel1;
	private LineChartModel lineModel2;
	private LineChartModel lineModel3;
	private List<AirCondition> airList = new ArrayList<AirCondition>();
	
	 
	 
	 @PostConstruct
	    public void init() {
		 	
	        createLineModels();
	        
	    }
	 
	         
	    private LineChartModel initLinearModelTemp() {
	        
	    	airList = envserviceac.getAllAirDatas();
	    	
	    	LineChartModel model = new LineChartModel();
	 
	        LineChartSeries series1 = new LineChartSeries();
	        series1.setLabel("Temperature");
	        
	        if(airList.size()>99) {
	        	
	        	for(int i = airList.size()-1;i>airList.size()-101;i--) {
	    	        
		        	series1.set(airList.size()-i, airList.get(i).getTemperature());
		             	
		        }
		        	
	        	
	        }
	        
	        
	        model.addSeries(series1);
	         
	        return model;
	    }
	    
	    private LineChartModel initLinearModelHum() {
	        
	    	airList = envserviceac.getAllAirDatas();
	    	
	    	LineChartModel model = new LineChartModel();
	 
	        LineChartSeries series1 = new LineChartSeries();
	        series1.setLabel("Humidity");
	        
	        if(airList.size()>99) {
	        	
	        	for(int i = airList.size()-1;i>airList.size()-101;i--) {
	    	        
		        	series1.set(airList.size()-i, airList.get(i).getHumidity());
		        	
		        }
	        	
	        }
	 
	        model.addSeries(series1);
			        
	  	    return model;
	        	
	        

	    }
	    
	    private LineChartModel initLinearModelPres() {
	        
	    	airList = envserviceac.getAllAirDatas();
	    	
	    	LineChartModel model = new LineChartModel();
	 
	        LineChartSeries series1 = new LineChartSeries();
	        series1.setLabel("Pressure");
	        
	        if(airList.size()>99) {
	        	
	        	for(int i = airList.size()-1;i>airList.size()-101;i--) {
	    	        
		        	series1.set(airList.size()-i, airList.get(i).getPressure());
		             	
		        }
	        	
	        	
	        }
	        	
	        model.addSeries(series1);
	         
	        return model;
	    }
	    
	    
	    private void createLineModels() {
	        
	    	
	    	lineModel1 = initLinearModelTemp();
	        lineModel1.setTitle("Temperture Linear Chart");
	        lineModel1.setLegendPosition("e");
	        Axis yAxis1 = lineModel1.getAxis(AxisType.Y);
	        yAxis1.setMin(-20);
	        yAxis1.setMax(80);
	        yAxis1.setLabel("Last 100 Measurement Up To Now");
	        Axis xAxis1 = lineModel1.getAxis(AxisType.X);
	        xAxis1.setMin(0);
	        xAxis1.setMax(100);
	        xAxis1.setLabel("C\u00b0");
	        

	    	lineModel2 = initLinearModelHum();
	        lineModel2.setTitle("Humidity Linear Chart");
	        lineModel2.setLegendPosition("e");
	        Axis yAxis2 = lineModel2.getAxis(AxisType.Y);
	        yAxis2.setMin(0);
	        yAxis2.setMax(100);
	        yAxis2.setLabel("Last 100 Measurement Up To Now");
	        Axis xAxis2 = lineModel2.getAxis(AxisType.X);
	        xAxis2.setMin(0);
	        xAxis2.setMax(100);
	        xAxis2.setLabel("%100");
	        
	        

	    	lineModel3 = initLinearModelPres();
	        lineModel3.setTitle("Pressure Linear Chart");
	        lineModel3.setLegendPosition("e");
	        Axis yAxis3 = lineModel3.getAxis(AxisType.Y);
	        yAxis3.setMin(0);
	        yAxis3.setMax(2000);
	        yAxis3.setLabel("Last 100 Measurement Up To Now");
	        Axis xAxis3 = lineModel3.getAxis(AxisType.X);
	        xAxis3.setMin(0);
	        xAxis3.setMax(100);
	        xAxis3.setLabel("Mbar");
	         
	    
	    }

		public void setLineModel1(LineChartModel lineModel1) {
			
			this.lineModel1 = lineModel1;
			
		}

	
	    public LineChartModel getLineModel1() {
	        return lineModel1;
	    }


		public LineChartModel getLineModel2() {
			return lineModel2;
		}


		public void setLineModel2(LineChartModel lineModel2) {
			this.lineModel2 = lineModel2;
		}


		public LineChartModel getLineModel3() {
			return lineModel3;
		}


		public void setLineModel3(LineChartModel lineModel3) {
			this.lineModel3 = lineModel3;
		}
	    
	    
	 
	  

	    
	    
	    
}
