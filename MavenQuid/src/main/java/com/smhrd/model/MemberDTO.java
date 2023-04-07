package com.smhrd.model;

public class MemberDTO {
	
	private String GU_ID;
	private String GU_NAME;
	private String PHONE;
	private String furniture;
	private String address;
	
	public String getGU_ID() {
		return GU_ID;
	}
	public String getGU_NAME() {
		return GU_NAME;
	}
	public String getPHONE() {
		return PHONE;
	}
	public String getFurniture() {
		return furniture;
	}
	
	public String getAddress() {
		return address;
	}
	
	public MemberDTO(String Gu_ID, String Gu_NAME, String pHONE, String furniture, String address) {
		super();
		GU_ID = Gu_ID;
		GU_NAME = Gu_NAME;
		PHONE = pHONE;
		this.furniture = furniture;
		this.address = address;
	}
	public MemberDTO(String gU_NAME, String pHONE, String furniture, String address) {
		super();
		GU_NAME = gU_NAME;
		PHONE = pHONE;
		this.furniture = furniture;
		this.address = address;
	}
	
	
	
	
	
}
