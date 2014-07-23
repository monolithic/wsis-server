/**
 * 
 */
package com.hele.wsis.entity;

import java.io.Serializable;

/**
 * @author xuning
 *
 */
public class ExtEcp implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2960442731167543533L;
	public static final String ECP_STATE_USED = "1";
	public static final String ECP_STATE_UNUSED = "0";
	
	private String gid;			//企业id号
	private String ecpNum;		//消费者ecp号
	private String ecpState;	//消费者ecp状态
	private int ecpCounter;	//消费者ecp计数器
	private String ecpPassword;
	
	public String getEcpPassword() {
		return ecpPassword;
	}
	public void setEcpPassword(String ecpPassword) {
		this.ecpPassword = ecpPassword;
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
	public String getEcpState() {
		return ecpState;
	}
	public void setEcpState(String ecpState) {
		this.ecpState = ecpState;
	}
	public int getEcpCounter() {
		return ecpCounter;
	}
	public void setEcpCounter(int ecpCounter) {
		this.ecpCounter = ecpCounter;
	}
	
	
}
