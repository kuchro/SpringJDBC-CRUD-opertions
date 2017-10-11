package org.jdbcproject.model;

import java.util.List;





public class ModelOne {
	private int id;
	private String name;
	private int number;
	private String place;
	private List<ModelMany> modelMany;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public String getPlace() {
		return place;
	}
	public void setPlace(String place) {
		this.place = place;
	}
	public List<ModelMany> getModelMany() {
		return modelMany;
	}
	public void setModelMany(List<ModelMany> modelMany) {
		this.modelMany = modelMany;
	}
	
	

}
