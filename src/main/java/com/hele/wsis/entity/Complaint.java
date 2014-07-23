/**
 * 
 */
package com.hele.wsis.entity;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * @author xuning email:xuningnb@163.com
 * @version creation time:2012-9-23上午10:04:16
 * 类说明：
 * 
 */
public class Complaint implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String gid;
	private String entgid;
	private Timestamp gps_time;
	private Timestamp recv_time;
	private String latitude;
	private String longitude;
	private String geocodeing;
	private String memo;
	private String photo_id;
	public String getGid() {
		return gid;
	}
	public void setGid(String gid) {
		this.gid = gid;
	}
	public String getEntgid() {
		return entgid;
	}
	public void setEntgid(String entgid) {
		this.entgid = entgid;
	}
	public Timestamp getGps_time() {
		System.out.println("ssssssss");
		return gps_time;
	}
	public void setGps_time(String gps_time) {
		System.out.println(gps_time);
		this.gps_time = new Timestamp(Long.valueOf(gps_time));
	}
	public Timestamp getRecv_time() {
		return recv_time;
	}
	public void setRecv_time(String recv_time) {
		this.recv_time = new Timestamp(Long.valueOf(recv_time));
	}
	public String getLatitude() {
		return latitude;
	}
	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}
	public String getLongitude() {
		return longitude;
	}
	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}
	public String getGeocodeing() {
		return geocodeing;
	}
	public void setGeocodeing(String geocodeing) {
		this.geocodeing = geocodeing;
	}
	public String getMemo() {
		return memo;
	}
	public void setMemo(String memo) {
		this.memo = memo;
	}
	public String getPhoto_id() {
		return photo_id;
	}
	public void setPhoto_id(String photo_id) {
		this.photo_id = photo_id;
	}

}
