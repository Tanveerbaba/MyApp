package com.hashworks.MyApp.model;

public class Employee {
	private String id;
	private String name;
	private String jobPosition;
	private Float experience;
	
	
	public Employee() {
		
	}
	public Employee(String i, String name, String jobPosition, float experience) {
		this.id = i;
		this.name = name;
		this.jobPosition = jobPosition;
		this.experience = experience;
	}

	public String getId() {
		return id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setId(String id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setJobPosition(String jobPosition) {
		this.jobPosition = jobPosition;
	}

	public void setExperience(Float experience) {
		this.experience = experience;
	}

	public String getJobPosition() {
		return jobPosition;
	}
	
	public float getExperience() {
		return experience;
	}
	
}
