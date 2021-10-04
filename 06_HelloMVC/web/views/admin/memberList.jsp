
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="java.util.List,com.member.model.vo.Member" %>
    <%
    	List<Member> list=(List<Member>)request.getAttribute("list");
    	String key=request.getParameter("searchKeyword");
    	String type=request.getParameter("searchType");
    	String pagebar=(String)request.getAttribute("pageBar");
    	
    
    %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ include file="/views/common/header.jsp"%>
<style type="text/css">
    section#memberList-container {text-align:center;}
    
    section#memberList-container table#tbl-member {width:100%; border:1px solid gray; border-collapse:collapse;}
    section#memberList-container table#tbl-member th, table#tbl-member td {border:1px solid gray; padding:10px; }
        div#search-container {margin:0 0 10px 0; padding:3px; 
    background-color: rgba(0, 188, 212, 0.3);}
    div#search-userId{display:inline-block;}
    div#search-userName{display:none;}
    div#search-gender{display:none;}
    div#numPerpage-container{float:right;}
    form#numperPageFrm{display:inline;}
    </style>
    
    <section id="memberList-container">
        <h2>회원관리</h2>
        <div id="search-container">
        검색타입:
        <select id="searchType">
        <option value="userId" <%=type!=null&&type.equals("userId")?"selected":"" %>>아이디</option>
        <option value="userName" <%=type!=null&&type.equals("userName")?"selected":"" %>>회원이름</option>
        <option value="gender" <%=type!=null&&type.equals("gender")?"selected":"" %>>성별</option>
        </select>
        <div id="search-userId">
        <form action="<%=request.getContextPath() %>/admin/searchMemberList" method="post">
        	<input type="text" name="searchKeyword" size="25" placeholder="검색할 아이디를 입력해주세요" value="<%=type!=null&&type.equals("userId")?key:""%>">
        	<input type="hidden" name="searchType" value="userId">
        	<button type="submit">조회</button>
        </form>
        </div>
            <div id="search-userName">
        <form action="<%=request.getContextPath() %>/admin/searchMemberList" method="post">
        	<input type="text" name="searchKeyword" size="25" placeholder="검색할 회원이름를 입력해주세요" value="<%=type!=null&&type.equals("userName")?key:""%>">
        	<input type="hidden" name="searchType" value="userName">
        	<button type="submit">조회</button>
        </form>
        </div>
            <div id="search-gender">
        <form action="<%=request.getContextPath() %>/admin/searchMemberList" method="post">
        	<label><input type="radio" name="searchKeyword" value="M <%=type!=null&&type.equals("gender")&&key.equals("M")?"checked":""%>">남</label>
        	<label><input type="radio" name="searchKeyword" value="F <%=type!=null&&type.equals("gender")&&key.equals("F")?"checked":""%>">여</label>
        	<input type="hidden" name="searchType" value="gender">
        	<button type="submit">조회</button>
        </form>
        </div>
        </div>
        <div id="numPerpage-container">
        	페이지당 회원수 :
        	<form id="numPerFrm" action="">
        		<select name="numPerapge" id="numPerpage">
        			<option value="10">10</option> 
        			<option value="5" selected>5</option> 
        			<option value="3">3</option> 
        		</select>
        	</form>
        </div>
        <table id="tbl-member">
            <thead>
                <tr>
                    <th>아이디</th>
		    <th>이름</th>
		    <th>성별</th>
		    <th>나이</th>
		    <th>이메일</th>
		    <th>전화번호</th>
		    <th>주소</th>
		    <th>취미</th>
		    <th>가입날짜</th>
                </tr>
            </thead>
            <tbody>
            <c:if test="${empty list }">
            	<tr>
    				<td colspan="9">조회된 회원이 없읍니다</td>
    			</tr>		
            </c:if>
            <c:forEach var="m" items="${list }">
            	<tr>
    				 <td>${m.userid }</td>
    				 <td>${m.username }</td>
    				 <td>${m.gender }</td>
    				 <td>${m.age }</td>
    				 <td>${m.email }</td>
    				 <td>${m.phone }</td>
    				 
    				 <td>${m.address }</td>
    				 <td>${m.hobby }</td>
    				 <td>${m.enrolldate }</td>
    				</tr>
            </c:forEach>
   
            </tbody>
        </table>
        <div id="pageBar">
        	${pagebar }
        </div>
    </section>
    <script>
  
    $("#numPerpage").change((e)=>{
    	var numPerpage=$(e.target).val();
    	console.log($("#numPerpage"));
    	 $("#numPerpage").children().removeAttr("selected");
    	$(e.target).attr("selected","selected");
    	location.assign('<%=request.getContextPath()%>/admin/memberList?numPerpage='+numPerpage);
    	
    });
   	
   	 
    $("#searchType").change((e)=>{
    	 let type=$("#searchType").val();
    	console.log(type);
    	if(type=="userId"){
    		$("#search-userId").css("display","inline-block");
    		$("#search-userName").css("display","none");
    		$("#search-gender").css("display","none");	
    	}
    	if(type=="userName"){
    		$("#search-userId").css("display","none");
    		$("#search-userName").css("display","inline-block");
    		$("#search-gender").css("display","none");	
    	}
       	if(type=="gender"){
    		$("#search-userId").css("display","none");
    		$("#search-userName").css("display","none");
    		$("#search-gender").css("display","inline-block");	
    	}
    	
    })
    
    
    </script>
    <%@ include file="/views/common/footer.jsp"%>