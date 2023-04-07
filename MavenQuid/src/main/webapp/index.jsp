<%@page import="com.smhrd.model.WebMember1"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8" />
		<meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=no" />
		<link rel="stylesheet" href="assets/css/main.css" />
		<noscript><link rel="stylesheet" href="assets/css/noscript.css" /></noscript>
	</head>
	<body class="is-preload">
		<%
			//session 값 가져오기
				WebMember1 loginMember = (WebMember1) session.getAttribute("loginMember");
				
				if(loginMember != null){
					System.out.print(loginMember.getGu_id());
		} %>

		
		<!-- Wrapper -->

			<div id="wrapper">
					
				<!-- Header -->
				
					<header id="header">
						<div class="logo">
							<img src = images/logo_1.png >
							
						</div>
						<div class="content">
							<div class="inner">
								<h1>고독사에서 당신을 구하다</h1>
								<p>우리는 어쩌고 저쩌고를 지원해 줄거야 너는 그냥 써</p>
							</div>
						</div>
						<nav>
				<%		if(loginMember != null){
					
			%>
			<p style="text-align:center" !important>	<%=loginMember.getGu_name() %>님 로그인</p>
		<%	} %>
							<ul>
								<% if(loginMember != null) %>
								<li><a href="#intro">Intro</a></li>
								<li><a href="#work">Work</a></li>
								<li><a href="#about">About</a></li>
								
								<% if(loginMember == null){ %>
										<li> <a href="#login">로그인</a> </li>
									<% } else {
										if(loginMember.getGu_id().equals("admin")){ %>
										<li> <a href="select.jsp">회원정보확인</a> </li>
										<li> <a href="LogoutService">로그아웃</a> </li>
										<%}else{ %>
										<li> <a href="#update">정보수정</a> </li>
										<li> <a href="LogoutService">로그아웃</a> </li>
									<% }} %>
								
							</ul>
						</nav>
					</header>

				<!-- Main -->
					<div id="main">

						<!-- Intro -->
							<article id="intro">
								<h2 class="major">Intro</h2>
								<p >당신의 안전과 행복을 위해, 저희는 고독사 대처 및 예방 IoT 프로젝트를 진행하고 있습니다. 
									이 프로젝트는 응급상황에 대처할 수 없는 독거노인분들이나 혼자 생활하는 사람들을 위해, 
									생활 공간에서 벌어지는 긴급 상황을 감지하고 조치를 취할 수 있는 시스템을 구축하는 것을 목표로 만들어진 프로젝트입니다. </p>
								
								<p>저희 IoT 시스템은 다양한 센서를 사용하여, 특정한 환경에서 벌어지는 상황을 감지하고, 
									이를 기반으로 긴급 상황에 대처할 수 있는 알림 및 구조 조치를 제공하고 있습니다. 
									예를 들어, 움직임 센서 및 수압센서는 보호대상자의 움직임 및 물 사용을 감지하고, 
									생명활동에 대한 정보를 수집하며, 급작스럽게 일어날 수 있는 긴급 상황을 예방할 수 있습니다.</p>
								
									<p>또한, 우리의 시스템은 상시 모니터링과 상호작용을 통해, 보호대상자분들이 혼자서 생활하는 경우에도 안심할 수 있는 시스템을 제공합니다. 이를 통해, 
										자신의 삶을 더욱 독립적으로 유지하면서도 안전하게 살아갈 수 있습니다.
										저희는 "고독사에서 당신을 구하다"는 모토를 가지고 있습니다. 고독사는 요즘 사회에서 대두되는 고민거리입니다. 하지만 우리는 이 고민거리를 함께 극복할 수 있습니다. 
										저희의 IoT 기술은 당신들의 안전과 행복을 지켜드리며,  사용자들이 편안한 생활을 할 수 있도록 도우미가 되어 드립니다.
										저희와 함께, 삶의 가치를 지켜나갈 수 있는 Cuidamos 제품을 체험해보세요. </p>
								
							</article>

						<!-- Work -->
							<article id="work">
								<h2 class="major">Work</h2>
								<span class="image main"><img src="" alt="" /></span>
								<p>소개글</p>
								
							</article>

						<!-- About -->
							<article id="about">
								<h2 class="major">About</h2>
								<span class="image main"><img src="" alt="" /></span>
								<p>소개글</p>
							</article>
						
						<!-- login -->
							<article id="login">
								<h2 class="major">login</h2>
								<form method="post" action="LoginService">
									<input type="text" name="gu_id" class="text-field" placeholder="아이디를 입력하세요">
									<input type="password" name="pw" class="text-field" placeholder="비밀번호를 입력하세요">
									<input type="submit" value="로그인" class="submit-btn">
									
									<a href="#join"><input type="button" value="회원가입" class="submit-btn" /></a>
								  </form>
							</article>

					<%if(loginMember != null) { %>
 							<article id="update">
								<h2 class="major">정보수정</h2>
								<form method="post" action="UpdateService">
									<div class="fields">
										
										<div class="field half">
											<label>아이디</label>
											<input type="text" value="<%=loginMember.getGu_id()%>" name="gu_id" readonly/>
										</div>
										
										<div class="field half">
											<label>비밀번호</label>
											<input type="password" name="pw" id="pw" value="<%=loginMember.getPw() %>"/>
										</div>
										
										<div class="field half">
											<label>이름</label> 
											<input type="text" name="gu_name" value="<%=loginMember.getGu_name() %>"/>
										</div>
										
										<div class="field">
											<label for="address">주소</label>
											<input type="text" name="address" value="<%=loginMember.getAddress() %>"/>
										</div>
										
										<div class="field half">
											<label>휴대폰</label> 
											<input type="text" name="phone" value="<%=loginMember.getPhone() %>" id="phoneNum" />
										</div>
										
										<div class="field half">
											<label>생년월일</label> 
											<input type="text" name="birth" value="<%=loginMember.getBirth() %>"/>
										</div>
										
										<div class="field half">
											<label>직업</label> 
											<input type="text" name="gu_job" value="<%=loginMember.getGu_job() %>"/>
										</div>
										
										<div class="field half">
											<label>성별</label> 
											<input type='text' name='gender' value="<%=loginMember.getGender() %>" />
  										
										
										</div>
										
										<div class="field half">
											<label>아두이노번호</label> 
											<input type="text" name="furniture" value="<%=loginMember.getFurniture() %>"/>
										</div>
										
									</div>
									<ul class="actions">
										<li><input type="submit" value="정보수정" class="submit-btn"></li>
									</ul>
								</form>
								
							</article>
							<%} %>
							

							
							<article id="join">
								<h2 class="major">회원가입</h2>
								<form method="post" action="JoinService">
									<div class="fields">
										<div class="field half">
											<label for="name">아이디</label>
											<input type="text" name="gu_id" id="id" />
										</div>
										
										<div class="field half">
											<label for="pw">비밀번호</label>
											<input type="password" name="pw" id="pw" />
										</div>
										<div class="field half">
											<label for="name">이름</label> 
											<input type="text" name="gu_name" />
										</div>
										
										<div class="field">
											<label for="address">주소</label>
											<input type="text" name="address" />
										</div>
										
										<div class="field half">
											<label>휴대폰</label> 
											<input type="text" name="phone" id="phoneNum"/>
										</div>
										
										<div class="field half">
											<label>직업</label> 
											<input type="text" name="birth" />
										</div>
										
										<div class="field half">
											<label>생년월일</label> 
											<input type="text" name="gu_job" />
										</div>
										
										<div class="field half">
											<label>성별</label> 
											<input type="text" name="gender" />
										</div>
										
										<div class="field half">
											<label>아두이노번호</label> 
											<input type="text" name="furniture" />
										</div>
										
									</div>
									<ul class="actions">
										<li><input type="submit" value="회원가입" class="submit-btn"></li>
									</ul>
								</form>
								
							</article>

						<!-- Elements -->
							<article id="elements">
								<h2 class="major">Elements</h2>

								<section>
									<h3 class="major">Text</h3>
									<p>This is <b>bold</b> and this is <strong>strong</strong>. This is <i>italic</i> and this is <em>emphasized</em>.
									This is <sup>superscript</sup> text and this is <sub>subscript</sub> text.
									This is <u>underlined</u> and this is code: <code>for (;;) { ... }</code>. Finally, <a href="#">this is a link</a>.</p>
									<hr />
									<h2>Heading Level 2</h2>
									<h3>Heading Level 3</h3>
									<h4>Heading Level 4</h4>
									<h5>Heading Level 5</h5>
									<h6>Heading Level 6</h6>
									<hr />
									<h4>Blockquote</h4>
									<blockquote>Fringilla nisl. Donec accumsan interdum nisi, quis tincidunt felis sagittis eget tempus euismod. Vestibulum ante ipsum primis in faucibus vestibulum. Blandit adipiscing eu felis iaculis volutpat ac adipiscing accumsan faucibus. Vestibulum ante ipsum primis in faucibus lorem ipsum dolor sit amet nullam adipiscing eu felis.</blockquote>
									<h4>Preformatted</h4>
									<pre><code>i = 0;

