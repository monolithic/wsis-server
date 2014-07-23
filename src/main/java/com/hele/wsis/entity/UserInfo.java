/**
 * 
 */
package com.hele.wsis.entity;

import java.io.Serializable;

/**
 * @author xuning
 *
 */
public class UserInfo implements Serializable {

	/**
	 * 
	 */
	public static final String USERTYPE_CONSUMER = "1";
	public static final String USERTYPE_ENTERPRISE = "2";
	public static final String USERTYPE_ORGAN = "3";
	private static final long serialVersionUID = 1L;
	private String gid; // gid
    private String gnumb;   //
	private String email; // 邮件
	private String mobile; // 手机
	private String nickName; // 昵称
	private String regTime; // 注册时间
	private String updateTime; // 更新时间
	private String lastLogin; // 上次登录时间
	private String status; // 状态
	private String userType; // 用户类型
	private String password; // 密码

	public String getGid() {
		return gid;
	}

	public void setGid(String gid) {
		this.gid = gid;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public String getRegTime() {
		return regTime;
	}

	public void setRegTime(String regTime) {
		this.regTime = regTime;
	}

	public String getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(String updateTime) {
		this.updateTime = updateTime;
	}

	public String getLastLogin() {
		return lastLogin;
	}

	public void setLastLogin(String lastLogin) {
		this.lastLogin = lastLogin;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getUserType() {
		return userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	
	
	 @Override
	 public String toString() {
	 return "UserInfo [gid=" + gid + ", email=" + email + ", mobile="
	 + mobile + ", nickName=" + nickName + ", regTime=" + regTime
	 + ", updateTime=" + updateTime + ", lastLogin=" + lastLogin
	 + ", status=" + status + ", userType=" + userType
	 + ", password=" + password + "]";
	 }
	

	
}
