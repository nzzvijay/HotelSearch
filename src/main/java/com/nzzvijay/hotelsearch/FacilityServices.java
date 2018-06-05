package com.nzzvijay.hotelsearch;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nzzvijay.Model.HotelFacility;

@Service
public class FacilityServices {
	
	@Autowired
	HotelFacilityRepo facilityservices;
	
	

	public FacilityServices() {
		super();
		// TODO Auto-generated constructor stub
	}



	public void insertfacility(Collection<HotelFacility> hotelfacility) {
		facilityservices.saveAll(hotelfacility);
	}
}
