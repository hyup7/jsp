package com.basicservlet.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//생성한 서블릿클래스 어노테이션방식으로 처리하기
//@webServlet("주소") - > class선언부 위에 선언을 함.
@WebServlet(name="anno",urlPatterns= {"/anno"})
public class AnnoServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4734249908953990659L;
	
	public AnnoServlet() {
		// TODO Auto-generated constructor stub
	}
	
	@Override
	protected void doGet(HttpServletRequest request,HttpServletResponse response) 
	throws ServletException,IOException{	
		System.out.println("어노테이션으로 연결된 서블릿");
		
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out=response.getWriter();
		out.write("<html>");
		out.write("<body>");
		out.write("<h2>이노테이션으로 연결된 서블릿</h2>");
		out.write("</body>");
		out.write("</html>");
	}
}


