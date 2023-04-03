package com.smhrd.model;

public class WebMember {
	private String gu_id;
	private String pw;
	private String tel;
	private String address;
	
	
	@Override
	public String toString() {
		return "WebMember [gu_id=" + gu_id + ", pw=" + pw + ", tel=" + tel + ", address=" + address + "]";
	}
	public WebMember() {
		super();
	}	
	public WebMember(String gu_id, String pw, String tel, String address) {
		this.gu_id = gu_id;
		this.pw = pw;
		this.tel = tel;
		this.address = address;
	}
	
	public WebMember(String gu_id, String pw) {
		this.gu_id = gu_id;
		this.pw = pw;
	}
	
	public String getEmail() {
		return gu_id;
	}
	public String getPw() {
		return pw;
	}
	public String getTel() {
		return tel;
	}
	public String getAddress() {
		return address;
	}

	
	

}
