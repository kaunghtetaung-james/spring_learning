package org.kaunghtetaung.springcore.model;

public class Storage {
	String type; //SSD, HDD or ...
	String capacity; //4GB, 8GB or ...
	
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getCapacity() {
		return capacity;
	}
	public void setCapacity(String capacity) {
		this.capacity = capacity;
	}
	@Override
	public String toString() {
		return "Storage [type=" + type + ", capacity=" + capacity + "]";
	}
}
