package org.kaunghtetaung.springcore.model;

public class Cpu {
	String name;
	String generation;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getGeneration() {
		return generation;
	}
	public void setGeneration(String generation) {
		this.generation = generation;
	}
	@Override
	public String toString() {
		return "Cpu [name=" + name + ", generation=" + generation + "]";
	}	
}
