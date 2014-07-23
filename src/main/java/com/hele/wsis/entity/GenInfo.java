/**
 * 
 */
package com.hele.wsis.entity;

import java.io.Serializable;

/**
 * @author xuning email:xuningnb@163.com
 * @version creation time:2012-7-29上午4:01:34
 * 类说明：
 * 
 */
public class GenInfo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String gid;
	private String addr;
	private String country;
	private String addrdistrict;
	public String getGid() {
		return gid;
	}
	public void setGid(String gid) {
		this.gid = gid;
	}
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getAddrdistrict() {
		return addrdistrict;
	}
	public void setAddrdistrict(String addrdistrict) {
		this.addrdistrict = addrdistrict;
	}
	
	
}
