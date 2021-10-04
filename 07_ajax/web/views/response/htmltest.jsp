<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<style>
	table, table td{
		border:1px solid red;
	}
</style>
<table>
	
	<tr>
		<th>이름</th>
		<th>나이</th>
		<th>성별</th>
	</tr>
	<%for(int i=0;i<10;i++){ %>
		<tr>
			<td>유병승</td>
			<td>19</td>
			<td>남</td>
		</tr>
	<%} %>
</table>