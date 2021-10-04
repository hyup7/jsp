<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/views/common/header.jsp"%>
   <%@ page import="java.util.List,com.board.model.vo.Board" %>
   <%
   		List<Board> list =(List<Board>)request.getAttribute("boardlist");
   		String pagebar =(String)request.getAttribute("pageBar");
   %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<style>
	section#board-container{width:600px; margin:0 auto; text-align:center;}
	section#board-container h2{margin:10px 0;}
	table#tbl-board{width:100%; margin:0 auto; border:1px solid black; border-collapse:collapse; clear:both; }
	table#tbl-board th, table#tbl-board td {border:1px solid; padding: 5px 0; text-align:center;} 
	/*글쓰기버튼*/
	input#btn-add{float:right; margin: 0 0 15px;}
	/*페이지바*/
	div#pageBar{margin-top:10px; text-align:center; background-color:rgba(0, 188, 212, 0.3);}
	div#pageBar span.cPage{color: #0066ff;}
	</style>
	<section id="board-container">
		<h2>게시판 </h2>
		<input id="btn-add" type="button" onclick="location.assign('<%=request.getContextPath()%>/board/boardadd')" value="글쓰기">
		<table id="tbl-board">
			<tr>
				<th>번호</th>
				<th>제목</th>
				<th>작성자</th>
				<th>작성일</th>
				<th>첨부파일</th>
				<th>조회수</th>
			
			</tr>
			<c:if test="${empty list }">
					<td colspan="6">조회된 게시판이 없읍니다</td>
			</c:if>
    			
    			
					<% for(Board b:list){ %>
			<tr>
			
				<td><%=b.getBoardNo() %></td>
				<td>
					<a href="<%=request.getContextPath()%>/board/boardinfrom?no=<%=b.getBoardNo()%>"><%=b.getBoardTitle() %></a>
				</td>
				<td><%=b.getBoardWriter() %></td>
				<td><%=b.getBoardDate() %></td>
				<td>
					`<%if(b.getBoardOriginalFilename()!=null){%>
    				 	<img alt="첨부파일" src="<%=request.getContextPath()%>/upload/board/<%=b.getBoardOriginalFilename()%>" width="16px">
    				 <%} %>
				</td>
				<td><%=b.getBoardReadcount() %></td>
			</tr>
			<%} %>
		</table>

          <div id="pageBar">
     	<%=pagebar %>
        </div>
	</section>

<%@ include file="/views/common/footer.jsp"%>