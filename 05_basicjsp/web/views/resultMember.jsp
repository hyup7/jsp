<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.ArrayList,com.member.model.vo.Member"%>
 <%
 	ArrayList<Member> members=(ArrayList<Member>)request.getAttribute("members");
 %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body> 
	<h4>조회된 회원결고ㅓ</h4>
	<table>
	<tr>
		<th>아이디</th>
		<th>패스워드</th>
		<th>이름</th>
		<th>포인트</th>
		</tr>
		<%if(members==null) {%>
		<tr>
		<td colspan="4">
			조회된 회원이 없습니다
			
		</td>
		</tr>
		<%}else{
			for(Member m:members){
			%>
	
		<% }
		}%>
	</table>
	

</body>
</html>