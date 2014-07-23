/**
 * 
 */
package com.hele.wsis.entity;

import java.io.Serializable;

/**
 * @author xuning email:xuningnb@163.com
 * @version creation time:2012-6-13下午1:54:13
 * 类说明：
 * 
 */
public class UserOrder implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String userid;
	private String entid;
	private String tslx;
	private String orderid;
	private String ordertime;
	
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getEntid() {
		return entid;
	}
	public void setEntid(String entid) {
		this.entid = entid;
	}
	public String getTslx() {
		return tslx;
	}
	public void setTslx(String tslx) {
		this.tslx = tslx;
	}
	public String getOrderid() {
		return orderid;
	}
	public void setOrderid(String orderid) {
		this.orderid = orderid;
	}
	public String getOrdertime() {
		return ordertime;
	}
	public void setOrdertime(String ordertime) {
		this.ordertime = ordertime;
	}
	@Override
	public String toString() {
		return "UserOrder [userid=" + userid + ", entid=" + entid + ", tslx="
				+ tslx + ", orderid=" + orderid + ", ordertime=" + ordertime
				+ "]";
	}
	
	
}
