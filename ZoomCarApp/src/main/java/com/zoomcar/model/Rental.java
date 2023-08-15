package com.zoomcar.model;

import java.util.Date;

public class Rental {
	private int custId;
	private int carID;
	private String startDate;
	private String endDate;
	private int phone;
	public Rental() {
		super();
	}
	public Rental(int custId, int carID, String startDate, String endDate, int phone) {
		super();
		this.custId = custId;
		this.carID = carID;
		this.startDate = startDate;
		this.endDate = endDate;
		this.phone = phone;
	}
	public int getCustId() {
		return custId;
	}
	public void setCustId(int custId) {
		this.custId = custId;
	}
	public int getCarID() {
		return carID;
	}
	public void setCarID(int carID) {
		this.carID = carID;
	}
	public String getStartDate() {
		return startDate;
	}
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}
	public String getEndDate() {
		return endDate;
	}
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
	public int getPhone() {
		return phone;
	}
	public void setPhone(int phone) {
		this.phone = phone;
	}
	@Override
	public String toString() {
		return "Rental [custId=" + custId + ", carID=" + carID + ", startDate=" + startDate + ", endDate=" + endDate
				+ ", phone=" + phone + "]";
	}
	
	
	
	
	
}
