/**
 * 
 */
package com.hele.wsis.entity;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * @author xuning
 *
 */
public class ResultObject implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String status;
	private String info;
	private Map<String, Object> data;
	
	public ResultObject(){
		this.data = new HashMap<String, Object>();
	}
	
	
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getInfo() {
		return info;
	}
	public void setInfo(String info) {
		this.info = info;
	}
	public Map<String, Object> getData() {
		return data;
	}
	public void setData(Map<String, Object> data) {
		this.data = data;
	}
	
	public void setValue(String key,String value){
		this.data.put(key, value);
	}
}
