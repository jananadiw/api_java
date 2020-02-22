package com.example.test.model.rsp;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class LoginRspModel{
	private int userId;
	private String userName;
	@JsonIgnore
	private String password;
	private String loginDt;
	
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getuserName() {
		return userName;
	}
	public void setuserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getLoginDt() {
		return loginDt;
	}
	public void setLoginDt(String loginDt) {
		this.loginDt = loginDt;
	} 
}