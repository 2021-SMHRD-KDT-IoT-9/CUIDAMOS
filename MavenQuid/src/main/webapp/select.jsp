<%@page import="org.apache.ibatis.reflection.SystemMetaObject"%>
<%@page import="com.smhrd.model.WebMember1"%>
<%@page import="java.util.List"%>
<%@page import="com.smhrd.model.WebMemberDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<title>Forty by HTML5 UP</title>
		<meta charset="UTF-8" />
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<link rel="stylesheet" href="assets/css/main.css" />
	</head>
	
	<%
		//페이지를 이동하자마자 DB 안에서 값만 그대로 가지고 와서 출력할 수 있도록
				WebMemberDAO dao = new WebMemberDAO();
				List<WebMember1> list = dao.select();
				
				System.out.print(list.get(0).getGu_id());
		%>
	
	<body style="text-align: center;">
		<!-- Wrapper -->
			<div id="wrapper">
				<!-- Menu -->
					<nav id="Update">	
						<table>
							<caption><h2>회원관리페이지</h2></caption>
							<tr>
								<td>아이디</td>
								<td>이름</td>
								<td>주소</td>							
							</tr>
							<!-- 회원의 수만큼 tr 태그 반복 출력 -->
							<!-- 2.모든 회원의 이메일(email),전화번호(tel),주소(address)를 출력하시오. -->
							<% for(int i=0; i<list.size(); i++){ %>
							<tr>
								<td><%=list.get(i).getGu_id() %></td>
								<td><%=list.get(i).getGu_name() %></td>
								<td><%=list.get(i).getAddress() %></td>
								<!-- url에 데이터를 실어서 보내는 방법을 뭐라고 할까요? 쿼리스트링 -->
								<!-- url?name=value&name=value&name=value -->
								<td><a href="UpdateService2?gu_id=<%=list.get(i).getGu_id() %>">수정</a></td>
								<td><a href="DeleteService?gu_id=<%=list.get(i).getGu_id() %>">삭제</a></td>
							</tr>
							<%} %> 
							
						</table>
					</nav>		
					<a href="index.jsp" class="button next scrolly">되돌아가기</a>	
			</div>
		<!-- Scripts -->
			<script src="assets/js/jquery.min.js"></script>
			<script src="assets/js/jquery.scrolly.min.js"></script>
			<script src="assets/js/jquery.scrollex.min.js"></script>
			<script src="assets/js/skel.min.js"></script>
			<script src="assets/js/util.js"></script>
			<!--[if lte IE 8]><script src="assets/js/ie/respond.min.js"></script><![endif]-->
			<script src="assets/js/main.js"></script>
	</body>
</html>

