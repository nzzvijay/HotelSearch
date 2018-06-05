package com.nzzvijay.hotelsearch;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nzzvijay.Model.Hotel;
import com.nzzvijay.Model.HotelFacility;

@Service
public class HotelServices {

	public HotelServices() {
		
	}
	
	@Autowired
	HotelSearchRepository hotelresult;
	
	@Autowired
	HotelFacilityRepo facilityresult;
	

	
	public ArrayList<Hotel> getall(){
		return (ArrayList<Hotel>) hotelresult.findAll();
	}
	
	public ArrayList<Hotel> findbycity(String city){
		return (ArrayList<Hotel>) hotelresult.findByCity(city);
	}
	
	/*public ArrayList<Hotel> findbycityandrating(String city,Float rating){
		return (ArrayList<Hotel>) hotelresult.findByCityLikeAndOverallratingGreaterThan(city,rating);
	}*/
	
	public ArrayList<Hotel> findbyfacilities(String facilities){
		return (ArrayList<Hotel>) hotelresult.findByHotelFacilityFacilities(facilities);
	}
	
	
	public void inserthotel(ArrayList<Hotel> hotel){
		hotelresult.saveAll(hotel);
	}
	
	public void addhotel(Hotel hotel) {
		hotelresult.save(hotel);
	}

	public Hotel findOne(int id) {
		// TODO Auto-generated method stub
		return hotelresult.findAllById(id);
	}

	public void deletehotel(Integer id) {
		// TODO Auto-generated method stub
		hotelresult.deleteById(id);
	}

	public ArrayList<Hotel> findbycityandratingandcost(String city, float rating, String startcost, String endcost) {
		// TODO Auto-generated method stub
		return (ArrayList<Hotel>) hotelresult.findByCityLikeAndOverallratingGreaterThanAndCostGreaterThanEqualAndCostLessThanEqual(city,rating,(Integer.parseInt(startcost)),(Integer.parseInt(endcost)));
	}

	public ArrayList<Hotel> findbycityandratingandcostandtravellers(String city, float rating, String startcost,
			String endcost, String nooftravellers) {
		// TODO Auto-generated method stub
		return (ArrayList<Hotel>) hotelresult.findByCityLikeAndOverallratingGreaterThanAndCostGreaterThanEqualAndCostLessThanEqualAndRoomavailableGreaterThanEqual(city,rating,(Integer.parseInt(startcost)),(Integer.parseInt(endcost)),(Integer.parseInt(nooftravellers)));
	}

	
}
