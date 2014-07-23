package com.hele.wsis.entity;

import java.io.Serializable;

public class Qyjcxx implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String nbxh;
	private String qymc;
	private String qyzt;
	public String getQyzt() {
		return qyzt;
	}
	public void setQyzt(String qyzt) {
		this.qyzt = qyzt;
	}
	public String getNbxh() {
		return nbxh;
	}
	public void setNbxh(String nbxh) {
		this.nbxh = nbxh;
	}
	public String getQymc() {
		return qymc;
	}
	public void setQymc(String qymc) {
		this.qymc = qymc;
	}
//	@Override
//	public String toString() {
//		return "Qyjcxx [nbxh=" + nbxh + ", qymc=" + qymc + ", qyzt=" + qyzt
//				+ "]";
//	}
	
	
}
