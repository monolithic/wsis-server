/**
 * 
 */
package com.hele.wsis.entity;

import java.io.Serializable;

/**
 * @author xuning email:xuningnb@163.com
 * @version creation time:2012-11-1下午4:06:37
 * 类说明：通讯录实体类
 * 
 */
public class ContactInfo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String id;
	private String name;
	private String phoneNum;
	private String grouptype;
    private String grouptypename;
    private String szqx;
    private String qxmc;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhoneNum() {
		return phoneNum;
	}
	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}
	public String getGrouptype() {
		return grouptype;
	}
	public void setGrouptype(String grouptype) {
		this.grouptype = grouptype;
	}

    public String getGrouptypename() {
        return grouptypename;
    }

    public void setGrouptypename(String grouptypename) {
        this.grouptypename = grouptypename;
    }

    public String getSzqx() {
        return szqx;
    }

    public void setSzqx(String szqx) {
        this.szqx = szqx;
    }

    public String getQxmc() {
        return qxmc;
    }

    public void setQxmc(String qxmc) {
        this.qxmc = qxmc;
    }
}
