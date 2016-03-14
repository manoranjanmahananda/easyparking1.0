/**
 * 
 */
package com.easyparking.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.easyparking.dto.ParkingLotDTO;
import com.easyparking.entity.CarParkingMapping;
import com.easyparking.entity.ParkingLot;
import com.easyparking.service.ParkingLotService;

/**
 * @author Manoranjan
 *
 */

@Controller
@RequestMapping("/parkingLot") 
public class ParkingLotController {
	
	@Autowired
	private ParkingLotService parkingLotService;
	
	@RequestMapping(value= "/addParkingLot" ,method=RequestMethod.POST,produces=MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody boolean  createParkingLot(ParkingLotDTO parkingLotDTO){
         
        boolean addParkingLotBoolean=false;
        try{
			if(parkingLotDTO != null){
				ParkingLot parkingLot=populateParkingLot(parkingLotDTO,null);
				 addParkingLotBoolean=parkingLotService.saveAndUpdateParkingLot(parkingLot);
				System.out.println("saveparkingLotBoolean is:"+addParkingLotBoolean);
			}
			
		}catch(Exception ex){
			ex.printStackTrace();
		}
         
        return addParkingLotBoolean;
    }
	
	@RequestMapping(value= "/getSummaryOfParking" ,method=RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody ParkingLotDTO  getSummaryOfParking(Integer parkingId){
		ParkingLotDTO parkingLotDTO=null;
        try{
			if(parkingId > 0){
				ParkingLot parkingLot=parkingLotService.getParkingLotById(parkingId);
				parkingLotDTO=populateParkingLot(parkingLot);
			}
			
		}catch(Exception ex){
			ex.printStackTrace();
		}
         
        return parkingLotDTO;
    }
	
	

	@RequestMapping(value= "/calculateParkingCharge" ,method=RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody String  calculateParkingCharge(int carParkingId){
		
		
		if(carParkingId > 0 ){
			ParkingLot parkingLot=parkingLotService.getParkingLotById(carParkingId);
			if(parkingLot != null){
				Date currentDate=new Date();
				if(parkingLot.getPickTime().after(currentDate) && parkingLot.getPickTimeEnd().before(currentDate) ){
					return parkingLot.getPickRate()+"";
				}else{
					return parkingLot.getRegularRate()+"";
				}
			}else{
				return "Parking details are not available for given parking ID";
			}
		}
		
        return 0+"";
    }
	
	
	public ParkingLotDTO populateParkingLot(ParkingLot parkingLot){
		if(parkingLot!=null){
			ParkingLotDTO parkingLotDTO=new ParkingLotDTO();
			parkingLotDTO.setAltitude(parkingLot.getAltitude());
			parkingLotDTO.setAvailableCount(parkingLot.getAvailableCount());
			parkingLotDTO.setCreatedAt(parkingLot.getCreatedAt());
			parkingLotDTO.setCreatedBy(parkingLot.getCreatedBy());
			parkingLotDTO.setLongitude(parkingLot.getLongitude());
			parkingLotDTO.setName(parkingLot.getName());
			parkingLotDTO.setOwnerId(parkingLot.getOwnerId());
			parkingLotDTO.setPickRate(parkingLot.getPickRate());
			parkingLotDTO.setPickTime(parkingLot.getPickTime());
			parkingLotDTO.setRegularRate(parkingLot.getRegularRate());
			parkingLotDTO.setStatus(parkingLot.getStatus());
			parkingLotDTO.setTotalCount(parkingLot.getTotalCount());
			parkingLotDTO.setUpdatedAt(parkingLot.getUpdatedAt());
			parkingLotDTO.setUpdatedBy(parkingLot.getUpdatedBy());
			return parkingLotDTO;
			
		}
		return null;
	}
	
	public ParkingLot populateParkingLot(ParkingLotDTO parkingLotDTO,ParkingLot parkingLot){
		if(parkingLot!=null && parkingLot.getId() > 0){
			if(parkingLotDTO.getAltitude() !=null){
				 parkingLot.setAltitude(parkingLotDTO.getAltitude());
			}
			
			if(parkingLotDTO.getAvailableCount() !=null){
				parkingLot.setAvailableCount(parkingLotDTO.getAvailableCount());
			}
			 
			// parkingLot.setCreatedAt(new Date());
			// parkingLot.setCreatedBy(parkingLotDTO.getCreatedBy());
			
			if(parkingLotDTO.getLongitude() !=null){
				parkingLot.setLongitude(parkingLotDTO.getLongitude());
			}
			 
			if(parkingLotDTO.getName() !=null){
				 parkingLot.setName(parkingLotDTO.getName());
			}
			
			if(parkingLotDTO.getOwnerId()!=null){
				parkingLot.setOwnerId(parkingLotDTO.getOwnerId());
			}
			 
			if(parkingLotDTO.getPickRate() !=null){
				parkingLot.setPickRate(parkingLotDTO.getPickRate());
			}
			 
			if(parkingLotDTO.getPickTime()!=null){
				parkingLot.setPickTime(parkingLotDTO.getPickTime());	
			}
			
			if(parkingLotDTO.getPickTimeEnd()!=null){
				parkingLot.setPickTimeEnd(parkingLotDTO.getPickTimeEnd());	
			}
			 if(parkingLotDTO.getRegularRate() !=null){
				 parkingLot.setRegularRate(parkingLotDTO.getRegularRate());
			 }
			 if(parkingLotDTO.getStatus() !=null){
				 parkingLot.setStatus( parkingLotDTO.getStatus());
			 }
			 
			 if(parkingLotDTO.getTotalCount() !=null){
				 parkingLot.setTotalCount(parkingLotDTO.getTotalCount()); 
			 }
			 
			 parkingLot.setUpdatedAt(new Date());
			 if(parkingLotDTO.getUpdatedBy() !=null){
				 parkingLot.setUpdatedBy(parkingLotDTO.getUpdatedBy());
			 }
			 
			return parkingLot;
		}else{
			 parkingLot=new ParkingLot();
			 parkingLot.setAltitude(parkingLotDTO.getAltitude());
			 parkingLot.setAvailableCount(parkingLotDTO.getAvailableCount());
			 parkingLot.setCreatedAt(new Date());
			 parkingLot.setCreatedBy(parkingLotDTO.getCreatedBy());
			 parkingLot.setLongitude(parkingLotDTO.getLongitude());
			 parkingLot.setName(parkingLotDTO.getName());
			 parkingLot.setOwnerId(parkingLotDTO.getOwnerId());
			 parkingLot.setPickRate(parkingLotDTO.getPickRate());
			 parkingLot.setPickTime(parkingLotDTO.getPickTime());
			 parkingLot.setRegularRate(parkingLotDTO.getRegularRate());
			 parkingLot.setStatus(1);
			 parkingLot.setTotalCount(parkingLotDTO.getTotalCount());
			 parkingLot.setUpdatedAt(new Date());
			 parkingLot.setUpdatedBy(parkingLotDTO.getUpdatedBy());
			 return parkingLot;
			 
		}
		
	}

}
