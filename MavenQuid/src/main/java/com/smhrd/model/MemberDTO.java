package com.smhrd.model;

public class MemberDTO {
	
	private String GU_ID;
	private String GU_NAME;
	private String PHONE;
	private String funiture;
	
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
		return funiture;
	}
	public MemberDTO(String gU_ID, String gU_NAME, String pHONE, String funiture) {
		super();
		GU_ID = gU_ID;
		GU_NAME = gU_NAME;
		PHONE = pHONE;
		this.funiture = funiture;
	}
	public MemberDTO(String gU_NAME, String pHONE, String funiture) {
		super();
		GU_NAME = gU_NAME;
		PHONE = pHONE;
		this.funiture = funiture;
	}
	
	
	
	
	
}
