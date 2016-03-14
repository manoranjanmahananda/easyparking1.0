/**
 * 
 */
package com.easyparking.controller;

import java.util.Date;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.easyparking.booking.BookingForm;
import com.easyparking.entity.CarParkingMapping;
import com.easyparking.entity.UserCarMapping;
import com.easyparking.service.BookingService;
/**
 * @author Apple
 *
 */
@Controller
@RequestMapping("/booking")
public class BookingController {
	
	@Autowired
	private BookingService bookingService;
	
	@RequestMapping(method = RequestMethod.GET)
	 public String registerUser(Map<String, Object> model,HttpServletRequest req, HttpServletResponse res) {  
		
		//CarParkingMapping carParkingForm=new CarParkingMapping();
		BookingForm bookingForm=new BookingForm();
		
       String parkingId=(String)req.getParameter("pid");
       bookingForm.setParkingId(parkingId);
       
       model.put("bookingForm", bookingForm);
       return "carParkingForm";
   }
	
	@RequestMapping(method = RequestMethod.POST)
    public String processRegistration(@ModelAttribute("bookingForm") BookingForm bookingForm,
            Map<String, Object> model) {
		try{
			
			
			   UserCarMapping userCarParking=new UserCarMapping();
		       userCarParking.setCarId(1);//get from carid
		       userCarParking.setCreatedAt(new Date());
		       userCarParking.setCreatedBy("system");//get user name from session
		       userCarParking.setMessage("I love this!!!");
		       userCarParking.setUpdatedAt(new Date());
		       userCarParking.setUserId(1);//set the userid get from session
		       
		       
		       CarParkingMapping carParkingMapping=new CarParkingMapping();
		       carParkingMapping.setCarId(1);//get from carid
		       carParkingMapping.setMessage("I love this!!!");
		       if(bookingForm.getParkingId() != null){
		    	   carParkingMapping.setParkingId(Integer.parseInt(bookingForm.getParkingId()));
		       }
		       if(bookingForm.getTimeIn() !=null){
		    	   carParkingMapping.setTimeIn(bookingForm.getTimeIn());
		       }
		      if(bookingForm.getTimeOut() !=null){
		    	  carParkingMapping.setTimeOut(bookingForm.getTimeOut());
		      }
		       
		       
		       bookingService.bookCar(userCarParking, carParkingMapping);
			/*if(user != null){
				user.setCreatedAt(new Date());
				user.setCreatedBy(user.getEmail());
				user.setUpdatedAt(new Date());
				user.setUpdatedBy(user.getEmail());
				registerationService.registerUser(user);
			}
			System.out.println("userEmail: " + user.getEmail());
			System.out.println("username: " + user.getName());
			System.out.println("Mobile: " + user.getMobileNo());*/
	        return "paymentGateWay";
		}catch(Exception ex){
			model.put("error", "Some error occured,plz try your administrator!!!!");
			ex.printStackTrace();
		}
		return "carParkingForm";
    }

}
