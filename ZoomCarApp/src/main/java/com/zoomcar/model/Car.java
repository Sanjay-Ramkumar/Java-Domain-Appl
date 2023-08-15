package com.zoomcar.model;

public class Car {
	private int carId;
	private String registerNo;
	private String model;
	private String brand;
	private double price;
	private String type;
	public Car() {
		super();
	}
	public Car(int carId, String registerNo, String brand, String model, double price, String type) {
		super();
		this.carId = carId;
		this.registerNo = registerNo;
		this.model = model;
		this.brand = brand;
		this.price = price;
		this.type = type;
	}
	public int getCarId() {
		return carId;
	}
	public void setCarId(int carId) {
		this.carId = carId;
	}
	public String getRegisterNo() {
		return registerNo;
	}
	public void setRegisterNo(String registerNo) {
		this.registerNo = registerNo;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	@Override
	public String toString() {
		return "Car [carId=" + carId + ", registerNo=" + registerNo + ", model=" + model + ", brand=" + brand
				+ ", price=" + price + ", type=" + type + "]";
	}
	
	
}
