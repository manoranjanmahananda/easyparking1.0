/**
 * 
 */
package com.easyparking.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.easyparking.dao.CarParkingMappingDao;
import com.easyparking.entity.CarParkingMapping;
import com.easyparking.entity.User;

/**
 * @author Manoranjan
 *
 */
@Service
public class CarParkingMappingService {
	
	@Autowired
	private CarParkingMappingDao carParkingMappingDao;
	
	@Transactional
	public boolean saveAndUpdateCarParkingMapping(CarParkingMapping carParkingMapping){
		try{
			if(carParkingMapping.getId() ==null || carParkingMapping.getId() == 0){
				carParkingMappingDao.persist(carParkingMapping);
				return true;
			}else{
				carParkingMappingDao.merge(carParkingMapping);
				return true;
			}
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return false;
	}
	
	
	public CarParkingMapping getCarParkingMapping(Integer carParkingMappingId ){
		CarParkingMapping carParkingMapping=null;
		try{
			if(carParkingMappingId > 0){
				carParkingMapping=carParkingMappingDao.findById(carParkingMappingId, CarParkingMapping.class);
			}
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return carParkingMapping;
	}

}
