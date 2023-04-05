package com.smhrd.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.smhrd.model.WebMemberDAO;

public class DeleteService extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String gu_id = request.getParameter("gu_id");
		
		WebMemberDAO dao = new WebMemberDAO();
		int cnt = dao.delete(gu_id);
		
		if(cnt>0) {
			System.out.println("회원삭제성공!");
		}else {
			System.out.println("회원삭제실패!");
		}
	
		response.sendRedirect("select.jsp");
	}

}
