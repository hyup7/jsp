<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    	String msg=(String)request.getAttribute("msg");
    	String loc=(String)request.getAttribute("loc");
    	
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>알람메시지</title>
</head>
<body>
	<script>
		alert('<%=msg%>');			
		<%=request.getAttribute("script")!=null?request.getAttribute("script"):" "%>
		location.replace('<%=request.getContextPath()%><%=loc%>');
	</script>
	
	
</body>
</html>