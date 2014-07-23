/**
 * 
 */
package com.hele.wsis.entity;

/**
 * @author xuning email:xuningnb@163.com
 * @version creation time:2012-6-26下午4:50:39
 * 类说明：
 * 
 */
public class SMSInfo {

	private String content;	//短信内容
	
	private String status;	//短信发送状态
	
	private String reason;	//发送原因如密码重置，注册激活等
	
	private String mobile;	//手机号
	
	private String guid;	//短信唯一码
	
	private String captcha;	//验证码
	
	private int expiretime;	//超时时间
	
	

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getGuid() {
		return guid;
	}

	public void setGuid(String guid) {
		this.guid = guid;
	}

	public int getExpiretime() {
		return expiretime;
	}

	public void setExpiretime(int expiretime) {
		this.expiretime = expiretime;
	}

	public String getCaptcha() {
		return captcha;
	}

	public void setCaptcha(String captcha) {
		this.captcha = captcha;
	}
	
}
