<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>javascript-ajax</title>
</head>
<body>
	<h2>javascript를 이용한 ajax통신</h2>
	<p>js를 이용해서 비동기식으로 서버와 통신하는 기술</p>
	<input type="text" id="name"> <br>
	<input type="text" id="age"> <br>
	<button onclick="ajaxTestGet();">get방식으로 ajax통신하기</button>
	<button onclick="location.href='<%=request.getContextPath()%>/ajaxGetTest.do?name=유병승'">기본요청</button>
	<button onclick="ajaxTestPost();">post방식으로 ajax통신하기</button>
	<div id="container"></div>
<script>
	const ajaxTestPost=()=>{
		const xhr=new XMLHttpRequest();
		xhr.open("post","<%=request.getContextPath()%>/ajaxGetTest.do?name=유병승");
		xhr.onreadystatechange=()=>{
			if(xhr.readyState==4){
				if(xhr.status==200){
					document.querySelector("#container").innerHTML+=xhr.responseText;
				}
			}
		}
		//onreadystatechange닫기
		//포스트방식으로 전송했을때 데아터를 보낼려면
		//sned()매개변수로 데이터 전송을 함.
		//전송하기 전 header의 contentType내용을 변경해줘야대함
		xhr.setRequestHeader("Content-Type","application/x-www-form-urlencoded")
		const name=document.querySelector("#name").value;
		const age=document.querySelector("#age").value;
		xhr.send("name="+name+"&age="+age);
	}
	const ajaxTestGet=()=>{
		
		//js로 ajax통신하기
		//ajax통신을 하기 위해서는 통신처리를 하는 xmlhttprequest객체를 만들어줌
		const xhr=new XMLHttpRequest();
	
		//1.open함수를 이용해서 요청방식,요청주소,동기.비동기설정을함
		xhr.open("get","<%=request.getContextPath()%>/ajaxGetTest.do?name=유병승");
		
		//2.요청에 대한 서버의 응답을 처리할 함수를 지정/설정
		//이벤트방식으로 처리를 함 - > onreadystatechange속성에 설정
		//xhr에서 관리하는 상태 2가지가 있음
		//1.readyState : 전송 상태를 관리 0~4(완료)
		//2.status : 서버의 응답결과(코드) :200(정상),404,500,403
		xhr.onreadystatechange=()=>{
			//서버로 부터 응답을 받았을때 처리는 로직을 구현
			//readyState/status의 값에 따라 처리
			//정삭적으로 데이터가 처리가 된 순간
			if(xhr.readyState==4){
				if(xhr.status==200){
				
					//서버에서 응답한 데이터는 
					//xhr객체의 responseText속성에 저장됨. (자동);
					console.log("data: "+xhr.responseText);
					
					const data=xhr.responseText;
					document.getElementById("container").innerHTML+="<h2>"+data+"</h2>";
				}
			}
		}
		//3.설정한 대로 요청을 전송함.
		xhr.send();
		
	}
</script>
	
	
</body>
</html>
