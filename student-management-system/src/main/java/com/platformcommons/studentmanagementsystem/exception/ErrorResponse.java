package com.platformcommons.studentmanagementsystem.exception;

public class ErrorResponse {
	private String message;
	private int status;
	
	public ErrorResponse(String msg , int status) {
		this.message = msg;
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}
	
	
}
