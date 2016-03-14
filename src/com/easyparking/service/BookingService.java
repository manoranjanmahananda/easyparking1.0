/**
 * 
 */
package com.easyparking.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.easyparking.dao.CarParkingMappingDao;
import com.easyparking.dao.UserCarMappingDao;
import com.easyparking.entity.CarParkingMapping;
import com.easyparking.entity.UserCarMapping;
import com.easyparking.util.EasyParkingException;

/**
 * @author Apple
 *
 */
@Service
public class BookingService {

	@Autowired
	private UserCarMappingDao userCarParkingDao;
	@Autowired
	private CarParkingMappingDao carParkingMappingDao;
	
	@Transactional
	public void bookCar(UserCarMapping userCarMapping,CarParkingMapping carParkingMapping){
		if(userCarMapping != null && carParkingMapping !=null){
			try {
				//userCarParkingDao.persist(userCarMapping);
				carParkingMappingDao.persist(carParkingMapping);
			} catch (EasyParkingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
	}
	
}
