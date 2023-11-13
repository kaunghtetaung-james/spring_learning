package org.kaunghtetaung.springaop.model;

import org.kaunghtetaung.springaop.aspect.annotation.CustomAspectAnnotation01;

public class Game {
	
	private String name;
	private Company company;
	private String description;
	
	public String getName() {
		System.out.println("Game's getName is executed.");
		return name;
	}
	public String setName(String name) {
		System.out.println("Game's setName is executed.");
		this.name = name;
		return name;//testing AfterReturning
	}
	
	@CustomAspectAnnotation01
	public Company getCompany() {
		System.out.println("Game's getCompany is executed.");
		return company;
	}
	public void setCompany(Company company) {
		System.out.println("Game's setCompany is executed.");
		this.company = company;
	}
	public String getDescription() {
		System.out.println("Game's getDescription is executed.");
		return description;
	}
	public void setDescription(String description) {
		System.out.println("Game's setDescription is executed.");
		this.description = description;
		throw(new RuntimeException());//testing AfterThrowing
	}
	
	@Override
	public String toString() {
		return "Game [name=" + name + ", company=" + company + ", description=" + description + "]";
	}
}
