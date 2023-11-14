package org.kaunghtetaung.springdatasource.model;

public class Circle {
	int id;
	String name;
	
	//getters and setters
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
	
	//parameterized constructor
	public Circle(int id, String name) {	
		this.id = id;
		this.name = name;
	}
	
	@Override
	public String toString() {
		return "Circle [id=" + id + ", name=" + name + "]";
	}
}