package com.member.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.member.model.service.MemberService;
import com.member.model.vo.Member;

/**
 * Servlet implementation class LoginSerlvet
 */
@WebServlet(name="login",urlPatterns="/login")
public class LoginSerlvet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginSerlvet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//클라이언트가 보낸 데이터(id,pw)가 db에있는지 확인 후
		//로그인 처리하는 서비스
		String userId=request.getParameter("userId");
		String password=request.getParameter("password");
		String saveId=request.getParameter("saveId");
		//saveId값을 기준을 체크박스가 체크되었는지 안되었는지 확인
		//null 체크하지 않았을대 /on 체크 했을때
		if(saveId!=null) {
			//현재 보낸 아이디값을 Cookie에 저장하자.
			Cookie c= new Cookie("saveId", userId);
			c.setMaxAge(7*24*60*60);
			response.addCookie(c);
		}else {
			//생성된 쿠키 지우기
			Cookie c=new Cookie("saveId","");
			c.setMaxAge(0);
			response.addCookie(c);
		}
		
		
		System.out.println("saveId :" +saveId);
		
		System.out.println("userId :" +userId +" password : "+password);
		
		//DB에 접속해서 id,pw 맞는지 확인 ->  있으면 Member 자체가져오기
		//없으면 null값을 반환하게 만든다
		Member m2 =new Member();
		m2.setUserId(userId);
		m2.setPassword(password);
		Member m =new MemberService().login(m2);
		System.out.println(m);
		//m이 null이면 로그인 실패
		//m이 null이 아니면 로그인 성공
		if(m!=null) {
			//로그인 성공
			//로그인한 객체를 저장하고 메인으로 이동
			//request.setAttribute("loginMember", m);
			//로그인 상태를 유지하기
			//로그인 상태를 유지하기 위해 - >session
			HttpSession session=request.getSession();
			session.setAttribute("loginMember", m);
			
			RequestDispatcher rd=request.getRequestDispatcher("/");
			rd.forward(request, response);
		}else {
			//로그인 실패
			//로그인 실패 알람을 띄워주고 메인화면으로 이동을시킴
			String msg="아이디,비밀번호가 일치하지 않습니다";
			String loc="/";
			request.setAttribute("msg", msg);
			request.setAttribute("loc", loc);
			
			RequestDispatcher rs=request.getRequestDispatcher("/views/common/msg.jsp");
			rs.forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
