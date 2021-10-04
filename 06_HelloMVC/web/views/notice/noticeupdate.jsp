<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/views/common/header.jsp"%>
<%@ page import="com.notice.model.vo.Notice" %>
<%
	Notice n=(Notice)request.getAttribute("notice");
%>
<div id="notice-container">
	<form action="<%=request.getContextPath() %>/notice/noticeupdateend?no=<%=n.getNoticeNo() %>" method="post" enctype="multipart/form-data">
        <table id="tbl-notice">
        <tr>
            <th>제 목</th>
            <td><input type="text" name="noticetitle"
                value=<%=n.getNoticeTitle()%> >
   
            </td>
        </tr>
        <tr>
            <th>작성자</th>
            <td><input type="text" name="noticewriter" readonly
            value="<%=n.getNoticeWriter()%>">
            </td>
        </tr>
        <tr>
            <th>첨부파일</th>
            <td style="position:relative;">
            <%if(n.getFilepath()!=null){ %>
           	<input type="file" name="up_file">
           	<span id="fname"><%=n.getFilepath()%></span>
           	<input type="hidden" name="oldfile" value="<%=n.getFilepath() %>">
			<%}else{ %>
			<input type="file" name="up_file">
			<%} %>           	
            </td>
        </tr>
        <tr>
            <th>내 용</th>
            <td><textarea cols="50" rows="5" name="content"><%=n.getNoticeContent() %></textarea></td>
        </tr>
        <tr>
            <th colspan="2">            
                <input type="submit" value="수정하기">
                <input type="reset" value="취소하기" >
            </th>
        </tr>
    </table>
    </form>
    </div>
    <script>
    	$("input[type=file]").change(e=>{
    		if($(e.target).val()==""){
    			$("#fname").show();
    		}else{
    			$("#fname").hide();
    		}
    	})
    	
    </script>
      <style>
      
      span#fname{position:absolute;left:86px;top:9px;width:285px;
      background-color:#F5F5F5}
         input#btn-add{float:right; margin: 0 0 15px;}
    table#tbl-notice{width:100%; margin:0 auto; border:1px solid black; border-collapse:collapse; clear:both; }
    section#notice-container{width:600px; margin:0 auto; text-align:center;}
    section#notice-container h2{margin:10px 0;}
    table#tbl-notice{width:500px; margin:0 auto; border:1px solid black; border-collapse:collapse; clear:both; }
    table#tbl-notice th {width: 125px; border:1px solid; padding: 5px 0; text-align:center;} 
    table#tbl-notice td {border:1px solid; padding: 5px 0 5px 10px; text-align:left;}
    </style>

<%@ include file="/views/common/footer.jsp"%>

