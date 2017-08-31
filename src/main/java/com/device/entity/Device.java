package com.device.entity;
import java.io.Serializable;

public class Device implements Serializable { 
	private static final long serialVersionUID = 1L;
	
    private String inventoryNr;
	
	private String userName;
	
	private String producer;
	
	private String model;

	private String seriesNr;
		
	private String origin;  

	private String dateOfPurchase;

	private String type;
		
	private String status;
	
	public String getInventoryNr() {
		return inventoryNr;
	}
	
	public void setInventoryNr(String inventoryNr) {
		this.inventoryNr = inventoryNr;
	}
	
	public String getUserName() {
		return userName;
	}
	
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	public String getProducer() {
		return producer;
	}
	
	public void setProducer(String producer) {
		this.producer = producer;
	}
	   
	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getSeriesNr() {
		return seriesNr;
	}

	public void setSeriesNr(String seriesNr) {
		this.seriesNr = seriesNr;
	}

	public String getOrigin() {
		return origin;
	}

	public void setOrigin(String origin) {
		this.origin = origin;
	}

	public String getDateOfPurchase() {
		return dateOfPurchase;
	}

	public void setDateOfPurchase(String dateOfPurchase) {
		this.dateOfPurchase = dateOfPurchase;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	

	
	  
	
} 