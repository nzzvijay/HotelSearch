package com.nzzvijay.hotelsearch;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.nzzvijay.Model.Hotel;
import com.nzzvijay.Model.HotelFacility;
import com.nzzvijay.Model.User;
import com.nzzvijay.Model.UserComment;

import net.minidev.json.JSONArray;

@RestController
public class SearchController {
		
	@Autowired
	HotelServices hotelservice;
	
	@Autowired
	FacilityServices facilityservice;
	
	@Autowired
	UserServices userservice;
	
	@Autowired
	UserCommentServices usercommentservice;

	@RequestMapping("/searchhotel")
	public ArrayList<Hotel> getResult() {
		
		return hotelservice.getall();
	}
	
	@RequestMapping("/getuser")
	public ArrayList<User> getUserResult() {
		
		return userservice.findUser();
	}
	
	@RequestMapping("/getuser/{username}")
	public User getUserResult(@PathVariable String username) {
		
		return userservice.findOneUser(username);
	}
	
	@RequestMapping(method=RequestMethod.POST,value="/adduser")
	public void addUser(@RequestBody User user) {
		userservice.adduser(user);
	
	}
	
	@RequestMapping(method=RequestMethod.DELETE,value="/deleteuser")
	public void addUser(@RequestBody String id) {
		userservice.deleteuser(id);
	
	}
	
	@RequestMapping("/getcomment")
	public ArrayList<UserComment> getUsercomment() {
		
		return usercommentservice.getcomment();
	}
	
	@RequestMapping(method=RequestMethod.POST,value="hotel/{id}/{username}/addcomment")
	public String addcomment(@RequestBody UserComment usercomment,@PathVariable String username,@PathVariable int id) {
		Hotel hotel=hotelservice.findOne(id);
				
		User user1=(User)userservice.finduser(username);
		usercomment.setUser(user1);
		hotel.getUsercomment().add(usercomment);
		usercommentservice.addcomment(usercomment);
		
		List<UserComment> usercomment1=new ArrayList<>();
		hotel.getUsercomment().forEach(usercomment1::add);
		
		float overallrate=0;
		
		for(int i=0;i<usercomment1.size();i++) {
			System.out.println(usercomment1.get(i).getRating());
			overallrate=overallrate+usercomment1.get(i).getRating();
		}
		
		overallrate=overallrate/usercomment1.size();
		hotel.setOverallrating(overallrate);
		
		hotelservice.addhotel(hotel);
		return "success";
	}
		
	
	@RequestMapping(method=RequestMethod.POST,value="/addhotel")
	public void addResult(@RequestBody Hotel hotel) {
		
		hotelservice.addhotel(hotel);
	
	}
	
	@RequestMapping(method=RequestMethod.DELETE,value="/deletehotel")
	public void addResult(@RequestBody int id) {
		
		hotelservice.deletehotel(id);
	
	}
	
	@RequestMapping("/searchhotel/{id}")
	public Hotel getResultById(@PathVariable int id) {
		return hotelservice.findOne(id);
	}
	
	@RequestMapping("/searchhotel/query")
	public ArrayList<Hotel> getResultByCity(@RequestParam String city,
										    @RequestParam float rating,
										    @RequestParam String startcost,
										    @RequestParam String endcost,
										    @RequestParam String nooftravellers) {
		if(city.equals("")) {
			city="%%";
			System.out.println("null city");
		}
		rating=rating-1;
		
		if(startcost.equals("")) {
			startcost="0";
		}
		if(endcost.equals("")) {
			endcost="9999999";
		}
		if(nooftravellers.equals("")) {
			nooftravellers="0";
		}
		
		
		return hotelservice.findbycityandratingandcostandtravellers(city, rating,startcost,endcost,nooftravellers);
	}
	
	@RequestMapping("/searchhotel/facilities/{facilities}")
	public ArrayList<Hotel> getResultByfacilities(@PathVariable String facilities) {
		
		return hotelservice.findbyfacilities(facilities);
	}
	
