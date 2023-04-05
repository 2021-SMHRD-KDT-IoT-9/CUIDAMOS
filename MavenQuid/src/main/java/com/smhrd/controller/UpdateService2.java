package com.smhrd.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.smhrd.model.WebMember;
import com.smhrd.model.WebMemberDAO;

public class UpdateService2 extends HttpServlet {
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
		int furniture = Integer.parseInt(request.getParameter("furniture"));
		
		WebMember vo = new WebMember(gu_id, pw, gu_name, address, phone, birth, gu_job, gender, furniture);
		WebMemberDAO dao = new WebMemberDAO();
		int cnt = dao.update(vo);
		
		if(cnt>0) {
			System.out.println("정보수정성공!");

		}else {
			System.out.println("정보수정실패");
		}
		response.sendRedirect("select.jsp");
		
	}

}
