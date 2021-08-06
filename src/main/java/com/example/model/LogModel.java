package com.example.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class LogModel {

	@Id
	private String Id;
	private String name;
	private String logType;
	private String date;
	private String time;
	
	public LogModel() {
		
	}
	
	public LogModel(String id, String name, String logType, String date, String time) {
		super();
		Id = id;
		this.name = name;
		this.logType = logType;
		this.date = date;
		this.time = time;
	}
	public String getId() {
		return Id;
	}
	public void setId(String id) {
		Id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLogType() {
		return logType;
	}
	public void setLogType(String logType) {
		this.logType = logType;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	
	
}
