package com.dbms.web.controller.entity;

public class RegionTrend {
//here is the example :  the name of all columns and datatype should be defined here 
		
	  private String country_code;
	  private String country_name;
	  private int property_damage;
	  private int fatality;
	  private int frequency;
	  
	  public RegionTrend() {}

	public RegionTrend(String country_code, String country_name, int property_damage, int fatality, int frequency) {
		super();
		this.country_code = country_code;
		this.country_name = country_name;
		this.property_damage = property_damage;
		this.fatality = fatality;
		this.frequency = frequency;
	}

	public String getCountry_code() {
		return country_code;
	}

	public void setCountry_code(String country_code) {
		this.country_code = country_code;
	}

	public String getCountry_name() {
		return country_name;
	}

	public void setCountry_name(String country_name) {
		this.country_name = country_name;
	}

	public int getProperty_damage() {
		return property_damage;
	}

	public void setProperty_damage(int property_damage) {
		this.property_damage = property_damage;
	}

	public int getFatality() {
		return fatality;
	}

	public void setFatality(int fatality) {
		this.fatality = fatality;
	}

	public int getFrequency() {
		return frequency;
	}

	public void setFrequency(int frequency) {
		this.frequency = frequency;
	}

	


	
	
}
