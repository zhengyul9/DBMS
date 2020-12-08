package com.dbms.web.controller.entity;
//QUERY 8
public class TerroristTrend {

	//here is the example :  the name of all columns and datatype should be defined here 
		
		private String event_year;
//		private int Biological;
//		private int Chemical;
		private int UnarmedAssault;
		private int ArmedAssault;
		private int Hijacking;
		private int HostageTaking;
		private int Bombing;
		private int Facility;
		private int Assassination;
		private int Kidnapping;
			
	// make empty one
		public TerroristTrend() {}

		
	//Afterwards, rightbutton click -> source -> generate constructor using fields
		public TerroristTrend(String event_year, int unarmedAssault, int armedAssault, int hijacking, int hostageTaking,
				int bombing, int facility, int assassination, int kidnapping) {
			super();
			this.event_year = event_year;
			UnarmedAssault = unarmedAssault;
			ArmedAssault = armedAssault;
			Hijacking = hijacking;
			HostageTaking = hostageTaking;
			Bombing = bombing;
			Facility = facility;
			Assassination = assassination;
			Kidnapping = kidnapping;
		}

		//Afterwards, rightbutton click -> source -> generate getter and setter
		public String getEvent_year() {
			return event_year;
		}


		public void setEvent_year(String event_year) {
			this.event_year = event_year;
		}


		public int getUnarmedAssault() {
			return UnarmedAssault;
		}


		public void setUnarmedAssault(int unarmedAssault) {
			UnarmedAssault = unarmedAssault;
		}


		public int getArmedAssault() {
			return ArmedAssault;
		}


		public void setArmedAssault(int armedAssault) {
			ArmedAssault = armedAssault;
		}


		public int getHijacking() {
			return Hijacking;
		}


		public void setHijacking(int hijacking) {
			Hijacking = hijacking;
		}


		public int getHostageTaking() {
			return HostageTaking;
		}


		public void setHostageTaking(int hostageTaking) {
			HostageTaking = hostageTaking;
		}


		public int getBombing() {
			return Bombing;
		}


		public void setBombing(int bombing) {
			Bombing = bombing;
		}


		public int getFacility() {
			return Facility;
		}


		public void setFacility(int facility) {
			Facility = facility;
		}


		public int getAssassination() {
			return Assassination;
		}


		public void setAssassination(int assassination) {
			Assassination = assassination;
		}


		public int getKidnapping() {
			return Kidnapping;
		}


		public void setKidnapping(int kidnapping) {
			Kidnapping = kidnapping;
		}	
		


}
