package com.session.controller;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class CheckSessionDataServlet
 */
@WebServlet("/checksession.do")
public class CheckSessionDataServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CheckSessionDataServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//세션에 저장된 값은 getAttribute()로 확인
		//세션값을 가져올때는 메소드내부에서 session을 getSesion()메소드로 가져온 다음 실행
		//getSession(ture) ->세션이 없으면 생성해서 반환(dafault) / getSession(false)->세션이 없으면 null반환
		
//		HttpSession session=request.getSession();
		HttpSession session=request.getSession(false);
		if(session!=null) {
			System.out.println(session.getAttribute("checktest"));
			System.out.println(new Date(session.getCreationTime()));
			System.out.println(new Date(session.getLastAccessedTime()));
			
		}
		
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
