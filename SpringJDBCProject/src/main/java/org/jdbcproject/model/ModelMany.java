package org.jdbcproject.model;




public class ModelMany {

	private int id;
	private String nameOne;
	private String nameTwo;
	private String nameThree;
	private int number;
	private int modelOneId;
	
	
	public int getModelOneId() {
		return modelOneId;
	}
	public void setModelOneId(int modelOneId) {
		this.modelOneId = modelOneId;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNameOne() {
		return nameOne;
	}
	public void setNameOne(String nameOne) {
		this.nameOne = nameOne;
	}
	public String getNameTwo() {
		return nameTwo;
	}
	public void setNameTwo(String nameTwo) {
		this.nameTwo = nameTwo;
	}
	public String getNameThree() {
		return nameThree;
	}
	public void setNameThree(String nameThree) {
		this.nameThree = nameThree;
	}
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	
	
}
