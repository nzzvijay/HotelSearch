package com.nzzvijay.hotelsearch;

import java.util.ArrayList;

import org.springframework.data.repository.CrudRepository;

import com.nzzvijay.Model.Hotel;
import com.nzzvijay.Model.HotelFacility;

public interface HotelSearchRepository extends CrudRepository<Hotel, Integer> {
	
	public ArrayList<Hotel> findByCity(String city);
	public ArrayList<Hotel> findByHotelFacilityFacilities(String facilities);
	public Hotel findAllById(int id);
	public ArrayList<Hotel> findByCityLikeAndOverallratingGreaterThanAndCostGreaterThanEqualAndCostLessThanEqual(String city, Float rating,int startcost,int endcost);
	public ArrayList<Hotel> findByCityLikeAndOverallratingGreaterThanAndCostGreaterThanEqualAndCostLessThanEqualAndRoomavailableGreaterThanEqual(
			String city, float rating, int i, int j, int k);

}
