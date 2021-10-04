
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>나의 첫 jsp페이지</title>
</head>
<body>
	<h1>안녕, 나의 첫 jsp페이지</h1>
	<p>
		jsp태그는 html 문서에 자바코드를 사용할ㅆ 수 있개 하는 태그, 그 태그는 &lt;%&gt;방식으로 사용
		->태그에 %가 있으면 자바코드로 해석한다
		기본 자바코드를 작성할때는 스트릡트태그를 이용 &lt;%&gt;임.
		지역변수,if문 for문 while문 switch문, 메소드호출 등등....
		선언문 &lt;%!&gt; 
		멤버변수선언,메소드 선언을 할때 사용
	</p>
	
	<h2>선언문태그 이용하기</h2>
	<p>html문서에 자바코드를 사용할 때 이용하는 태그로 calss선언부에 사용해야하는 코드를 작성할때 사용
	
	</p>
	<%!
	
		
		//선언문입니다!
		//멤머변수로 변수선언하기
		private String name ="유지훈";
		//메소드 선언
		public String printTest(){
			return "이지곧 쉬는쉬간";
			
		
		}
		
		//선언문에서 지역변수 선언은 가능할까?
		int age;//->default접근제한자
		
		//메소드 선언이 가능할까?
		// printTest(); 메소드 호출 불가
		
		//조건전 사용이 가능할까?
		//if(name.equlas("유병승")){
			
		//	}
		
	%>
	<h2>선언문에 있는 내용출력 - > 표현 태그를 사용한다</h2>
	<h3>당신의 이름은 <%=name %></h3>
	<h3>당신의 나이는 <%=age %></h3>
	<h4>메세지 : <%=printTest() %></h4>
	
	<h2>스크립트립이용ㅎ라기</h2>
	<p>지역변수,메소드호출,if문,switch문,for문,while문 ... 사용이가능</p>
	
	<%
		//스크립트립 태그
		String adress="경기도 시응힛";
		//접근제한가 사용이 가능가ㅣ?
		//private double height;
		
		//조건문을 사용할 수 있을까?
		if(name.equals("유지훈")){
			System.out.println("r클래스 반장님");
		}
		switch(name){
		
		case "유병승" :System.out.println("r클래스 반장님");break;
		case "유지훈" :System.out.println("r클래스 반장님");break;
		default :System.out.println("r클래스 반장님");break;
		
		}
		
		for(int i=0;i<10;i++){
			System.out.println(i);
		}
		System.out.println(printTest());
		
		//메소드호출가능?
		String[] dinner={"소세지","양념치킨","떡갈비","초코파이"};
		name="우병승";
	%>
	<h2>페이지 출력시 jsp태그 이용하기</h2>
	<p>이름이 유지훈이면 R클래스 반장이다 출력</p>
	<%if(name.equals("유지훈")){ %>
		<h2><%=name %>R클래스 반장이다다다다!</h2>
	<%}else{%>
	<h2><%=name %>수강생입니다!</h2>
	<%} %>
	<h3>오늘의 저녁메뉴</h3>
	<ul>
		<%for(int i=0;i<dinner.length;i++){%>
		<%if(dinner[i].length()>=4) {%>
		<li><%=dinner[i] %></li>	
		
		<% }
		}%>
	</ul>
	
	<h3>내장 객체 활용하기</h3>
	<p>스크립트태그를 이용해서 활용한다</p>
	<%
		request.getAttribute("hobby");
		session.setAttribute("userId","admin");
		application.setAttribute("email","ddd.com");
		
	%>
	<h3>request : <%=request %></h3>
	<h3>session : <%=session %></h3>
	<h3>application : <%=application %></h3>
	<%-- <h3>member : <%=member %></h3>--%>
	
	<h4><a href="views/innerObj.jsp">내장객체 확인하기</a></h4>
	<ul>
		<li><%=request.getAttribute("request") %></li>
		<li><span style="color:red"><%=session.getAttribute("session") %></span></li>
		<li><%=application.getAttribute("application") %></li>
		
	</ul>

	
	<h2>jsp로 controller기능하기</h2>
	<h3><a href="views/memberSearch.jsp">멤버 서치</a></h3>
	
	<h2>지시자 page이요ㅕㅇ하기
	</h2>
	
	
	<h2>include지시자 이용하기</h2>>
	<p>다른 jsp페이지를 가져오는 것 == iframe태그와 비슷 </p>
	
	<h2>기본기능 구현해보기</h2>
	<a href="<%=request.getContextPath()%>/views/test.jsp">회원정보 불러오기</a>	
	
 </body>
</html>