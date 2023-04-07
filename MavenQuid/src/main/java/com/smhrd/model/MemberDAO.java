package com.smhrd.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MemberDAO {

	Connection conn = null;
	PreparedStatement psmt = null;
	ResultSet rs = null;

	int cnt = 0;
	boolean result;
	String phone = "";
	MemberDTO dto = null;
	
	public MemberDTO connection(String furniture) {
		try {
			// 1. 연결 - JDBC 동적로딩
			Class.forName("oracle.jdbc.driver.OracleDriver");

			// 2. 데이터베이스 연결
			String url = "jdbc:oracle:thin:@project-db-stu3.ddns.net:1525:xe";
			String db_id = "campus_b_230329_1";
			String db_pw = "smhrd1";
			conn = DriverManager.getConnection(url, db_id, db_pw);

			// 3. SQL 쿼리 실행
			String sql = "SELECT gu_id, gu_name,address, phone FROM guardian WHERE furniture=?";
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, furniture);

			rs = psmt.executeQuery();

			// 4. 결과값 처리
			if (rs.next()) {
				String gu_id = rs.getString("GU_ID");
				String gu_name = rs.getString("GU_NAME");
				String phone = rs.getString("PHONE");
				String address = rs.getString("ADDRESS");
				
				
				dto = new MemberDTO(gu_id, gu_name, phone, furniture, address);
				
			

				// TODO: 결과값 처리 로직 구현
			}

		} catch (ClassNotFoundException e) {
			System.out.println("클래스 오류");
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println("DB 관련 오류");
			e.printStackTrace();
		} finally {
			// 5. 자원 해제
			try {
				if (rs != null) {
					rs.close();
				}
				if (psmt != null) {
					psmt.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		
		return dto;

	}

	

	public String connection(MemberDTO dto) {
		try {
			// 1. 연결 - JDBC 동적로딩
			Class.forName("oracle.jdbc.driver.OracleDriver");

			// 2. 데이터베이스 연결
			String url = "jdbc:oracle:thin:@project-db-stu3.ddns.net:1525:xe";
			String db_id = "campus_b_230329_1";
			String db_pw = "smhrd1";
			conn = DriverManager.getConnection(url, db_id, db_pw);

			// 3. SQL 쿼리 실행
			String sql = "SELECT gu_id, gu_name,address, phone FROM guardian WHERE furniture=?";
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, dto.getFurniture());

			System.out.println("테스트1");
			System.out.println(dto.getFurniture());

			rs = psmt.executeQuery();

			// 4. 결과값 처리
			while (rs.next()) {
				String gu_id = rs.getString("GU_ID");
				String gu_name = rs.getString("GU_NAME");
				String address = rs.getString("ADDRESS");
				phone = rs.getString("PHONE");
				System.out.println("여기 도착함");
				System.out.println("id: " + gu_id + ", name: " + gu_name + ", phone: " + phone + ", address:" + address);
				// TODO: 결과값 처리 로직 구현
			}

		} catch (ClassNotFoundException e) {
			System.out.println("클래스 오류");
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println("DB 관련 오류");
			e.printStackTrace();
		} finally {
			// 5. 자원 해제
			try {
				if (rs != null) {
					rs.close();
				}
				if (psmt != null) {
					psmt.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		
		return phone;

	}

}