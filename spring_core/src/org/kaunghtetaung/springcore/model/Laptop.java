package org.kaunghtetaung.springcore.model;

public class Laptop {
	private String name;
	private double price;
	private String brand;
	
	private Cpu cpu;
	private Gpu gpu;
	private Ram ram;
	private Storage storage;
	
	//getters and setters
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public Cpu getCpu() {
		return cpu;
	}
	public void setCpu(Cpu cpu) {
		this.cpu = cpu;
	}
	public Gpu getGpu() {
		return gpu;
	}
	public void setGpu(Gpu gpu) {
		this.gpu = gpu;
	}
	public Ram getRam() {
		return ram;
	}
	public void setRam(Ram ram) {
		this.ram = ram;
	}
	public Storage getStorage() {
		return storage;
	}
	public void setStorage(Storage storage) {
		this.storage = storage;
	}
	@Override
	public String toString() {
		return "Laptop [name=" + name + ", price=" + price + ", brand=" + brand + ", cpu=" + cpu + ", gpu=" + gpu
				+ ", ram=" + ram + ", storage=" + storage + "]";
	}	
}
