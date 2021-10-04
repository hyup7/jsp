<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>xml파일 가져오기</title>
<script src="http://code.jquery.com/jquery-3.6.0.min.js"></script>

</head>
<body>
<h2>xml파일 가져오기</h2>
	<button id="xmlBtn">가져오기</button>
	<div id="container">
		<div id="fiction">
			<h2>소설</h2>
			<table id="fiction-info"></table>
		</div>
		<div id="it">
			<h2>프로그래밍</h2>
			<table id="it-info"></table>
		</div>
	</div>
	<script>
	$("#xmlBtn").click(e=>{
		$.ajax({
			url:"books.xml",
			success:data=>{
				console.log(data);
				//xml의 root태그를 가져옴
				let root=$(data).find(":root");//root태그를 가져옴->books태그
				console.log(root[0].children);
				$(root[0].children).each((i,v)=>{
					console.log(v);
					let info=$("<tr>");
					info.append($("<td>").html($(v).find("title").text()));
					info.append($("<td>").html($(v).find("author").text()));
					if($(v).find("subject").text()=='소설'){
						$("#fiction-info").append(info);
					}else{
						$("#it-info").append(info);
					}
				})
			}
		});
	})
	
	
	
	
	</script>
</body>
</html>