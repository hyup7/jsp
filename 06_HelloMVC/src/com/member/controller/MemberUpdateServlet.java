package com.member.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.common.AESEncrypt;
import com.member.model.service.MemberService;
import com.member.model.vo.Member;

/**
 * Servlet implementation class MemberUpdateServlet
 */
@WebServlet("/updateMember")
public class MemberUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberUpdateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//클라이언트가 보낸 회원정보를 DB의 member테이블의 일치하는 정보와 변경한다.
		Member m=new Member();
		m.setUserId(request.getParameter("userId"));
		//m.setPassword(request.getParameter("password"));
		m.setUserName(request.getParameter("userName"));
		m.setGender(request.getParameter("gender"));
		m.setAge(Integer.parseInt(request.getParameter("age")));
		try {
		m.setEmail(AESEncrypt.encrypt(request.getParameter("email")));
		m.setPhone(AESEncrypt.encrypt(request.getParameter("phone")));
		}catch(Exception e) {
			e.printStackTrace();
		}
		m.setAddress(request.getParameter("address"));
		m.setHobby(String.join(",",request.getParameterValues("hobby")));
		
		int result=new MemberService().updateMember(m);
		
		//처리결과에 따라 메세지를 출력하고
		//성공이면 메인화면으로 이동
		//실파하면 memberview화면으로 이동
		String msg="";
		String loc="";
		if(result>0) {
			//수정성공
			msg="회원 수정성공";
			loc="/";
			HttpSession session=request.getSession(false);
			session.setAttribute("loginMember", m);
		}else {
			//수정실패
			msg="회원수정실패";
			loc="/memberView.do?userId="+m.getUserId();
		}
		request.setAttribute("msg", msg);
		request.setAttribute("loc", loc);
		
		request.getRequestDispatcher("/views/common/msg.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
