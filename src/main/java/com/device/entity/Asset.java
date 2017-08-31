package com.device.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.sql.Date;
import java.sql.Timestamp;

@Entity
@Table(name="asset")
public class Asset {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id")
    private Integer assetId;  
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="userid",referencedColumnName="id")
	private User user;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="typeid",referencedColumnName="id")
	private Type type;
		
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="statusid",referencedColumnName="id")
	private Status status;
	
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Type getType() {
		return type;
	}

	public void setType(Type type) {
		this.type = type;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	@Column(name="hostname")
	private String hostName;
	
	@Column(name="inventorynumber")
	private String inventoryNumber;
	
	@Column(name="producer")
	private String producer;
	
	@Column(name="model")
	private String model;
	
	@Column(name="serialnumber")
	private String serialNumber;
	
	@Column(name="origin")
	private String origin;
	
	@Column(name="purchasedate")
	private Date purchaseDate;
	
	@Column(name="expiredate")
	private Date expireDate;
	
	@Column(name="remembrance")
    private int remembrance;
	
	@Column(name="reminderdate")
	private Timestamp reminderDate;
	
	@Column(name="scrapped")
	private int scrapped;
	
	@Column(name="scrappedon")
	private Timestamp scrappedOn;
	
	@Column(name="archived")
	private int archived;
	
	@Column(name="comments")
	private String comments;
	
	@Column(name="createdby")
	private int createdBy;
	
	@Column(name="changedby")
	private int changedBy;
	
	@Column(name="createdon")
	private Timestamp createdOn;
	
	@Column(name="changedOn")
	private Timestamp changedOn;
	
	@Column(name="workflowid")
	private int workflowID;
	
	public int getRemembrance() {
		return remembrance;
	}

	public void setRemembrance(int remembrance) {
		this.remembrance = remembrance;
	}

	public Timestamp getReminderDate() {
		return reminderDate;
	}

	public void setReminderDate(Timestamp reminderDate) {
		this.reminderDate = reminderDate;
	}

	public int getScrapped() {
		return scrapped;
	}

	public void setScrapped(int scrapped) {
		this.scrapped = scrapped;
	}

	public Timestamp getScrappedOn() {
		return scrappedOn;
	}

	public void setScrappedOn(Timestamp scrappedOn) {
		this.scrappedOn = scrappedOn;
	}

	public int getArchived() {
		return archived;
	}

	public void setArchived(int archived) {
		this.archived = archived;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	public int getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(int createdBy) {
		this.createdBy = createdBy;
	}

	public int getChangedBy() {
		return changedBy;
	}

	public void setChangedBy(int changedBy) {
		this.changedBy = changedBy;
	}

	public Timestamp getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(Timestamp createdOn) {
		this.createdOn = createdOn;
	}

	public Timestamp getChangedOn() {
		return changedOn;
	}

	public void setChangedOn(Timestamp changedOn) {
		this.changedOn = changedOn;
	}

	public int getWorkflowID() {
		return workflowID;
	}

	public void setWorkflowID(int workflowID) {
		this.workflowID = workflowID;
	}

	public void setAssetId(Integer assetId) {
		this.assetId = assetId;
	}

	public int getAssetId() {
		return assetId;
	}

	public void setAssetId(int assetId) {
		this.assetId = assetId;
	}

	public String getHostName() {
		return hostName;
	}

	public void setHostName(String hostName) {
		this.hostName = hostName;
	}

	public String getInventoryNumber() {
		return inventoryNumber;
	}

	public void setInventoryNumber(String inventoryNumber) {
		this.inventoryNumber = inventoryNumber;
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

	public String getSerialNumber() {
		return serialNumber;
	}

	public void setSerialNumber(String serialNumber) {
		this.serialNumber = serialNumber;
	}

	public String getOrigin() {
		return origin;
	}

	public void setOrigin(String origin) {
		this.origin = origin;
	}

	public Date getPurchaseDate() {
		return purchaseDate;
	}

	public void setPurchaseDate(Date purchaseDate) {
		this.purchaseDate = purchaseDate;
	}

	public Date getExpireDate() {
		return expireDate;
	}

	public void setExpireDate(Date expireDate) {
		this.expireDate = expireDate;
	}
	

}
