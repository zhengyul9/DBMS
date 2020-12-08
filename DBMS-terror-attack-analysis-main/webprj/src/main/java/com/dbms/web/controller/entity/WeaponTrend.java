package com.dbms.web.controller.entity;

public class WeaponTrend {
	private String event_year;
	private int Biological;
	private int Chemical;
	private int Explosives;
	private int Fake_Weapons;
	private int Firearms;
	private int Incendiary;
	private int Melee;
	private int Other;
	private int Radiological;
	private int Sabotage_Equipment;
	private int Vehicle;

	public WeaponTrend() {}

	public WeaponTrend(String event_year, int biological, int chemical, int explosives, int fake_Weapons, int firearms,
			int incendiary, int melee, int other, int radiological, int sabotage_Equipment, int vehicle) {
		super();
		this.event_year = event_year;
		Biological = biological;
		Chemical = chemical;
		Explosives = explosives;
		Fake_Weapons = fake_Weapons;
		Firearms = firearms;
		Incendiary = incendiary;
		Melee = melee;
		Other = other;
		Radiological = radiological;
		Sabotage_Equipment = sabotage_Equipment;
		Vehicle = vehicle;
	}

	public String getEvent_year() {
		return event_year;
	}

	public void setEvent_year(String event_year) {
		this.event_year = event_year;
	}

	public int getBiological() {
		return Biological;
	}

	public void setBiological(int biological) {
		Biological = biological;
	}

	public int getChemical() {
		return Chemical;
	}

	public void setChemical(int chemical) {
		Chemical = chemical;
	}

	public int getExplosives() {
		return Explosives;
	}

	public void setExplosives(int explosives) {
		Explosives = explosives;
	}

	public int getFake_Weapons() {
		return Fake_Weapons;
	}

	public void setFake_Weapons(int fake_Weapons) {
		Fake_Weapons = fake_Weapons;
	}

	public int getFirearms() {
		return Firearms;
	}

	public void setFirearms(int firearms) {
		Firearms = firearms;
	}

	public int getIncendiary() {
		return Incendiary;
	}

	public void setIncendiary(int incendiary) {
		Incendiary = incendiary;
	}

	public int getMelee() {
		return Melee;
	}

	public void setMelee(int melee) {
		Melee = melee;
	}

	public int getOther() {
		return Other;
	}

	public void setOther(int other) {
		Other = other;
	}

	public int getRadiological() {
		return Radiological;
	}

	public void setRadiological(int radiological) {
		Radiological = radiological;
	}

	public int getSabotage_Equipment() {
		return Sabotage_Equipment;
	}

	public void setSabotage_Equipment(int sabotage_Equipment) {
		Sabotage_Equipment = sabotage_Equipment;
	}

	public int getVehicle() {
		return Vehicle;
	}

	public void setVehicle(int vehicle) {
		Vehicle = vehicle;
	}
	
	
	

}
