<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/views/common/header.jsp"%>
<%@ page import="com.board.model.vo.Board" %>
<%@ page import="com.board.model.vo.BoardComment,java.util.List" %>

<%
	Board b =(Board)request.getAttribute("board");
	List<BoardComment> list =(List<BoardComment>)request.getAttribute("boardcomment");
	
%>
<style>
    section#board-container{width:600px; margin:0 auto; text-align:center;}
    section#board-container h2{margin:10px 0;}
    table#tbl-board{width:500px; margin:0 auto; border:1px solid black; border-collapse:collapse; clear:both; }
    table#tbl-board th {width: 125px; border:1px solid; padding: 5px 0; text-align:center;} 
    table#tbl-board td {border:1px solid; padding: 5px 0 5px 10px; text-align:left;}
     div#comment-container button#btn-insert{width:60px;height:50px; color:white;
    background-color:#3300FF;position:relative;top:-20px;}
        /*댓글테이블*/
    table#tbl-comment{width:580px; margin:0 auto; border-collapse:collapse; clear:both; } 
    table#tbl-comment tr td{border-bottom:1px solid; border-top:1px solid; padding:5px; text-align:left; line-height:120%;}
    table#tbl-comment tr td:first-of-type{padding: 5px 5px 5px 50px;}
    table#tbl-comment tr td:last-of-type {text-align:right; width: 100px;}
    table#tbl-comment button.btn-reply{display:none;}
    table#tbl-comment button.btn-delete{display:none;}
    table#tbl-comment tr:hover {background:lightgray;}
    table#tbl-comment tr:hover button.btn-reply{display:inline;}
    table#tbl-comment tr:hover button.btn-delete{display:inline;}
    table#tbl-comment tr.level2 {color:gray; font-size: 14px;}
    table#tbl-comment sub.comment-writer {color:navy; font-size:14px}
    table#tbl-comment sub.comment-date {color:tomato; font-size:10px}
    table#tbl-comment tr.level2 td:first-of-type{padding-left:100px;}
    table#tbl-comment tr.level2 sub.comment-writer {color:#8e8eff; font-size:14px}
    table#tbl-comment tr.level2 sub.comment-date {color:#ff9c8a; font-size:10px}
    /*답글관련*/
    table#tbl-comment textarea{margin: 4px 0 0 0;}
    table#tbl-comment button.btn-insert2{width:60px; height:23px; color:white; background:#3300ff; position:relative; top:-5px; left:10px;}
   	div#comment-container{text-align:center}
    </style>
   
		<div id="board-container">
		<h2>게시판</h2>
		<table id="tbl-board">
			<tr>
				<th>글번호</th>
				<td><%=b.getBoardNo() %></td>
				
			</tr>
			<tr>
				<th>제 목</th>
				<td><%=b.getBoardTitle()%></td>
			</tr>
			<tr>
				<th>작성자</th>
				<td><%=b.getBoardWriter()%></td>
			</tr>
			<tr>
				<th>조회수</th>
				<td><%=b.getBoardReadcount() %></td>
			</tr>
			<tr>
				<th>첨부파일</th>
				<td>
				 <%if(b.getBoardOriginalFilename()!=null){ %>
				 <a href="<%=request.getContextPath()%>/board/filedown?name=<%=b.getBoardOriginalFilename()%>&rename=<%=b.getBoardRenamedFilename()%>">
				 	<img src="<%=request.getContextPath()%>/upload/board/file.png">
				 	</a>
				 <%}else{ %>
				 	첨부파일 없음
				 <%} %>
				</td>
			</tr>
			<tr>
				<th>내 용</th>
				<td><%=b.getBoardContent() %></td>
			</tr>
			<%--글작성자/관리자인경우 수정삭제 가능 --%>
			
			<tr>
				<th colspan="2">
				<button onclick="location.assign('<%=request.getContextPath()%>/board/boardlist')">목록으로</button>
				<button onclick="location.assign('<%=request.getContextPath()%>/board/boardupdate?no=<%=b.getBoardNo()%>')">수정하기</button>
				<button onclick="fn_delete();">삭제하기</button>
				
					수정하기, 삭제하기 버튼
				</th>
			</tr>		
		</table>
		<div id="comment-container">
			<div class="comment-editor">
			 <form action="<%=request.getContextPath() %>/board/insertComment" method="post">
			 <textarea name="content" cols="55" rows="3"></textarea>
			 <input type="hidden" name="level" value="1">
			 <input type="hidden" name="commentWriter" value="<%=loginMember.getUserId()%>">
			 <input type="hidden" name="boardRef" value="<%=b.getBoardNo() %>">
			 <input type="hidden" name="commentRef" value="0">
			 <button type="submit" id="btn-insert">등록</button>
			 </form>
			</div>
			<table id="tbl-comment">
			<%for(BoardComment bc :list){ 
			if(bc.getBoardCommentLevel()==1){%>
			<tr class="level1">
				<td>
					<sub class="comment-writer"><%=bc.getBoardCommentWriter() %></sub>
					<sub class="comment-date"><%=bc.getBoardCommentDate() %></sub>
					<br><%=bc.getBoardCommentContent() %>
				</td>
				<td>
					<button class="btn-reply" value="<%=bc.getBoardCommentNo()%>">답글달기</button>
					<button class="btn-delete" onclick="<%=request.getContextPath()%>/board/commentdel?no=<%=bc.getBoardCommentNo()%>">답글삭제</button>
				</td>
			</tr>
			<%}else if(bc.getBoardCommentLevel()==2){%>
			 <tr class="level2">
				<td>
					<sub class="comment-writer"><%=bc.getBoardCommentWriter() %></sub>
					<sub class="comment-date"><%=bc.getBoardCommentDate() %></sub>
					<br><%=bc.getBoardCommentContent() %>
				</td>
				<td>
					<button class="btn-delete">답글삭제</button>
				</td>
			</tr>
			<% }}%>
			
			</table>
		</div>
    </div>
<%@ include file="/views/common/footer.jsp"%>

<script>

	const fn_delete=()=>{
		if(confirm("정말로 삭제하시겠습끼?")==true){
			location.assign("<%=request.getContextPath()%>/board/boarddel?no=<%=b.getBoardNo()%>&filename=<%=b.getBoardOriginalFilename()%>");
		}
	}
	
	$(".btn-reply").click(e=>{
		const tr=$("<tr>");
		const form=$(".comment-editor>form").clone();
		console.log(form);
		form.find("textarea").attr("rows","1");
		form.find("[name=level]").val("2");
		form.find("[name=commentRef]").val($(e.target).val());
		form.find("button").removeAttr("id").addClass("btn-insert2");
		
		const td=$("<td>").attr("colspan","2");
		tr.append(td.append(form));
		tr.find("td").css("display","none");
		
		tr.insertAfter($(e.target).parents("tr")).children("td").slideDown(800);
		
		$(e.target).off("click");
	});
	
	$(".comment-editor textarea").focus(e=>{
		if(<%=loginMember==null%>){
			alert("로그인 후 이욯하세요!");
			$("#userId").focus();
		})
	});
</script>