package com.hele.wsis.entity;



public class UserLoginInfo {

	private String UserId;
	private String WebId;
	private String LoginIp;
	private String LoginTime;
	private String Ticket;

	public UserLoginInfo(){}
	public UserLoginInfo(String UserId, String WebId, String LoginIp, String LoginTime, String Ticket){
		this.UserId = UserId;
		this.WebId = WebId;
		this.LoginIp = LoginIp;
		this.LoginTime = LoginTime;
		this.Ticket = Ticket;
	}
	@Override
	public String toString(){
		String value = "";
		if(UserId != null){
			value += "\"UserId\":\"" + UserId + "\"";
		}
		if(WebId != null){
			value += ",\"WebId\":\"" + WebId + "\"";
		}
		if(LoginIp != null){
			value += ",\"LoginIp\":\"" + LoginIp + "\"";
		}
		if(LoginTime != null){
			value += ",\"LoginTime\":\"" + LoginTime + "\"";
		}
		if(Ticket != null){
			value += ",\"Ticket\":\"" + Ticket + "\"";
		}
		return String.format("{%s}", value);
	}

	public String getUserId(){
		return UserId;
	}
	public String getWebId(){
		return WebId;
	}
	public String getLoginIp(){
		return LoginIp;
	}
	public String getLoginTime(){
		return LoginTime;
	}
	public String getTicket(){
		return Ticket;
	}
	public void setUserId(String userId){
		UserId = userId;
	}
	public void setWebId(String webId){
		WebId = webId;
	}
	public void setLoginIp(String loginIp){
		LoginIp = loginIp;
	}
	public void setLoginTime(String loginTime){
		LoginTime = loginTime;
	}
	public void setTicket(String ticket){
		Ticket = ticket;
	}
}
