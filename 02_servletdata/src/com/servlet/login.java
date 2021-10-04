package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class login
 */
@WebServlet("/login.do")
public class login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public login() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		System.out.println("doGet매소드 호출");
		request.setCharacterEncoding("utf-8");//모든 요청을 처리할때 설정을 함
		//기본적인 클라이언트가 보낸 데이터 가져오기
		//클라이언트가 전송한 데이터는parmaeter라고 함
		//클라이언트가 전송한 데이터 HttpServletRequest객체에저장돠됨
		//저장된 피라미터값은 getParmeter()매소드를 이용해서 가져옴
		//request.getParmter("key(input태그 name속성의 값)")
		//getParamter()매소드의 반환형 String - >클라이언트가 보낸 값을 무조건 String반환
		//전송 data를 파싱처리해야함.
		String userId = request.getParameter("userId");
		String pwd = request.getParameter("password");
		System.out.println("userId : "+userId+" pw :"+pwd);
		
		//응답페이지 구성하기 - > 문자열(코드,데이터)을 스트링으로 보냄
		//응답하는 내용에 대한 형식을 알려주기 - >setContentType()매소드이용(MIME type설정)
		response.setContentType("text/html;charset=utf-8");
		//응답을 위한 스트림을 가져옴 ->
		PrintWriter out = response.getWriter();
		String html="<html>";
		html+="<body>";
		html+="<h1>당신이 입력한 아이디는 "+userId+"비밀번호는 "+pwd+"</h1>";
		html+="</body>";
		html+="</html>";
		out.write(html);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		System.out.println("doPost매소드 호출");
//		request.setCharacterEncoding("utf-8");
//		String userId = request.getParameter("userId");
//		String pwd = request.getParameter("password");
//		System.out.println("userId : "+userId+" pw :"+pwd);
		
		
	}

}
