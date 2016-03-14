/**
 * 
 */
package com.easyparking.controller;

import java.util.Date;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.easyparking.dto.UserDTO;
import com.easyparking.entity.CarInfo;
import com.easyparking.entity.User;
import com.easyparking.service.RegisterationService;

/**
 * @author Apple
 *
 */
@Controller
@RequestMapping("/register") 
public class RegisterController {
	
	@Autowired
	public  RegisterationService registerationService;
	
	@RequestMapping(method = RequestMethod.GET)
	 public String registerUser(Map<String, Object> model) {  
		UserDTO userForm=new UserDTO();
		model.put("userForm", userForm);
        return "userRegisteration";
    }
	@RequestMapping(method = RequestMethod.POST)
    public String processRegistration(@ModelAttribute("userForm") UserDTO userDTO,
            Map<String, Object> model) {
		try{
			boolean registerationBoolean=false;
			if(userDTO != null){
				User user=populateUser(userDTO);
				CarInfo carInfo=populateCarInfo(userDTO);
				registerationBoolean=registerationService.registerUserInfo(user,carInfo);
				System.out.println("registerationBoolean is:"+registerationBoolean);
			}
			if(registerationBoolean)
				return "registrationSuccess";
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return "userRegisteration";
    }
	
	
	
	
	public User populateUser(UserDTO userDTO){
		
		if(userDTO != null){
			User user=new User();
			user.setCreatedAt(new Date());
			user.setCreatedBy(user.getName());
			user.setUpdatedAt(new Date());
			user.setUpdatedBy(user.getName());
			user.setEmail(userDTO.getEmail());
			user.setMobileNo(userDTO.getMobileNo());
			user.setName(userDTO.getName());
			return user;
		}else return null;
		
		//return null;
		
	}
	
public CarInfo populateCarInfo(UserDTO userDTO){
		
		if(userDTO != null){
			CarInfo carInfo=new CarInfo();
			if(userDTO.getEmail() != null){
				carInfo.setUpdatedBy(userDTO.getName());
				carInfo.setCreatedBy(userDTO.getName());
			}
			carInfo.setCreatedAt(new Date());
			carInfo.setUpdatedAt(new Date());
			if(userDTO.getCarNo() != null){
				carInfo.setCarNo(userDTO.getCarNo());
			}
			
			return carInfo;
		}else return null;
		
		//return null;
		
	}
	
}
