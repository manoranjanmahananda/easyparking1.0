/**
 * 
 */
package com.easyparking.dto;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;

/**
 * @author Manoranjan
 *
 *user form dto
 */
public class UserDTO implements Serializable{
	

	private int userId;
	private String email;
	private String mobileNo;
	private String name;
	private String carNo;
	private Date createdAt;
	
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public Date getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getMobileNo() {
		return mobileNo;
	}
	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCarNo() {
		return carNo;
	}
	public void setCarNo(String carNo) {
		this.carNo = carNo;
	}
	
	

}
