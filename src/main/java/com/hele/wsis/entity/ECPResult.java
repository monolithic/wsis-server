package com.hele.wsis.entity;

public class ECPResult {

	private String result;	//结果代码
	private int gid;		//群id	
	private int userid;		//用户id
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}
	public int getGid() {
		return gid;
	}
	public void setGid(int gid) {
		this.gid = gid;
	}
}
