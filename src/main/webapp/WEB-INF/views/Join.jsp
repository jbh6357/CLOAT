<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
</ul>
         <ul class="actions vertical">
            <li><h5>회원가입</h5></li>
            <form action="join_us" method="post">
               <li><input id="inputid" type= "text" name="id" placeholder="id를 입력하세요"></li>
               <li><span id="idCheckMsg"></span></li>
               <li><input type="password" name="pw"  placeholder="PW를 입력하세요"></li>
               <li><input type="text" name="name"  placeholder="이름을 입력하세요"></li>
               <li><input type="text" name="email"  placeholder="이메일을 입력하세요"></li>
               <li><input type="text" name="phone"  placeholder="전화번호를 입력하세요"></li>
               <li><input type="text" name="profile_img" placeholder="이미지를 업로드하세요"></li>
               <li><input type="hidden"  name="user_type" value ="NORMAL" placeholder=" "></li>
                <li><input type="submit" value="JoinUs" class="button fit"></li>
               </form>
         </ul>      
</body>
</html>