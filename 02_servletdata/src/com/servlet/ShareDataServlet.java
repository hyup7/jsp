package com.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Share
 */
@WebServlet("/share.do")
public class ShareDataServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShareDataServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// was에서 사용할수 있는 데이터저장 객체를 알아보자
		//1.ServletContext : 서버실행시 부터 서버 종료시까지
		//2.httpSession : session생성시 부터 session종료시까지
		//3.HttpServletRequest : 요청된 순간부터 요청이 종료될때까지
		//ServletContext객체 생성
		ServletContext context=request.getServletContext();
		//HttpSession객체 생성
		HttpSession session=request.getSession();
		
		//각 공유데이터 저장객체에 값을 넣을때는 setAttribute()매소드를 이용함
		context.setAttribute("context", "contextData");
		session.setAttribute("session", "sessionData");
		request.setAttribute("request", "requestDate");
		
		//Object obj="contextData";
		//String str=obj;
		
		//저장한 데이터 출력하기
		//저장된 데이터를 출력할때는 저장된 key값을 기준으로 출력함.
		//getAttribute("key") ->
		String contextValue=(String)context.getAttribute("context");
		System.out.println("context :"+contextValue);
		String sessionValue=(String)session.getAttribute("session");
		System.out.println("session :"+contextValue);
		String requestValue=(String)request.getAttribute("request");
		System.out.println("request :"+contextValue);
		
		//저장된 데이터변경,삭제하기
		//변경 : 같은키값으로 다른값을 넣으면 수정
//		System.out.println("request"+requestValue);
//		request.setAttribute("request", "요청데이터");
//		requestValue=(String)request.getAttribute("request");
//		System.out.println("request :"+requestValue);
//		//삭제 :removeAttribure("keY")
//		request.removeAttribute("request");
//		requestValue=(String)request.getAttribute("request");
//		System.out.println("request :"+requestValue);
		
		//없는 key값을 넣으면  -> null값을 출력함
		
		//페이지(서블릿) 이동시 객체활용
		//1. RequestDispatcher객체를 이용해서 전환
//		RequestDispatcher rd=request.getRequestDispatcher("useData.do");
//		rd.forward(request, response);
		
		//2.sendRedirect로전환하기
		response.sendRedirect("useData.do");
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
