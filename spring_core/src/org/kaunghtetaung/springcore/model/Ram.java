package org.kaunghtetaung.springcore.model;

public class Ram {
	String type; //DDR3, DDR4 or ...
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
		return "Ram [type=" + type + ", capacity=" + capacity + "]";
	}		
}
