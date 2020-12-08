package com.dbms.web.controller.entity;
//QUERY 10
public class SuccessRate {
//here is the example :  the name of all columns and datatype should be defined here 
	
	private String event_year;
	private float CentralAmericaAndCaribbean;
	private float AustralasiaAndOceania;
	private float SouthAmerica;
	private float CentralAsia;
	private float MiddleEastAndNorthAfrica;
	private float EastAsia;
	private float SouthAsia;
	private float EasternEurope;
	private float Southeastasia;
	private float WesternEurope;
	private float SubSaharanAfrica;
	private float NorthAmerica;
	
// make empty one
	public SuccessRate() {}


	
//Afterwards, rightbutton click -> source -> generate constructor using fields
	public SuccessRate(String event_year, float centralAmericaAndCaribbean, float australasiaAndOceania, float southAmerica,
			float centralAsia, float middleEastAndNorthAfrica, float eastAsia, float southAsia, float easternEurope,
			float southeastasia, float westernEurope, float subSaharanAfrica, float northAmerica) {
		super();
		this.event_year = event_year;
		CentralAmericaAndCaribbean = centralAmericaAndCaribbean;
		AustralasiaAndOceania = australasiaAndOceania;
		SouthAmerica = southAmerica;
		CentralAsia = centralAsia;
		MiddleEastAndNorthAfrica = middleEastAndNorthAfrica;
		EastAsia = eastAsia;
		SouthAsia = southAsia;
		EasternEurope = easternEurope;
		Southeastasia = southeastasia;
		WesternEurope = westernEurope;
		SubSaharanAfrica = subSaharanAfrica;
		NorthAmerica = northAmerica;
	}

	//Afterwards, rightbutton click -> source -> generate getter and setter
	public String getEvent_year() {
		return event_year;
	}
	
	public void setEvent_year(String event_year) {
		this.event_year = event_year;
	}

	public float getCentralAmericaAndCaribbean() {
		return CentralAmericaAndCaribbean;
	}

	public void setCentralAmericaAndCaribbean(float centralAmericaAndCaribbean) {
		CentralAmericaAndCaribbean = centralAmericaAndCaribbean;
	}

	public float getAustralasiaAndOceania() {
		return AustralasiaAndOceania;
	}

	public void setAustralasiaAndOceania(float australasiaAndOceania) {
		AustralasiaAndOceania = australasiaAndOceania;
	}

	public float getSouthAmerica() {
		return SouthAmerica;
	}

	public void setSouthAmerica(float southAmerica) {
		SouthAmerica = southAmerica;
	}

	public float getCentralAsia() {
		return CentralAsia;
	}

	public void setCentralAsia(float centralAsia) {
		CentralAsia = centralAsia;
	}

	public float getMiddleEastAndNorthAfrica() {
		return MiddleEastAndNorthAfrica;
	}

	public void setMiddleEastAndNorthAfrica(float middleEastAndNorthAfrica) {
		MiddleEastAndNorthAfrica = middleEastAndNorthAfrica;
	}

	public float getEastAsia() {
		return EastAsia;
	}

	public void setEastAsia(float eastAsia) {
		EastAsia = eastAsia;
	}

	public float getSouthAsia() {
		return SouthAsia;
	}

	public void setSouthAsia(float southAsia) {
		SouthAsia = southAsia;
	}

	public float getEasternEurope() {
		return EasternEurope;
	}

	public void setEasternEurope(float easternEurope) {
		EasternEurope = easternEurope;
	}

	public float getSoutheastasia() {
		return Southeastasia;
	}

	public void setSoutheastasia(float southeastasia) {
		Southeastasia = southeastasia;
	}

	public float getWesternEurope() {
		return WesternEurope;
	}

	public void setWesternEurope(float westernEurope) {
		WesternEurope = westernEurope;
	}

	public float getSubSaharanAfrica() {
		return SubSaharanAfrica;
	}

	public void setSubSaharanAfrica(float subSaharanAfrica) {
		SubSaharanAfrica = subSaharanAfrica;
	}

	public float getNorthAmerica() {
		return NorthAmerica;
	}

	public void setNorthAmerica(float northAmerica) {
		NorthAmerica = northAmerica;
	}
	
}
