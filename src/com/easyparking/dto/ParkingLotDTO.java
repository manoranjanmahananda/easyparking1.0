/**
 * 
 */
package com.easyparking.dto;

import java.util.Date;



/**
 * @author Manoranjan
 *
 */
public class ParkingLotDTO {
	private String altitude;
	private Integer availableCount;
	private Date createdAt;
	private String createdBy;
	private String longitude;
	private String name;
	private Integer ownerId;
	private Integer pickRate;
	private Date pickTime;
	private Date pickTimeEnd;
	private Integer regularRate;
	private Integer totalCount;
	private Date updatedAt;
	private String updatedBy;
	private Integer status;
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public String getAltitude() {
		return altitude;
	}
	public void setAltitude(String altitude) {
		this.altitude = altitude;
	}
	public Integer getAvailableCount() {
		return availableCount;
	}
	public void setAvailableCount(Integer availableCount) {
		this.availableCount = availableCount;
	}
	public Date getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}
	public String getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}
	public String getLongitude() {
		return longitude;
	}
	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getOwnerId() {
		return ownerId;
	}
	public void setOwnerId(Integer ownerId) {
		this.ownerId = ownerId;
	}
	public Integer getPickRate() {
		return pickRate;
	}
	public void setPickRate(Integer pickRate) {
		this.pickRate = pickRate;
	}
	public Date getPickTime() {
		return pickTime;
	}
	public void setPickTime(Date pickTime) {
		this.pickTime = pickTime;
	}
	public Integer getRegularRate() {
		return regularRate;
	}
	public void setRegularRate(Integer regularRate) {
		this.regularRate = regularRate;
	}
	public Integer getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(Integer totalCount) {
		this.totalCount = totalCount;
	}
	public Date getUpdatedAt() {
		return updatedAt;
	}
	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}
	public String getUpdatedBy() {
		return updatedBy;
	}
	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}
	public Date getPickTimeEnd() {
		return pickTimeEnd;
	}
	public void setPickTimeEnd(Date pickTimeEnd) {
		this.pickTimeEnd = pickTimeEnd;
	}
	

}
