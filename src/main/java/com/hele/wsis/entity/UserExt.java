/**
 * 
 */
package com.hele.wsis.entity;

import java.io.Serializable;

/**
 * @author xuning
 *
 */
public class UserExt implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7445696635001828857L;
	public static final String ECP_TYPE_VALID = "1";	//有效
	public static final String ECP_TYPE_TEMP = "0";		//临时
	public static final String ECP_TYPE_INVALID = "2";	//失效
	
	
	private String gid;
	private String ecpNum;
	private String ecpPassword;
	private String ecpType;
	private String website;
	private int entRelation;
	
	public int getEntRelation() {
		return entRelation;
	}
	public void setEntRelation(int entRelation) {
		this.entRelation = entRelation;
	}
	public String getWebsite() {
		return website;
	}
	public void setWebsite(String website) {
		this.website = website;
	}
	public String getGid() {
		return gid;
	}
	public void setGid(String gid) {
		this.gid = gid;
	}
	public String getEcpNum() {
		return ecpNum;
	}
	public void setEcpNum(String ecpNum) {
		this.ecpNum = ecpNum;
	}
	public String getEcpPassword() {
		return ecpPassword;
	}
	public void setEcpPassword(String ecpPassword) {
		this.ecpPassword = ecpPassword;
	}
	public String getEcpType() {
		return ecpType;
	}
	public void setEcpType(String ecpType) {
		this.ecpType = ecpType;
	}

}
