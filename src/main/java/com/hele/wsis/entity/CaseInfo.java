/**
 * 
 */
package com.hele.wsis.entity;

import java.io.Serializable;

/**
 * @author xuning email:xuningnb@163.com
 * @version creation time:2012-10-21下午7:57:25
 * 类说明：
 * 
 */
public class CaseInfo implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String id;
	private String title;
	private String content;
	private String lrsj;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getLrsj() {
		return lrsj;
	}
	public void setLrsj(String lrsj) {
		this.lrsj = lrsj;
	}

}
