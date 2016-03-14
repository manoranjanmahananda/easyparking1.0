/**
 * 
 */
package com.easyparking.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.easyparking.dao.UserDao;
import com.easyparking.entity.User;

/**
 * @author Manoranjan
 *  it contain all methods related to users.
 *
 */
@Service
public class UserService {
	@Autowired
	public UserDao userDao;
	
	public User getUserDetailsByEmail(String emailId ){
		User user=null;
		try{
			if(emailId != null){
				user=userDao.findByEmailId(emailId);
			}
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return user;
	}
	
	public User getUserDetailsByUserId(Integer userId ){
		User user=null;
		try{
			if(userId != null){
				user=userDao.findByUserId(userId);
			}
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return user;
	}
	
	public boolean saveAndUpdate(User user){
		boolean userSaveboolean=false;
		userSaveboolean=userDao.saveAndUpdateUser(user);
		return userSaveboolean;
	}

}
