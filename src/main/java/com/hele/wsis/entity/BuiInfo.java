/**
 * 
 */
package com.hele.wsis.entity;

import java.io.Serializable;

/**
 * 
 * @author xuning email:xuningnb@163.com
 * @version creation time:2012-7-29上午4:01:34
 * 类说明：楼宇信息
 * 
 */
public class BuiInfo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String plagid;
	private int buino;
	private String buiname;
	private String addr;
	
	public String getPlagid() {
		return plagid;
	}
	public void setPlagid(String plagid) {
		this.plagid = plagid;
	}
	public int getBuino() {
		return buino;
	}
	public void setBuino(int buino) {
		this.buino = buino;
	}
	public String getBuiname() {
		return buiname;
	}
	public void setBuiname(String buiname) {
		this.buiname = buiname;
	}
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}

	
}
