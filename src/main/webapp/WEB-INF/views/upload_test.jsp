<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="./includes/header.jsp" %>
   <section class="main content">
   		<form action="do_upload" method = "post" name="frm" enctype="multipart/form-data">
   			<p>이미지 <input type="file" name="file"></p>
   			<input type="submit">
   </section>
<%@include file="./includes/footer.jsp" %>