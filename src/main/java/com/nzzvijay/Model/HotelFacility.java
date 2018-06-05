package com.nzzvijay.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@Entity
public class HotelFacility {

	@javax.persistence.Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	int Id;
	String facilities;
	Boolean available;
	

	
	public int getId() {
		return Id;
	}



	public void setId(int id) {
		Id = id;
	}



	public HotelFacility() {
		
	}
	
	
	
	public HotelFacility(String facilities, Boolean available) {
		super();
		this.facilities = facilities;
		this.available = available;
	}
	public String getFacilities() {
		return facilities;
	}
	public void setFacilities(String facilities) {
		this.facilities = facilities;
	}
	public Boolean getAvailable() {
		return available;
	}
	public void setAvailable(Boolean available) {
		this.available = available;
	}
	
	
 	
}
