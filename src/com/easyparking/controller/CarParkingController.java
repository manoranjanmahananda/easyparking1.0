package com.easyparking.controller;

import java.sql.Timestamp;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.easyparking.dto.UserDTO;
import com.easyparking.entity.CarInfo;
import com.easyparking.entity.CarParkingMapping;
import com.easyparking.entity.ParkingLot;
import com.easyparking.entity.User;
import com.easyparking.service.CarInfoService;
import com.easyparking.service.CarParkingMappingService;
import com.easyparking.service.ParkingLotService;
import com.easyparking.service.UserService;

@Controller
public class CarParkingController {
	
	@Autowired
	private UserService userService;
	@Autowired
	private CarInfoService carInfoService;
	@Autowired
	private ParkingLotService parkingLotService;
	@Autowired
	private CarParkingMappingService carParkingMappingService;

	@RequestMapping(value= "/getListOfNearByParkingLocation" ,method=RequestMethod.POST,produces=MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody UserDTO  getListOfNearByParkingLocation(String  emailId){
		/*UserDTO userDTO=null;
		try{
			if(emailId != null){
				User user=userService.getUserDetailsByEmail(emailId);
				if(user != null){
					CarInfo carinfo=carInfoService.getCarInfoByUserId(user.getId());
					userDTO=populateUserDTO(user,carinfo);
				}
			}
			
		}catch(Exception ex){
			ex.printStackTrace();
		}*/
         
        return null;
    }
	
	@RequestMapping(value= "/checkInParking" ,method=RequestMethod.POST,produces=MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody boolean  checkInParking(int parkingId, int carId, Timestamp checkInTime,int userId){
		User user=null;
		CarInfo carInfo=null;
		ParkingLot parkingLot=null;
		boolean carParkingBoolean=false;
		CarParkingMapping carParkingMapping=null;
		if(parkingId > 0 ){
			parkingLot=parkingLotService.getParkingLotById(parkingId);
		}
		if(userId > 0){
			 user=userService.getUserDetailsByUserId(userId);
			 carInfo=carInfoService.getCarInfoByUserId(userId);
			 if(user != null){
				 if(carInfo.getUserId()!=user.getId()){
					 carInfo.setUserId(user.getId()); 
					 carInfo.setUpdatedAt(new Date());
					 carInfo.setUpdatedBy(user.getName());
					 carInfoService.saveAndUpdateCarInfo(carInfo);
				 }
				 carParkingMapping= populateCarParkingMapping(carId,parkingId,new Timestamp(new Date().getTime()),null,null);
				 carParkingBoolean=carParkingMappingService.saveAndUpdateCarParkingMapping(carParkingMapping);
				 
			 }
		}
		
         
        return carParkingBoolean;
    }
	
	
	
	@RequestMapping(value= "/checkOutParking" ,method=RequestMethod.POST,produces=MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody String  checkOutParking(int carParkingMappingId){
		String carParkingBoolean="false";
		
		if(carParkingMappingId > 0 ){
			CarParkingMapping carParkingMapping=carParkingMappingService.getCarParkingMapping(carParkingMappingId);
			if(carParkingMapping != null){
				carParkingMapping.setTimeOut(new Date());
				carParkingMapping.setUpdatedAt(new Date());
				carParkingMappingService.saveAndUpdateCarParkingMapping(carParkingMapping);
				return "true";
			}else{
				return "car parking does not exist for id: "+carParkingMappingId;
			}
		}
		
        return carParkingBoolean;
    }
	
	
	public CarParkingMapping populateCarParkingMapping(int carId,int parkingId,Timestamp timeIn,String bookingId,String paymentId){
		CarParkingMapping carParkingMapping=new CarParkingMapping();
		carParkingMapping.setCarId(carId);
		carParkingMapping.setParkingId(parkingId);
		carParkingMapping.setTimeIn(timeIn);
		carParkingMapping.setBookingId(bookingId);
		carParkingMapping.setPaymentId(paymentId);
		carParkingMapping.setStatus(1);
		return carParkingMapping;
		
	}
}
