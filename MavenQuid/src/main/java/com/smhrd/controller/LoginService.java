package com.smhrd.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.smhrd.model.WebMember1;
import com.smhrd.model.WebMemberDAO;

public class LoginService extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		String gu_id = request.getParameter("gu_id");
		String pw = request.getParameter("pw");
		
		System.out.println(gu_id + ", "+ pw);
		
		WebMember1 vo = new WebMember1(gu_id, pw);
		
		WebMemberDAO dao = new WebMemberDAO();
		WebMember1 loginMember = dao.login(vo);
		
		if(loginMember != null) {
			//로그인 성공
			System.out.println("로그인 성공");
			HttpSession session = request.getSession();
			session.setAttribute("loginMember", loginMember);
			response.sendRedirect("index.jsp");
		}else {
			//로그인 실패
			System.out.println("로그인 실패!");
			response.sendRedirect("index.jsp");
		}
		
	}

}
