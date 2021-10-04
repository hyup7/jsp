<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/views/common/header.jsp"%>
<%@ page import="com.notice.model.vo.Notice" %>
<%
	Notice n =(Notice)request.getAttribute("noitceview");
%>
<div id="notice-container">
        <table id="tbl-notice">
        <tr>
            <th>제 목</th>
            <td><%=n.getNoticeTitle() %></td>
        </tr>
        <tr>
            <th>작성자</th>
            <td><%=n.getNoticeWriter() %></td>
        </tr>
        <tr>
            <th>첨부파일</th>
            <td>
           	
           	<%if(n.getFilepath()!=null){ %>
           	<a href="<%=request.getContextPath()%>/fileDownload?filename=<%=n.getFilepath()%>">
           		<img src="<%=request.getContextPath()%>/upload/notice/<%=n.getFilepath()%>" width="400px" height="200px">
          	 </a>
           	<%} %>
            </td>
        </tr>
        <tr>
            <th>내 용</th>
            <td><%=n.getNoticeContent() %></td>
        </tr>
        <tr>
            <th colspan="2">
            <input type="button" value="목록으로" onclick="location.assign('<%=request.getContextPath()%>/notice/noticein');">
            
                <input type="button" value="수정하기" onclick="fn_update();">
                <input type="button" value="삭제하기" onclick="location.replace('<%=request.getContextPath()%>/notice/noticedelete?no=<%=n.getNoticeNo()%>&filename=<%=n.getFilepath()%>');">
            </th>
        </tr>
    </table>
    </div>

<script>
	const fn_update=()=>{
		location.assign('<%=request.getContextPath()%>/notice/noticeupdate?no=<%=n.getNoticeNo()%>&filename=<%=n.getFilepath()%>');
	}
</script>
     <style>
         input#btn-add{float:right; margin: 0 0 15px;}
    table#tbl-notice{width:100%; margin:0 auto; border:1px solid black; border-collapse:collapse; clear:both; }
    section#notice-container{width:600px; margin:0 auto; text-align:center;}
    section#notice-container h2{margin:10px 0;}
    table#tbl-notice{width:500px; margin:0 auto; border:1px solid black; border-collapse:collapse; clear:both; }
    table#tbl-notice th {width: 125px; border:1px solid; padding: 5px 0; text-align:center;} 
    table#tbl-notice td {border:1px solid; padding: 5px 0 5px 10px; text-align:left;}
    </style>

<%@ include file="/views/common/footer.jsp"%>