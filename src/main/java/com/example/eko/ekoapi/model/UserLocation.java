package com.example.eko.ekoapi.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;

@Entity
public class UserLocation {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	public Integer id;
	
	// This will be Foreign Key
	public Integer locationUserId;
	
	public String locationLat;
	public String locationLng;
	public Date	  locationSavedTime;
	public Date   createdDate;
	
	public Integer getId() {
		return this.id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	public Integer getLocationUserId() {
		return this.locationUserId;
	}
	
	public void setLocationUserId(Integer locationUserId) {
		this.locationUserId = locationUserId;
	}
	
	public String getlocationLat() {
		return this.locationLat;
	}
	
	public void setLocationLat(String locationLat) {
		this.locationLat = locationLat;
	}
	
	public String getlocationLng() {
		return this.locationLng;
	}
	
	public void setLocationLng(String locationLng) {
		this.locationLng = locationLng;
	}
		
	
	public Date getLocationSavedDate() {
		return this.locationSavedTime;
	}
	
	public void setLocationSavedDate(Date locationSavedTime) {
		this.locationSavedTime = locationSavedTime;
	}
	
	public Date getCreatedDate() {
		return this.createdDate;
	}
	
	public void setCreatedDate(Date createDate) {
		this.createdDate = createDate;
	}
	
	@PrePersist
	public void onCreate() {
		this.createdDate = new Date();
	}
	
}
