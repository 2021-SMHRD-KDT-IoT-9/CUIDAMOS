package com.smhrd.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.smhrd.model.WebMember1;
import com.smhrd.model.WebMemberDAO;

public class UpdateService extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
//		String gu_id = request.getParameter("gu_id");
		
		String pw = request.getParameter("pw");
		String gu_name = request.getParameter("gu_name");
		String address = request.getParameter("address");
		String phone = request.getParameter("phone");
		String birth = request.getParameter("birth");
		String gu_job = request.getParameter("gu_job");
		String gender = request.getParameter("gender");
		String furniture = request.getParameter("furniture");
		
		//현재 로그인한 사용자의 아이디 -> 세션
		HttpSession session = request.getSession();
		//로그인할 때 저장된 현재 아이디, 비번 등 모든 데이터 
		WebMember1 vo = (WebMember1) session.getAttribute("loginMember");
		String gu_id = vo.getGu_id();
		
		
		WebMember1 vo2 = new WebMember1(gu_id, pw, gu_name, address, phone, birth, gu_job, gender, furniture);
		
		WebMemberDAO dao = new WebMemberDAO();
		int cnt = dao.update(vo2);
		
		if(cnt>0) {
			System.out.println("정보수정성공!");
			session.setAttribute("loginMember", vo2);
		}else {
			System.out.println("정보수정실패!!");
		}
		response.sendRedirect("index.jsp");

	}

}
