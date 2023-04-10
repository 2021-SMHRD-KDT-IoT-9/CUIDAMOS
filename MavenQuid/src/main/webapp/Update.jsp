<%@page import="org.apache.ibatis.reflection.SystemMetaObject"%>
<%@page import="com.smhrd.model.WebMemberDAO"%>
<%@page import="com.smhrd.model.WebMember1"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Insert title here</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="assets/css/main.css" />

</head>
<body class="is-preload">
	<%
		String gu_id = request.getParameter("gu_id");
		WebMemberDAO dao = new WebMemberDAO();		
		WebMember1 member = dao.selectOne(gu_id);
	%>
	
	 	 <h2 class="major">정보수정</h2>
		<form method="post" action="UpdateService2">
			<div class="fields">

				<div class="field half">
					<label>아이디</label> <input type="text"
						value="<%=member.getGu_id() %>" name="gu_id" readonly />
				</div>

				<div class="field half">
					<label>비밀번호</label> <input type="password" name="pw" id="pw"
						value="<%=member.getPw() %>" />
				</div>
				<div class="field half">
					<label>이름</label> <input type="text" name="gu_name"
						value="<%=member.getGu_name() %>" />
				</div>

				<div class="field">
					<label for="address">주소</label> <input type="text" name="address"
						value="<%=member.getAddress() %>" />
				</div>

				<div class="field half">
					<label>휴대폰</label> <input type="text" id="phoneNum" name="phone"
						value="<%=member.getPhone() %>" />
				</div>

				<div class="field half">
					<label>생년월일</label> <input type="text" name="birth" placeholder="0000-00-00" 
						value="<%=member.getBirth() %>" id="birthNum" />
						
				</div>
				<br>

				<div class="field half">
					<label>직업</label> <input type="text" name="gu_job"
						value="<%=member.getGu_job() %>" />
				</div>

				<div class="field half">
					<label>성별</label> <input type="text" name="gender"
						value="<%=member.getGender() %>" />
				</div>
				
				<div class="field half">
					<label>아두이노번호</label> <input type="text" name="furniture"
						value="<%=member.getFurniture() %>" />
				</div>

			</div>
			<ul class="actions">
				<li><input type="submit" value="정보수정" class="button fit"></li>
			</ul>
		</form>  
		<script>
			var autoHypen = function(str){
				str=str.replace(/[^0-9]/g, '');
				var tmp = '';
				if(str.length<4){
					return str;
				}else if(str.length<7){
					tmp += str.substr(0, 3);
					tmp += '-';
					tmp += str.substr(3);
					return tmp;
				}else if(str.length<11){
					tmp += str.substr(0,3);
					tmp += '-';
					tmp += str.substr(3,3);
					tmp += '-';
					tmp += str.substr(6);
					return tmp;
				}else{
					tmp += str.substr(0,3);
					tmp += '-';
					tmp += str.substr(3,4);
					tmp += '-';
					tmp += str.substr(7);
					return tmp;
				}
				return str;
			}
			
			var phoneNum = document.getElementById('phoneNum');
			
			phoneNum.onkeyup = function(){
				console.log(this.value);
				this.value=autoHypen(this.value);
			}
			
		</script>
		
		<script>
			var autoHypen2 = function(str){
				str=str.replace(/[^0-9]/g, '');
				var tmp = '';
				if(str.length<4){
					return str;
				}else if(str.length<7){
					tmp += str.substr(0, 4);
					tmp += '-';
					/* tmp += str.substr(2); */
					return tmp;
				}else{
					tmp += str.substr(0,4);
					tmp += '-';
					tmp += str.substr(4,2);
					tmp += '-';
					/* tmp += str.substr(2); */
					return tmp;
				}
				return str;
			}
			
			var birthNum = document.getElementById('birthNum');
			
			birthNum.onkeyup = function(){
				console.log(this.value);
				this.value=autoHypen2(this.value);
			}
			
		</script>
		
	
</body>
</html>