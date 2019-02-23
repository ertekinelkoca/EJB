package edu.sabanciuniv.AliErtekinElkocaEnvironmentListener.mbeans;

	
	import javax.ejb.EJB;
	import javax.faces.bean.ManagedBean;
	import javax.faces.bean.ManagedProperty;

	import edu.sabanciuniv.AliErtekinElkocaEnvironmentListener.business.EnvironmentListenerBusinessService;

	@ManagedBean
	public class TemperatureSetWarningRangeBean {


		@EJB
		EnvironmentListenerBusinessService envservicetswrb;
		
		
		@ManagedProperty("#{loginBean}")
		private LoginBean loginBean;
		
		
		 private int warningMinimumTemperatureLevel;
		 private int warningMaximumTemperatureLevel;
		 private int adminId;
		 private String adminName;
		 private int intendedMin;
		 private int intendedmax;
		
		 public void setMinMaxWarningLevel() {
			 
			 adminId = loginBean.getUser().getId();
			 adminName = loginBean.getUser().getEmail();
			 if(warningMinimumTemperatureLevel!=0 && warningMaximumTemperatureLevel!=0) {
				 

				 envservicetswrb.setMinMaxTempRange(warningMaximumTemperatureLevel, warningMinimumTemperatureLevel, adminId,adminName);
				 
			 }
		   }
		 
		public String getLastTempEditor() {
			 
			 String admin = envservicetswrb.getMinMaxTempRange().getAdminName();
			 
			 return admin;
		}
		
		public void getLastEditedRange() {
			 
			this.intendedMin = (int) envservicetswrb.getMinMaxTempRange().getTemperatureMin();
			this.intendedmax = (int) envservicetswrb.getMinMaxTempRange().getTemperatureMax();
		
		}

		public int getWarningMinimumTemperatureLevel() {
			return warningMinimumTemperatureLevel;
		}

		public void setWarningMinimumTemperatureLevel(int warningMinimumTemperatureLevel) {
			this.warningMinimumTemperatureLevel = warningMinimumTemperatureLevel;
		}

		public int getWarningMaximumTemperatureLevel() {
			return warningMaximumTemperatureLevel;
		}

		public void setWarningMaximumTemperatureLevel(int warningMaximumTemperatureLevel) {
			this.warningMaximumTemperatureLevel = warningMaximumTemperatureLevel;
		}

		public int getAdminId() {
			return adminId;
		}

		public void setAdminId(int adminId) {
			this.adminId = adminId;
		}

		public String getAdminName() {
			return adminName;
		}

		public void setAdminName(String adminName) {
			this.adminName = adminName;
		}

		public LoginBean getLoginBean() {
			return loginBean;
		}

		public void setLoginBean(LoginBean loginBean) {
			this.loginBean = loginBean;
		}

		public int getIntendedMin() {
			return intendedMin;
		}

		public void setIntendedMin(int intendedMin) {
			this.intendedMin = intendedMin;
		}

		public int getIntendedmax() {
			return intendedmax;
		}

		public void setIntendedmax(int intendedmax) {
			this.intendedmax = intendedmax;
		} 
		
		

}
