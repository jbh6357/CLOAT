<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
    <!-- Wrapper -->
         <div id="wrapper">
            <!-- Menu -->
               <nav id="Update">   
                  <ul class="actions vertical">
                     <li><h1>환영합니다!</h1></li>
                     <li>회원가입을 축하합니다.</li>
                     <!-- request영역에 저장된 회원정보 중 이메일을 출력하시오. -->
                     <li>당신의 ID는 : <%=request.getParameter("id") %>입니다.</li>
                     <li><button onclick='location.href="./"'>시작하기</button></li>
                  </ul>
               </nav>         
         </div>
</body>
</html>