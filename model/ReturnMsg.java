package com.example.test.model;

import com.example.test.common.ReturnCode;
import com.fasterxml.jackson.annotation.JsonIgnore;

public class ReturnMsg {
	private int code;
	@JsonIgnore
	private ReturnCode returnCode;
	private String message;
	private Object data;
	
	public ReturnMsg() {
		this.returnCode = ReturnCode.OK;
		this.message = "";
		this.data = null;
	}
	
	public ReturnMsg(ReturnCode returnCode, Object returnData) {
		this.returnCode = returnCode;
		this.message = "";
		this.data = returnData;
	}
	
	public ReturnMsg(ReturnCode returnCode, String message) {
		this.returnCode = returnCode;
		this.message = message;
		this.data = null;
	}
	
	public int getCode() {
		return returnCode.getNumVal();
	}
	
	public void setReturnCode(ReturnCode returnCode) {
		this.returnCode = returnCode;
	}
	
	public String getMessage() {
		if (this.message == null || this.message == "") {
			return returnCode.getMessage();
		} else {
			return this.message;
		}
	}
	
	public Object getData() {
		return data;
	}
	public void setData(Object data) {
		this.data = data;
	}
}
