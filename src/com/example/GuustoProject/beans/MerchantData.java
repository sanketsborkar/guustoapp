package com.example.GuustoProject.beans;

public class MerchantData {
	
	private String name;
	private String type;
	private String range;
	private String country;
	
	public MerchantData() {
		
	}
	
	public MerchantData(String name, String type, String range, String country) {
		super();
		this.name = name;
		this.type = type;
		this.range = range;
		this.country = country;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getRange() {
		return range;
	}

	public void setRange(String range) {
		this.range = range;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}
}
