/**
 * 
 */
package com.easyparking.booking;

import java.io.Serializable;
import java.util.Date;

/**
 * @author Apple
 *
 */
public class BookingForm implements Serializable{
	 
	private String parkingId; 
	public String getParkingId() {
		return parkingId;
	}
	public void setParkingId(String parkingId) {
		this.parkingId = parkingId;
	}
	private String vehicleNo;
	public String getVehicleNo() {
		return vehicleNo;
	}
	public void setVehicleNo(String vehicleNo) {
		this.vehicleNo = vehicleNo;
	}
	
	private Date timeIn;
	public Date getTimeIn() {
		return timeIn;
	}
	public void setTimeIn(Date timeIn) {
		this.timeIn = timeIn;
	}
	public Date getTimeOut() {
		return timeOut;
	}
	public void setTimeOut(Date timeOut) {
		this.timeOut = timeOut;
	}
	private Date timeOut;

}
