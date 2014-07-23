package com.hele.wsis.entity;

import java.io.Serializable;

public class EntQueryInfo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static final int LIMIT_SIZE = 10;
	private int size;
	private String q;
	public int getSize() {
		return size;
	}
	public void setSize(int size) {
		this.size = size;
	}
	public String getQ() {
		return q;
	}
	public void setQ(String q) {
		this.q = q;
	}
}
