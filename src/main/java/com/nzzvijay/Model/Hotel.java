package com.nzzvijay.Model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import org.springframework.beans.factory.annotation.Autowired;

@Entity
public class Hotel {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	int id;
	String name;
	String state;
	String city;
	String hotelimage;
	float overallrating;
	int cost;
	int roomavailable;
	
	public int getRoomavailable() {
		return roomavailable;
	}

	public void setRoomavailable(int roomavailable) {
		this.roomavailable = roomavailable;
	}

	public int getCost() {
		return cost;
	}

	public void setCost(int cost) {
		this.cost = cost;
	}

	public float getOverallrating() {
		return overallrating;
	}

	public void setOverallrating(float overallrating) {
		this.overallrating = overallrating;
	}

	@OneToMany(cascade = {CascadeType.ALL})
	Collection<HotelFacility> hotelFacility;
	
	@OneToMany(cascade = {CascadeType.ALL})
	Collection<UserComment> usercomment;
	
	

	public Hotel(String name, String state, String city, String hotelimage,float overallrating,int cost,
			Collection<HotelFacility> hotelFacility, Collection<UserComment> usercomment) {
		super();
		this.name = name;
		this.state = state;
		this.city = city;
		this.hotelimage = hotelimage;
		this.hotelFacility = hotelFacility;
		this.overallrating=overallrating;
		this.cost=cost;
		this.usercomment = usercomment;
	}

	public Collection<UserComment> getUsercomment() {
		return usercomment;
	}

	public void setUsercomment(Collection<UserComment> usercomment) {
		this.usercomment = usercomment;
	}

	public Collection<HotelFacility> getHotelFacility() {
		return hotelFacility;
	}

	public void setHotelFacility(Collection<HotelFacility> hotelFacility) {
		this.hotelFacility = hotelFacility;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public Hotel() {
		
	}

	
	
	public Hotel(String name, String state, String city, String hotelimage,float overallrating,int cost,Collection<HotelFacility> hotelfacility) {
		super();
		this.name = name;
		this.state = state;
		this.city = city;
		this.hotelimage = hotelimage;
		this.overallrating=overallrating;
		this.cost=cost;
		this.hotelFacility = hotelfacility;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}



	public String getHotelimage() {
		return hotelimage;
	}

	public void setHotelimage(String hotelimage) {
		this.hotelimage = hotelimage;
	}

	
}
