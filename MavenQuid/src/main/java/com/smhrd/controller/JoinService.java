package com.smhrd.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.smhrd.model.WebMember1;
import com.smhrd.model.WebMemberDAO;

public class JoinService extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		String gu_id = request.getParameter("gu_id");
		String pw = request.getParameter("pw");
		String gu_name = request.getParameter("gu_name");
		String address = request.getParameter("address");
		String phone = request.getParameter("phone");
		String birth = request.getParameter("birth");
		String gu_job = request.getParameter("gu_job");
		String gender = request.getParameter("gender");
		String furniture = request.getParameter("furniture");
		
		WebMember1 vo = new WebMember1(gu_id, pw, gu_name, address, phone, birth, gu_job, gender, furniture);
		
		WebMemberDAO dao = new WebMemberDAO();
		int cnt = dao.join(vo);
		
		if(cnt > 0) {
			//회원가입 성공
			System.out.println("회원가입 성공");
			RequestDispatcher rd = request.getRequestDispatcher("joinSuccess.jsp");
			request.setAttribute("gu_id", gu_id);
			rd.forward(request, response);
		
		}else {
			//회원가입 실패
			System.out.println("회원가입 실패!");
			response.sendRedirect("index.jsp");
			
		}
	}

}
