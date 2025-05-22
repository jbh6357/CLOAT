<%@include file="/WEB-INF/views/includes/header.jsp" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<section class="content">
	<div class="inner inner_500">
		<div class="join_success">
			<img src="resources/images/welcome.png" alt="가입 완료">
			<h1><b><%=request.getParameter("id") %></b>님, 환영합니다!🎉</h1>
			<p>안전한 인터넷, 행복한 얼굴, <br>이제 CLOAT와 함께하세요!</p>
			<div class="bttn_wrap">
			  <a href="${pageContext.request.contextPath}" class="bttn_sbm">바로 시작하기</a>
			</div>
		</div>
	</div>
</section>
<%@include file="/WEB-INF/views/includes/footer.jsp"%>