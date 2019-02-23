package edu.sabanciuniv.AliErtekinElkocaEnvironmentListener.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class AirCondition {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private float temperature;
	private float humidity;
	private float pressure;
	private String Date;
	
	
	
	
	public AirCondition() {
		super();
	}


	public AirCondition(float temperature, float humidity, float pressure, String date) {
		super();
		this.temperature = temperature;
		this.humidity = humidity;
		this.pressure = pressure;
		Date = date;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public float getTemperature() {
		return temperature;
	}


	public void setTemperature(float temperature) {
		this.temperature = temperature;
	}


	public float getHumidity() {
		return humidity;
	}


	public void setHumidity(float humidity) {
		this.humidity = humidity;
	}


	public float getPressure() {
		return pressure;
	}


	public void setPressure(float pressure) {
		this.pressure = pressure;
	}


	public String getDate() {
		return Date;
	}


	public void setDate(String date) {
		Date = date;
	}
	
	
	
	
	
	
	
}
