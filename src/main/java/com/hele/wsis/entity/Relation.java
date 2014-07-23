/**
 * 
 */
package com.hele.wsis.entity;

import java.io.Serializable;

/**
 * @author xuning email:xuningnb@163.com
 * @version creation time:2012-7-25下午3:38:52
 * 类说明：
 * 
 */
public class Relation implements Serializable {

	private static final long serialVersionUID = 1L;

	private String userid;
	private String entgid;
	private String entname;
	private int entRelation;
	
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getEntname() {
		return entname;
	}
	public void setEntname(String entname) {
		this.entname = entname;
	}
	public String getEntgid() {
		return entgid;
	}
	public void setEntgid(String entgid) {
		this.entgid = entgid;
	}
	public int getEntRelation() {
		return entRelation;
	}
	public void setEntRelation(int entRelation) {
		this.entRelation = entRelation;
	}
	
	
	
}
