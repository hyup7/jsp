package com.session.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class SessionCreateServlet
 */
@WebServlet("/sessiontest.do")
public class SessionCreateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SessionCreateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//session 서버에 저장되는 데이터로 requset객체에서getSession()메소드를 이용해서
		//생성됨. 생성되면 클라이언트에게 JSESSIOnID값을 전송
		//클라이언트는 서버에 접속할때 JSESSIONID를 자동으로 가져옴.
		
		//session생성하기
		HttpSession session=request.getSession();
		session.setMaxInactiveInterval(10);
		session.setAttribute("checktest", "데이터 있어요!");
		response.sendRedirect(request.getContextPath());
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
