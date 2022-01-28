package com.poscoict.guestbook.vo;

public class guestbookVo {
	private int no;
	private String name;
	private String password;

	private String reg_date;
	private String message;
	
	public int getNo() {
		return no;
	}
	public String getName() {
		return name;
	}

	public String getReg_date() {
		return reg_date;
	}
	
	public String getMessage() {
		return message;
	}
	
	public String getPassword() {
		return password;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public void setMessage(String message) {
		this.message = message;
	}
	
	public void setReg_date(String reg_date) {
		this.reg_date = reg_date;
	}
	
	
	

}
