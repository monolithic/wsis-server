/**
 * 
 */
package com.hele.wsis.entity;

import java.io.Serializable;

/**
 * @author xuning
 *
 */
public class WebServInfo implements Serializable {

	public String getSid() {
		return sid;
	}
	public void setSid(String sid) {
		this.sid = sid;
	}
	public String getWebAddr() {
		return webAddr;
	}
	public void setWebAddr(String webAddr) {
		this.webAddr = webAddr;
	}
	public String getWebServDesc() {
		return webServDesc;
	}
	public void setWebServDesc(String webServDesc) {
		this.webServDesc = webServDesc;
	}
	public String getEmailUserName() {
		return emailUserName;
	}
	public void setEmailUserName(String emailUserName) {
		this.emailUserName = emailUserName;
	}
	public String getEmailPassword() {
		return emailPassword;
	}
	public void setEmailPassword(String emailPassword) {
		this.emailPassword = emailPassword;
	}
	public String getSmtpAddr() {
		return smtpAddr;
	}
	public void setSmtpAddr(String smtpAddr) {
		this.smtpAddr = smtpAddr;
	}
	private String sid;
	private String webAddr;
	private String webServDesc;
	private String emailUserName;
	private String emailPassword;
	private String smtpAddr;
	private String gid;
	private String crypt_key;
	public String getGid() {
		return gid;
	}
	public void setGid(String gid) {
		this.gid = gid;
	}
	public String getCrypt_key() {
		return crypt_key;
	}
	public void setCrypt_key(String crypt_key) {
		this.crypt_key = crypt_key;
	}
}
