package com.smhrd.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.smhrd.model.MemberDAO;
import com.smhrd.model.MsgSystem;

@WebServlet("/IoTTest1")
public class ButtonEvent extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void service(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		//웹 애플리케이션에서 HTTP 요청을 받아들이고, 
		//해당 요청에 대한 처리를 수행한 뒤 HTTP 응답을 반환하는 Servlet 컨트롤러
		String driver = "oracle.jdbc.driver.OracleDriver"; // JDBC 드라이버 클래스 이름
		String url = "jdbc:oracle:thin:@project-db-stu3.ddns.net:1525:xe"; //서버 이름
		String db_id = "campus_b_230329_1";
		String db_pw = "smhrd1";
		
		Connection conn = null;
		
		try {
			Class.forName(driver); // JDBC 드라이버 로드
			conn = DriverManager.getConnection(url, db_id, db_pw); // 데이터베이스 연결 설정
			System.out.println("test!");
			
			String btn = request.getParameter("btn"); // 실제 값
			System.out.println(btn);
			int btnInt = Integer.parseInt(btn);
//			System.out.println("test2 : "  + btnInt);
			
		      
		    String btn2 = request.getParameter("btn2"); // 센서 구분
		    System.out.println(btn2);
		    int btn2Int = Integer.parseInt(btn2);
		      
		    String time = request.getParameter("time"); // 센서 구분
		    System.out.println(time);
		    int timeInt = Integer.parseInt(time);
		    
		    PrintWriter out = response.getWriter();
		    out.print("hi"); //얘는 추후에 따로 보기
		    // 1. btn>30이 8시간이상 지속시 메세지시스템 보내기
		    
		    MemberDAO dao = new MemberDAO();
		    MsgSystem msgSystem = new MsgSystem();
		    
		    if(btnInt>=30 && timeInt>=8){
		    	msgSystem.sendSMS(dao);
		    	
		    }
		    
		    // 2. 버튼이 눌렸을 경우 -> 메세지 시스템에서 발송
		    if(btn2Int==4) {
		    	msgSystem.sendSMS(dao);
		    }
		    
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