while (!deck.isInOrder()) {
    print 'Iteration ' + i;
    deck.shuffle();
    i++;
}

print 'It took ' + i + ' iterations to sort the deck.';</code></pre>
								</section>

								<section>
									<h3 class="major">Lists</h3>

									<h4>Unordered</h4>
									<ul>
										<li>Dolor pulvinar etiam.</li>
										<li>Sagittis adipiscing.</li>
										<li>Felis enim feugiat.</li>
									</ul>

									<h4>Alternate</h4>
									<ul class="alt">
										<li>Dolor pulvinar etiam.</li>
										<li>Sagittis adipiscing.</li>
										<li>Felis enim feugiat.</li>
									</ul>

									<h4>Ordered</h4>
									<ol>
										<li>Dolor pulvinar etiam.</li>
										<li>Etiam vel felis viverra.</li>
										<li>Felis enim feugiat.</li>
										<li>Dolor pulvinar etiam.</li>
										<li>Etiam vel felis lorem.</li>
										<li>Felis enim et feugiat.</li>
									</ol>
								
									<h4>Actions</h4>
									<ul class="actions">
										<li><a href="#" class="button primary">Default</a></li>
										<li><a href="#" class="button">Default</a></li>
									</ul>
									<ul class="actions stacked">
										<li><a href="#" class="button primary">Default</a></li>
										<li><a href="#" class="button">Default</a></li>
									</ul>
								</section>

								<section>
									<h3 class="major">Table</h3>
									<h4>Default</h4>
									<div class="table-wrapper">
										<table>
											<thead>
												<tr>
													<th>Name</th>
													<th>Description</th>
													<th>Price</th>
												</tr>
											</thead>
											<tbody>
												<tr>
													<td>Item One</td>
													<td>Ante turpis integer aliquet porttitor.</td>
													<td>29.99</td>
												</tr>
												<tr>
													<td>Item Two</td>
													<td>Vis ac commodo adipiscing arcu aliquet.</td>
													<td>19.99</td>
												</tr>
												<tr>
													<td>Item Three</td>
													<td> Morbi faucibus arcu accumsan lorem.</td>
													<td>29.99</td>
												</tr>
												<tr>
													<td>Item Four</td>
													<td>Vitae integer tempus condimentum.</td>
													<td>19.99</td>
												</tr>
												<tr>
													<td>Item Five</td>
													<td>Ante turpis integer aliquet porttitor.</td>
													<td>29.99</td>
												</tr>
											</tbody>
											<tfoot>
												<tr>
													<td colspan="2"></td>
													<td>100.00</td>
												</tr>
											</tfoot>
										</table>
									</div>

									<h4>Alternate</h4>
									<div class="table-wrapper">
										<table class="alt">
											<thead>
												<tr>
													<th>Name</th>
													<th>Description</th>
													<th>Price</th>
												</tr>
											</thead>
											<tbody>
												<tr>
													<td>Item One</td>
													<td>Ante turpis integer aliquet porttitor.</td>
													<td>29.99</td>
												</tr>
												<tr>
													<td>Item Two</td>
													<td>Vis ac commodo adipiscing arcu aliquet.</td>
													<td>19.99</td>
												</tr>
												<tr>
													<td>Item Three</td>
													<td> Morbi faucibus arcu accumsan lorem.</td>
													<td>29.99</td>
												</tr>
												<tr>
													<td>Item Four</td>
													<td>Vitae integer tempus condimentum.</td>
													<td>19.99</td>
												</tr>
												<tr>
													<td>Item Five</td>
													<td>Ante turpis integer aliquet porttitor.</td>
													<td>29.99</td>
												</tr>
											</tbody>
											<tfoot>
												<tr>
													<td colspan="2"></td>
													<td>100.00</td>
												</tr>
											</tfoot>
										</table>
									</div>
								</section>

								<section>
									<h3 class="major">Buttons</h3>
									<ul class="actions">
										<li><a href="#" class="button primary">Primary</a></li>
										<li><a href="#" class="button">Default</a></li>
									</ul>
									<ul class="actions">
										<li><a href="#" class="button">Default</a></li>
										<li><a href="#" class="button small">Small</a></li>
									</ul>
									<ul class="actions">
										<li><a href="#" class="button primary icon solid fa-download">Icon</a></li>
										<li><a href="#" class="button icon solid fa-download">Icon</a></li>
									</ul>
									<ul class="actions">
										<li><span class="button primary disabled">Disabled</span></li>
										<li><span class="button disabled">Disabled</span></li>
									</ul>
								</section>

								<section>
									<h3 class="major">Form</h3>
									<form method="post" action="#">
										<div class="fields">
											<div class="field half">
												<label for="demo-name">Name</label>
												<input type="text" name="demo-name" id="demo-name" value="" placeholder="Jane Doe" />
											</div>
											<div class="field half">
												<label for="demo-email">Email</label>
												<input type="email" name="demo-email" id="demo-email" value="" placeholder="jane@untitled.tld" />
											</div>
											<div class="field">
												<label for="demo-category">Category</label>
												<select name="demo-category" id="demo-category">
													<option value="">-</option>
													<option value="1">Manufacturing</option>
													<option value="1">Shipping</option>
													<option value="1">Administration</option>
													<option value="1">Human Resources</option>
												</select>
											</div>
											<div class="field half">
												<input type="radio" id="demo-priority-low" name="demo-priority" checked>
												<label for="demo-priority-low">Low</label>
											</div>
											<div class="field half">
												<input type="radio" id="demo-priority-high" name="demo-priority">
												<label for="demo-priority-high">High</label>
											</div>
											<div class="field half">
												<input type="checkbox" id="demo-copy" name="demo-copy">
												<label for="demo-copy">Email me a copy</label>
											</div>
											<div class="field half">
												<input type="checkbox" id="demo-human" name="demo-human" checked>
												<label for="demo-human">Not a robot</label>
											</div>
											<div class="field">
												<label for="demo-message">Message</label>
												<textarea name="demo-message" id="demo-message" placeholder="Enter your message" rows="6"></textarea>
											</div>
										</div>
										<ul class="actions">
											<li><input type="submit" value="Send Message" class="primary" /></li>
											<li><input type="reset" value="Reset" /></li>
										</ul>
									</form>
								</section>

							</article>

					</div>

				<!-- Footer -->
					<footer id="footer">
						<p class="copyright">&copy; by Design CUIDAMOS </p>
					</footer>

			</div>

		<!-- BG -->
			<div id="bg"></div>

		<!-- Scripts -->
			<script src="assets/js/jquery.min.js"></script>
			<script src="assets/js/browser.min.js"></script>
			<script src="assets/js/breakpoints.min.js"></script>
			<script src="assets/js/util.js"></script>
			<script src="assets/js/main.js"></script>
			
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

	</body>
</html>