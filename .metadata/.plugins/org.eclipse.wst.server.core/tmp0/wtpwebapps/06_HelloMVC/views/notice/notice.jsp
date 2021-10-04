<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ page import="java.util.List,com.notice.model.vo.Notice" %>  
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>   

<%@ include file="/views/common/header.jsp"%>


<%

	String pageBar=(String)request.getAttribute("pageBar");
%>
<section id="notice-container">
        <h2>공지사항</h2>
        <input type="button" id="btn-add" value="글쓰기" onclick="location.assign('<%=request.getContextPath()%>/notice/noticeadd');">
        <table id="tbl-notice">
            <tr>
            
                <th>번호</th>
                <th>제목</th>
                <th>작성자</th>
                <th>첨부파일</th>
                <th>작성일</th>
            </tr>
            <c:if test="${empty noticelist }">
            	<td colspan="5">조회된 공지사항이 없읍니다</td>
            </c:if>
            <c:forEach var="n" items="${noticelist }" varStatus="vs">
            	<tr>
            		<td><c:out value="${n.noticeNo }"></c:out></td>
            		<td><a href="${pageContext.request.contextPath }/notice/noticein?no=${n.noticeNo}">${n.noticeTitle }</a></td>
            		<td>${n.noticeWriter }</td>
            		<td>${n.filepath }</td>
            		<td>${n.noticeDate }</td>
            	</tr>
            </c:forEach>
 
        </table>
               <div id="pageBar">
        	${pageBar }
        </div>
    </section>
    <script>
   
    </script> 
   


 <style>
     input#btn-add{float:right; margin: 0 0 15px;}
    table#tbl-notice{width:100%; margin:0 auto; border:1px solid black; border-collapse:collapse; clear:both; }
    section#notice-container{width:600px; margin:0 auto; text-align:center;}
    section#notice-container h2{margin:10px 0;}
    table#tbl-notice{width:100%; margin:0 auto; border:1px solid black; border-collapse:collapse;}
    table#tbl-notice th, table#tbl-notice td {border:1px solid; padding: 5px 0; text-align:center;} 
    </style>
<%@ include file="/views/common/footer.jsp"%>