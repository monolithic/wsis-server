package com.hele.wsis.entity;

import java.io.Serializable;

public class EntBgInfo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String nbxh;
	private String bgsx;
	private String hzrq;
	public String getNbxh() {
		return nbxh;
	}
	public void setNbxh(String nbxh) {
		this.nbxh = nbxh;
	}
	public String getBgsx() {
		return bgsx;
	}
	public void setBgsx(String bgsx) {
		this.bgsx = bgsx;
	}
	public String getHzrq() {
		return hzrq;
	}
	public void setHzrq(String hzrq) {
		this.hzrq = hzrq;
	}
	
}
