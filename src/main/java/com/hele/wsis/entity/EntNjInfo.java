package com.hele.wsis.entity;

import java.io.Serializable;

public class EntNjInfo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String nbxh;
	private String nd;
	private String njhzzt;
	private String njjg;
	private String njrq="";
	public String getNbxh() {
		return nbxh;
	}
	public void setNbxh(String nbxh) {
		this.nbxh = nbxh;
	}
	public String getNd() {
		return nd;
	}
	public void setNd(String nd) {
		this.nd = nd;
	}
	public String getNjhzzt() {
		return njhzzt;
	}
	public void setNjhzzt(String njhzzt) {
		this.njhzzt = njhzzt;
	}
	public String getNjjg() {
		return njjg;
	}
	public void setNjjg(String njjg) {
		this.njjg = njjg;
	}
	public String getNjrq() {
		return njrq;
	}
	public void setNjrq(String njrq) {
		this.njrq = njrq==null?"":njrq;
	}
	
}
