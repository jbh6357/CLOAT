<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="./includes/header.jsp"%>


<section class="main content">
	<h2>파일 업로드 완료</h2>

	<c:if test="${not empty uvo}">
		<p>
			<img
				src="${pageContext.request.contextPath}${uvo.upload_file}"
				alt="업로드한 이미지" style="max-width: 100%; height: auto;" />
		</p>
		<p>
			<img
				src="${pageContext.request.contextPath}${uvo.transformed_file}"
				alt="변환한 이미지" style="max-width: 100%; height: auto;" />
		</p>	
	</c:if>
</section>


<%@include file="./includes/footer.jsp"%>