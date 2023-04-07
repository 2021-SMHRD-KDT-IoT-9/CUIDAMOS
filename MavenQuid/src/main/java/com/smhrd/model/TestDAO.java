package com.smhrd.model;

public class TestDAO {

	public static void main(String[] args) {

		String Gu_ID = "hee";
		String Gu_NAME = "희경";
		String pHONE = "01097972326";
		String furniture = "a0001";
		String address = "광주광역시";
		
		
		MemberDTO dto = new MemberDTO(Gu_ID, Gu_NAME, pHONE, furniture, address);
//		System.out.println(dto.getFurniture()); 
		MemberDAO dao = new MemberDAO();
		String phone = dao.connection(dto);
		System.out.println();
		
		
		
		
		
	}

}
