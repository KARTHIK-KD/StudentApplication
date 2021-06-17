package com.ionebill.response;

public class StudentResponse {
	private int status;
	private String msg;
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	@Override
	public String toString() {
		return "StudentResponse [status=" + status + ", msg=" + msg + "]";
	}
	
	

}
