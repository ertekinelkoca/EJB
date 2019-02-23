package edu.sabanciuniv.AliErtekinElkocaEnvironmentListener.domain;

	
	
	import java.time.LocalDateTime;

	import javax.persistence.Entity;
	import javax.persistence.GeneratedValue;
	import javax.persistence.GenerationType;
	import javax.persistence.Id;

	@Entity
	public class AirConditionRange {

		@Id
		@GeneratedValue(strategy=GenerationType.IDENTITY)
		private int id;
		
		private float temperatureMax;
		private float temperatureMin;
		private int adminId;
		private String adminName;
		LocalDateTime date;
		
		
		
		public AirConditionRange() {
			super();
		}

		
		
		public AirConditionRange(float temperatureMax, float temperatureMin, int adminId,String adminName) {
			super();
			this.temperatureMax = temperatureMax;
			this.temperatureMin = temperatureMin;
			this.adminId = adminId;
			this.adminName = adminName;
			this.date = LocalDateTime.now();
		}



		public float getTemperatureMax() {
			return temperatureMax;
		}

		public void setTemperatureMax(float temperatureMax) {
			this.temperatureMax = temperatureMax;
		}

		public float getTemperatureMin() {
			return temperatureMin;
		}

		public void setTemperatureMin(float temperatureMin) {
			this.temperatureMin = temperatureMin;
		}

		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

		public int getAdminId() {
			return adminId;
		}

		public void setAdminId(int adminId) {
			this.adminId = adminId;
		}



		public LocalDateTime getDate() {
			return date;
		}



		public void setDate(LocalDateTime date) {
			this.date = date;
		}



		public String getAdminName() {
			return adminName;
		}



		public void setAdminName(String adminName) {
			this.adminName = adminName;
		}


}
