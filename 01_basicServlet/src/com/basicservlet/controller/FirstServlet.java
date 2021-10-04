package com.basicservlet.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//서블릿 규약을 준수하여 작성
//일반클래스를 서블릿으로 만들기
//1.javax.servlet.http.HttpServlet클래스를 상속받는다.
//2.서블릿으로 client의 요청을 받아 처리하는 메소드를 재정의 한다.
//	1)doGet() : 요청방식이 get방식일때 호출되는 매소드
//	2)dopost() : 요청방식이 post방식일때 호출되는 메소드
//	*두 매소드를 정의할때 두개의 Exception처리를 함 ServeletException, IOException

public class FirstServlet extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = -8381237227815012847L;

	public FirstServlet() {
		// TODO Auto-generated constructor stub
	}
	
	@Override
	protected void doGet(HttpServletRequest request,HttpServletResponse response)
	throws ServletException, IOException {
		
		System.out.println("내가만든 첫 서블릿 우와~신기");
		
		/* 응답페이지 작성하기 */
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out =response.getWriter();
		out.write("<html>");
		out.write("<body>");
		out.write("<h1>내가 응답한것 이제 서버를 본격적으로 내일 배워보자!</h1>");
		out.write("</body>");
		out.write("</html>");
		
	}
}
