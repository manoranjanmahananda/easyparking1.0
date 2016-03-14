/**
 * 
 */
package com.easyparking.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.easyparking.dao.ParkingLotDao;
import com.easyparking.entity.ParkingLot;
import com.easyparking.util.EasyParkingException;

/**
 * @author Manoranjan
 *
 */
@Service
public class ParkingLotService {
	
	@Autowired
	private ParkingLotDao parkingLotDao;
	
	public ParkingLot getParkingLotById(int parkingId){
		ParkingLot parkingLot=null;
		try {
			parkingLot=parkingLotDao.findById(parkingId, ParkingLot.class);
		} catch (EasyParkingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return parkingLot;
	}
	

	@Transactional
	public boolean saveAndUpdateParkingLot(ParkingLot ParkingLot){
		try{
			if(ParkingLot.getId() ==null || ParkingLot.getId() == 0){
				parkingLotDao.persist(ParkingLot);
				return true;
			}else{
				parkingLotDao.merge(ParkingLot);
				return true;
			}
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return false;
	}

}
