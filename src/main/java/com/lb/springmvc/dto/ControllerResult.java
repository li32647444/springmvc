package com.lb.springmvc.dto;

public class ControllerResult {
	
	public static final String STATUS_SUCCESS="success";
	public static final String STATUS_ERROR="error";
	public static final String STATUS_FAIL="fail";
	public static final String STATUS_OVERTIME="overtime";
	
	private String resultStatus=STATUS_SUCCESS;
	
	private String message;
	
	private Object data;
	
	public ControllerResult(String resultStatus,String message){
		this.resultStatus = resultStatus;
		this.message = message;
	}
	public ControllerResult(String resultStatus,String message,Object data){
		this.resultStatus = resultStatus;
		this.message = message;
		this.data = data;
	}

	public String getResultStatus() {
		return resultStatus;
	}
	public void setResultStatus(String resultStatus) {
		this.resultStatus = resultStatus;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Object getData() {
		return data;
	}
	public void setData(Object data) {
		this.data = data;
	}
	
}
