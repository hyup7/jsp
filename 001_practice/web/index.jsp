<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	 <fieldset>
	 <legend>로그인창</legend>
	 <form action="login.do" method="post">
	 <%if(session.getAttribute("id")!=null) {%>
	 <p><%=session.getAttribute("id")%>님 환영합니다
	 <button type="button" onclick="location.assign('<%=request.getContextPath()%>/logout.do')">로그아웃</button></p>
	 <%}else{ %>
	 <input type="text" name="id"> <br>
	 <input type="password" name="pw"> <br>
	 <input type="submit" value="로그인">
	 <%} %>
	 </form>
	 
	 </fieldset>
	 
</body>
</html>