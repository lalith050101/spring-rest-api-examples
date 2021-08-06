package com.example.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Car {

	@Id
	private Long carId;
	private String carModel;
	private String carNo;
	private String status;
	
	public Car() {
		
	}
	
	public Car(Long carId, String carModel, String carNo, String status) {
		super();
		this.carId = carId;
		this.carModel = carModel;
		this.carNo = carNo;
		this.status = status;
	}
	
	public Long getCarId() {
		return carId;
	}
	public void setCarId(Long carId) {
		this.carId = carId;
	}
	public String getCarModel() {
		return carModel;
	}
	public void setCarModel(String carModel) {
		this.carModel = carModel;
	}
	public String getCarNo() {
		return carNo;
	}
	public void setCarNo(String carNo) {
		this.carNo = carNo;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	
	
}