	/*@RequestMapping("/save")
	public String savemethod() {
		User newuser=new User("nzzvijay", "vijay", "male", "25");
		userservice.adduser(newuser);
		
		Collection<UserComment> usercomment=new ArrayList<>();
		usercomment.add(new UserComment("Fabulous Staying here.",7,newuser));
		usercommentservice.addcomment(usercomment);
		
		
		ArrayList<Hotel> hotel=new ArrayList<Hotel>();
		Collection<HotelFacility> hotelfac1=new ArrayList<>();
		Collection<HotelFacility> hotelfac2=new ArrayList<>();
		Collection<HotelFacility> hotelfac3=new ArrayList<>();
		Collection<HotelFacility> hotelfac4=new ArrayList<>();
		Collection<HotelFacility> hotelfac5=new ArrayList<>();
		Collection<HotelFacility> hotelfac6=new ArrayList<>();
		Collection<HotelFacility> hotelfac7=new ArrayList<>();
		Collection<HotelFacility> hotelfac8=new ArrayList<>();
		Collection<HotelFacility> hotelfac9=new ArrayList<>();
		
		hotelfac1.add(new HotelFacility("Bathroom", true));
		hotelfac1.add(new HotelFacility("Free Wifi", true));
		
		hotelfac2.add(new HotelFacility("Bathroom", true));
		hotelfac2.add(new HotelFacility("Free Wifi", true));
		
		hotelfac3.add(new HotelFacility("Bathroom", true));
		hotelfac3.add(new HotelFacility("Free Wifi", true));
		
		hotelfac4.add(new HotelFacility("Bathroom", true));
		hotelfac4.add(new HotelFacility("Free Wifi", true));
		
		hotelfac5.add(new HotelFacility("Bathroom", true));
		hotelfac5.add(new HotelFacility("Free Wifi", true));
		
		hotelfac6.add(new HotelFacility("Bathroom", true));
		hotelfac6.add(new HotelFacility("Free Wifi", true));
		
		hotelfac7.add(new HotelFacility("Bathroom", true));
		hotelfac7.add(new HotelFacility("Free Wifi", true));
		
		hotelfac8.add(new HotelFacility("Bathroom", true));
		hotelfac8.add(new HotelFacility("Free Wifi", true));
		
		hotelfac9.add(new HotelFacility("Bathroom", true));
		hotelfac9.add(new HotelFacility("Free Wifi", true));
		
		facilityservice.insertfacility(hotelfac1);
		facilityservice.insertfacility(hotelfac2);
		facilityservice.insertfacility(hotelfac3);
		facilityservice.insertfacility(hotelfac4);
		facilityservice.insertfacility(hotelfac5);
		facilityservice.insertfacility(hotelfac6);
		facilityservice.insertfacility(hotelfac7);
		facilityservice.insertfacility(hotelfac8);
		facilityservice.insertfacility(hotelfac9);
				
		hotel.add(new Hotel("Sujata","Maharashtra","Pune","https://t-ec.bstatic.com/images/hotel/max1024x768/101/101430248.jpg",7,2000,hotelfac1,usercomment));
		hotel.add(new Hotel("Sujata","Maharashtra","Mulshi","https://t-ec.bstatic.com/images/hotel/max1024x768/101/101430248.jpg",0,1500,hotelfac2));
		hotel.add(new Hotel("Sujata","Maharashtra","Pune","https://t-ec.bstatic.com/images/hotel/max1024x768/101/101430248.jpg",0,3000,hotelfac3));
		hotel.add(new Hotel("Sujata","Maharashtra","Mulshi","https://t-ec.bstatic.com/images/hotel/max1024x768/101/101430248.jpg",0,4000,hotelfac4));
		hotel.add(new Hotel("Sujata","Maharashtra","Pune","https://t-ec.bstatic.com/images/hotel/max1024x768/101/101430248.jpg",0,5000,hotelfac5));
		hotel.add(new Hotel("Sujata","Maharashtra","Mumbai","https://t-ec.bstatic.com/images/hotel/max1024x768/101/101430248.jpg",0,850,hotelfac6));
		hotel.add(new Hotel("Sujata","Maharashtra","Mumbai","https://t-ec.bstatic.com/images/hotel/max1024x768/101/101430248.jpg",0,999,hotelfac7));
		hotel.add(new Hotel("Sujata","Maharashtra","Pune","https://t-ec.bstatic.com/images/hotel/max1024x768/101/101430248.jpg",0,1000,hotelfac8));
		hotel.add(new Hotel("Sujata","Maharashtra","Pune","https://t-ec.bstatic.com/images/hotel/max1024x768/101/101430248.jpg",0,7500,hotelfac9));
		
		hotelservice.inserthotel(hotel);
		return "done";
	}*/
	
}
