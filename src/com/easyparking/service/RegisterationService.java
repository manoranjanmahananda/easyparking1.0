/**
 * 
 */
package com.easyparking.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.easyparking.dao.CarInfoDao;
import com.easyparking.dao.UserDao;
import com.easyparking.entity.CarInfo;
import com.easyparking.entity.User;

/**
 * @author Apple
 *
 */
@Service
public class RegisterationService {
	
	@Autowired
	public UserDao userDao;
	
	@Autowired
	public CarInfoDao carInfoDao;
	
	@Transactional
	public boolean registerUser(User user){
		try{
			if(user.getId() ==null || user.getId() == 0){
				userDao.persist(user);
				return true;
			}else{
				userDao.merge(user);
				return true;
			}
			//User updatedUser=userDao.save(user);
			//System.out.println("updatedUser id is:"+updatedUser.getId());
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return false;
	}
	
	@Transactional
	public boolean registerCar(CarInfo carinfo){
		try{
			if(carinfo.getId() ==null || carinfo.getId() == 0){
				carInfoDao.persist(carinfo);
				return true;
			}else{
				carInfoDao.merge(carinfo);
				return true;
			}
			
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return false;
	}
	
	@Transactional
	public boolean registerUserInfo(User user,CarInfo carInfo){
		boolean userBool=registerUser(user);
		boolean carBool=registerCar(carInfo);
		if(userBool && carBool) return true;
		else return false;
		
	}

}
