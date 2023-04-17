package com.smhrd.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.smhrd.model.MemberDAO;
import com.smhrd.model.MsgSystem;

@WebServlet("/IoTTest")
public class ButtonToDB extends HttpServlet {
    private static final long serialVersionUID = 1L;
    
    // HTTP 요청을 처리하고, 이를 이용하여 데이터베이스에 값을 저장하는 서블릿
    String url = "jdbc:oracle:thin:@project-db-stu3.ddns.net:1525:xe";
    String db_id = "campus_b_230329_1";
    String db_pw = "smhrd1";
    Connection conn;
    
    @Override
    public void init() throws ServletException {
        super.init();
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            this.conn = DriverManager.getConnection(url, db_id, db_pw);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	MemberDAO dao = new MemberDAO();
	    MsgSystem msgSystem = new MsgSystem();
	    
        response.setContentType("text/plain");
        response.setCharacterEncoding("UTF-8");
        
        // 초음파 센서
        String echoValue = request.getParameter("btn"); // 초음파 센서 실제 값 btn -> echoValue
        int echoValueInt = Integer.parseInt(echoValue); // 초음파 센서 실제 값 int
        System.out.println(""+echoValueInt);
        String echo = request.getParameter("btn2"); // 초음파 센서구분 btn2 -> echo
        String echoTime = request.getParameter("time"); // 초음파 센서 시간 측정
        int echoTimeInt = Integer.parseInt(echoTime);
        System.out.println(""+echoTimeInt);
        
        // 온도 감지 센서
        String tempValue = request.getParameter("temp"); // 온도 센서 실제 값
        int tempValueInt = Integer.parseInt(tempValue); // 온도 센서 실제 값 int
        String temp = request.getParameter("t_sensor"); // 온도 센서 구분
        String tempTime = request.getParameter("time2"); // 온도 센서 시간 측정
        int tempTimeInt = Integer.parseInt(tempTime);
        
        // 수압 감지 센서 4878.0 KPa -> ?
        String waterPresValue = request.getParameter("water_press"); // 수압센서 실제 값
        int waterPresValueInt = Integer.parseInt(waterPresValue);
        String waterPressure = request.getParameter("t_sensor"); // 수압 센서 구분
        String waterPresTime = request.getParameter("time2");
        int waterPresTimeInt = Integer.parseInt(waterPresTime);
        
        // 버튼 감지 센서
        String emerBtnValue = request.getParameter("btn"); // 버튼 감지 센서면 0 또는 1
        int emerBtnValueInt = Integer.parseInt(emerBtnValue);
        String emerBtn = request.getParameter("emerBtn"); // 버튼 센서 구분
        String emerBtnTime = request.getParameter("emerBtnTime");
        int emerBtnTimeInt = Integer.parseInt(emerBtnTime);
        
        // SQL 쿼리 실행
        PreparedStatement stmt = null;
        try {
        	 PrintWriter out = response.getWriter();
        	 // 초음파 센서 임의값 설정
        	if(echoValueInt>=30 && echoTimeInt>=8){
		    	msgSystem.sendSMS(dao);
	            String sql = "INSERT INTO state_manager (sm_mumber, ui_idfk, sensor, result_division) "
	            		+ "VALUES (?, ?, ?, ?)";
	            stmt = conn.prepareStatement(sql);
	            stmt.setString(1, echo); // 대상자 상태감지내역
	            stmt.setString(2, "hee"); // 회원 아이디
	            stmt.setString(3, echoValue); //센서 실제 값
	            stmt.setString(4, "메세지"); // 메세지 또는 잠금해제
	            int cnt = stmt.executeUpdate();
	            System.out.println("행 변화 : " + cnt);
		    }
        	
        	// 온도센서 임의값 설정
        	if(waterPresValueInt<=11 && tempTimeInt>=8){
		    	msgSystem.sendSMS(dao);
	            String sql2 = "INSERT INTO state_manager (sm_mumber, ui_idfk, sensor, result_division) "
	            		+ "VALUES (?, ?, ?, ?)";
	            stmt = conn.prepareStatement(sql2);
	            stmt.setString(1, temp);
	            stmt.setString(2, "hee");
	            stmt.setString(3, tempValue); //센서 실제 값
	            stmt.setString(4, "메세지"); // 메세지 또는 잠금해제
	            int cnt = stmt.executeUpdate();
	            System.out.println("행 변화 : " + cnt);
		    }
        	
        	
       	 // 수압 센서 임의값 설정 (가구최저필요수압(kPa) =  55 kPa / (psi) = 15 psi ) 
        	if(waterPresValueInt>=55 && waterPresTimeInt>=8){
		    	msgSystem.sendSMS(dao);
	            String sql = "INSERT INTO state_manager (sm_mumber, ui_idfk, sensor, result_division) "
	            		+ "VALUES (?, ?, ?, ?)";
	            stmt = conn.prepareStatement(sql);
	            stmt.setString(1, waterPressure); // 대상자 상태감지내역
	            stmt.setString(2, "hee"); // 회원 아이디
	            stmt.setString(3, waterPresValue); //센서 실제 값
	            stmt.setString(4, "메세지"); // 메세지 또는 잠금해제
	            int cnt = stmt.executeUpdate();
	            System.out.println("행 변화 : " + cnt);
		    }
        	
        	// 응급버튼의 값이 1일 경우
        	if(emerBtnValueInt==0
        			) {
		    	msgSystem.sendSMS(dao);
		    }
        	
            out.print("Data successfully inserted.");
        } catch (SQLException e) {
            e.printStackTrace();
            PrintWriter out = response.getWriter();
            out.print("Failed to insert data.");
        } finally {
            // DB 연결 종료
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    
    @Override
    public void destroy() {
        super.destroy();
        try {
            if (conn != null) {
                conn.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
