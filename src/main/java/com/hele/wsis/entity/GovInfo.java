/**
 * 
 */
package com.hele.wsis.entity;

import java.io.Serializable;

/**
 * @author xuning email:xuningnb@163.com
 * @version creation time:2012-8-10上午9:43:57
 * 类说明：
 * 
 */
public class GovInfo implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String gid;
	private String govid;
	private String govname;
	private String fddbr;
	private String addr;
	
	
	public String getGid() {
		return gid;
	}
	public void setGid(String gid) {
		this.gid = gid;
	}
	public String getGovid() {
		return govid;
	}
	public void setGovid(String govid) {
		this.govid = govid;
	}
	public String getGovname() {
		return govname;
	}
	public void setGovname(String govname) {
		this.govname = govname;
	}
	public String getFddbr() {
		return fddbr;
	}
	public void setFddbr(String fddbr) {
		this.fddbr = fddbr;
	}
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
	
	

}
