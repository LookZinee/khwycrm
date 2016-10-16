package com.khwy.util;

public class MyResult {
	private int code;
	private String message;
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
	public MyResult(int code, String message) {
		super();
		this.code = code;
		this.message = message;
	}
	public MyResult() {
		super();
	}
	public static MyResult success(){
		return new MyResult(MyResultEnum.SUCCESS.getCode(), MyResultEnum.SUCCESS.getMessage());
	}
	public static MyResult userFailed(){
		return new MyResult(MyResultEnum.USER_FAILED.getCode(),MyResultEnum.USER_FAILED.getMessage());
	}
	public static MyResult codeError(){
		return new MyResult(MyResultEnum.CODE_ERROR.getCode(), MyResultEnum.CODE_ERROR.getMessage());
	}
	public static MyResult userNull(){
		return new MyResult(MyResultEnum.USER_NULL.getCode(), MyResultEnum.USER_NULL.getMessage());
	}
}
