package com.khwy.util;

public enum MyResultEnum {
	SUCCESS(1000,"success"),
	CODE_ERROR(1001,"请输入正确的验证码"),
	USER_FAILED(1002,"请输入正确的用户名或密码"),
	USER_NULL(1003,"用户名或密码为空");
	private int code;
	private String message;
	private MyResultEnum(int code, String message) {
		this.code = code;
		this.message = message;
	}
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
}
