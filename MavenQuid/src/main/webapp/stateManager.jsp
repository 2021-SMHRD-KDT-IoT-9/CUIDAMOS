<%@page import="com.smhrd.model.StateManagerDTO"%>
<%@page import="org.apache.ibatis.reflection.SystemMetaObject"%>
<%@page import="com.smhrd.model.WebMember1"%>
<%@page import="java.util.List"%>
<%@page import="com.smhrd.model.WebMemberDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<title>Forty by HTML5 UP</title>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<link rel="stylesheet" href="assets/css/main.css" />
</head>

	<%
		 WebMemberDAO dao = new WebMemberDAO();
		 List<StateManagerDTO> list = dao.stateManager(); 
	%>

<body style="text-align:center">
<div id="wrapper">
	<table>
		<caption><h2>센서확인</h2></caption>
		<tr>
			<td>대상자명</td>
			<td>대상자 아이디</td>
			<td>센서구분(수압, 동작, 스위치)</td>
			<td>등록일시</td>
			<td>결과처리구분(잠금해제, 메시지)</td>
			<td>결과처리일시</td>
		</tr>
		
		 <% for(int i=0; i<list.size(); i++) { %>
		<tr>
			<td><%=list.get(i).getSm_mumber() %></td>
			<td><%=list.get(i).getUi_idfk() %></td>
			<td><%=list.get(i).getSensor() %></td>
			<td><%=list.get(i).getRegistration() %></td>
			<td><%=list.get(i).getResult_division() %></td>
			<td><%=list.get(i).getResult_date() %></td>
		</tr>
		<% } %> 
		
	</table>
	<a href="index.jsp" class="button next scrolly">되돌아가기</a>
</div>
</body>
</html>