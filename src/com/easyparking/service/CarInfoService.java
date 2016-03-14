/**
 * 
 */
package com.easyparking.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.easyparking.dao.CarInfoDao;
import com.easyparking.entity.CarInfo;
import com.easyparking.entity.User;
/**
 * @author Manoranjan
 *
 */
@Service
public class CarInfoService {
	@Autowired
	private CarInfoDao carInfoDao;
	
	public CarInfo getCarInfoByUserId(Integer userId ){
		CarInfo carInfo=null;
		try{
			if(userId != null){
				//user=userDao.findByUserId(userId);
				 carInfo=carInfoDao.findByUserId(userId);
			}
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return carInfo;
	}
	
	@Transactional
	public boolean saveAndUpdateCarInfo(CarInfo carInfo){
		try{
			if(carInfo.getId() ==null || carInfo.getId() == 0){
				carInfoDao.persist(carInfo);
				return true;
			}else{
				carInfoDao.merge(carInfo);
				return true;
			}
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return false;
	}
}
