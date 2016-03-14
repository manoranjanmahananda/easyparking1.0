/**
 * 
 */
package com.easyparking.controller;

import java.util.Date;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.easyparking.dto.UserDTO;
import com.easyparking.entity.CarInfo;
import com.easyparking.entity.User;
import com.easyparking.service.CarInfoService;
import com.easyparking.service.RegisterationService;
import com.easyparking.service.UserService;

/**
 * @author Manoranjan
 * This class contain all the method related to users.
 */

@Controller
@RequestMapping("/user") 
public class UserController {
	
	@Autowired
	public  RegisterationService registerationService;
	
	@Autowired
	public CarInfoService carInfoService;
	
	@Autowired
	public UserService userService;
	@RequestMapping(value= "/createUserDetails" ,method=RequestMethod.POST,produces=MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody boolean  createUserDetails(UserDTO userDTO){
         
        System.out.println("Received order from :"+userDTO.getEmail());
        System.out.println("Order worth: "+userDTO.getMobileNo());
        System.out.println("Customer address: "+userDTO.getEmail());
        boolean registerationBoolean=false;
        try{
			if(userDTO != null){
				User user=populateUser(userDTO,null);
				CarInfo carInfo=populateCarInfo(userDTO);
				registerationBoolean=registerationService.registerUserInfo(user,carInfo);
				System.out.println("registerationBoolean is:"+registerationBoolean);
			}
			
		}catch(Exception ex){
			ex.printStackTrace();
		}
         
        return registerationBoolean;
    }
	
	

	@RequestMapping(value= "/getUserDetails" ,method=RequestMethod.POST,produces=MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody UserDTO  getUserDetails(String  emailId){
		UserDTO userDTO=null;
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
		}
         
        return userDTO;
    }
	
	public @ResponseBody boolean updateUserDetails(UserDTO userDTO){
		if(userDTO !=null && userDTO.getUserId() !=0){
			User user=userService.getUserDetailsByUserId(userDTO.getUserId());
			if(user!=null){
				user=populateUser(userDTO,user);
				boolean userSaveBoolean=userService.saveAndUpdate(user);
				return userSaveBoolean;
			}
		}
		
		return false;
	}
	

	public UserDTO populateUserDTO(User user,CarInfo carInfo){
		UserDTO userDTO=null;
		if(user!=null){
			 userDTO=new UserDTO();
			if(carInfo != null){
				userDTO.setCarNo(carInfo.getCarNo());
			}
			userDTO.setEmail(user.getEmail());
			userDTO.setMobileNo(user.getMobileNo());
			userDTO.setName(user.getName());
			userDTO.setCreatedAt(user.getCreatedAt());
		}
		return userDTO;
		
		
	}
	
	public User populateUser(UserDTO userDTO,User user){
		
		if(userDTO != null){
			if(user!=null && user.getId() > 0){
				if(userDTO.getEmail() !=null){
					user.setEmail(userDTO.getEmail());
				}
				if(userDTO.getMobileNo() !=null){
					user.setMobileNo(userDTO.getMobileNo());
				}
				if(userDTO.getName() !=null){
					user.setName(userDTO.getName());
					user.setUpdatedBy(userDTO.getName());
				}
				if(userDTO.getUserId() !=0){
					user.setId(userDTO.getUserId());
				}
				
				user.setUpdatedAt(new Date());
				
				
			}else{
				 user=new User();
				user.setCreatedAt(new Date());
				user.setCreatedBy(user.getName());
				user.setUpdatedAt(new Date());
				user.setUpdatedBy(user.getName());
				user.setEmail(userDTO.getEmail());
				user.setMobileNo(userDTO.getMobileNo());
				user.setName(userDTO.getName());
			}
			
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
