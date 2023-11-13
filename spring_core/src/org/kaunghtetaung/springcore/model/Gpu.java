package org.kaunghtetaung.springcore.model;

public class Gpu {
	String name;
	String capacity; //4GB, 8GB or ...
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCapacity() {
		return capacity;
	}
	public void setCapacity(String capacity) {
		this.capacity = capacity;
	}
	@Override
	public String toString() {
		return "Gpu [name=" + name + ", capacity=" + capacity + "]";
	}	
}
