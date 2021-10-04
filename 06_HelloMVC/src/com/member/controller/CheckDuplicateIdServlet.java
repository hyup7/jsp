package com.member.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.member.model.service.MemberService;
import com.member.model.vo.Member;

/**
 * Servlet implementation class MemberIdcheck
 */
@WebServlet("/checkDuplicateId")
public class CheckDuplicateIdServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CheckDuplicateIdServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		//클라이언트가 보낸 userId 값이 DB MEMBER 테이블에 있는지 확인
		String userId=request.getParameter("userId");
		
		Member m=new MemberService().selectMemberId(userId);
		
		//m이 null이면 중복값이 없다
		//m이 null이 아니면 중복값 있다.
		
		//boolean result=m==null?true:false;
		request.setAttribute("result", m==null?true:false);
		request.getRequestDispatcher("/views/member/checkDuplicateId.jsp")
		.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
