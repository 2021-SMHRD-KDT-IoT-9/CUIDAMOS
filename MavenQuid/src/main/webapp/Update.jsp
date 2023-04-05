<%@page import="com.smhrd.model.WebMemberDAO"%>
<%@page import="com.smhrd.model.WebMember1"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		String gu_id = request.getParameter("gu_id");
		WebMemberDAO dao = new WebMemberDAO();		
		
		
		
	%>
	
	<%-- 	<h2 class="major">정보수정</h2>
		<form method="post" action="UpdateService">
			<div class="fields">

				<div class="field half">
					<label>아이디</label> <input type="text"
						value="<%=%>" name="gu_id" readonly />
				</div>

				<div class="field half">
					<label>비밀번호</label> <input type="password" name="pw" id="pw"
						value="<%=loginMember.getPw() %>" />
				</div>
				<div class="field half">
					<label>이름</label> <input type="text" name="gu_name"
						value="<%=loginMember.getGu_name() %>" />
				</div>

				<div class="field">
					<label for="address">주소</label> <input type="text" name="address"
						value="<%=loginMember.getAddress() %>" />
				</div>

				<div class="field half">
					<label>휴대폰</label> <input type="text" name="phone"
						value="<%=loginMember.getPhone() %>" />
				</div>

				<div class="field half">
					<label>생년월일</label> <input type="text" name="birth"
						value="<%=loginMember.getBirth() %>" />
				</div>

				<div class="field half">
					<label>직업</label> <input type="text" name="gu_job"
						value="<%=loginMember.getGu_job() %>" />
				</div>

				<div class="field half">
					<label>성별</label> <input type="text" name="gender"
						value="<%=loginMember.getGender() %>" />
				</div>

			</div>
			<ul class="actions">
				<li><input type="submit" value="정보수정" class="button fit"></li>
			</ul>
		</form> --%>

	
</body>
</html>