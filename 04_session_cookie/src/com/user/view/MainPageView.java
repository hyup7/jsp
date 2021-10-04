package com.user.view;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class MainPageView
 */
@WebServlet("/mainPage.do")
public class MainPageView extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MainPageView() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html;charset=utf-8");
		String html="<html>";
		html+="<head>";
		html+="<style>";
		html+="ul>li{display:inline-block;margin-right:20px font-size:25px;font-weight:bolder;}";
		html+="</style>";
		html+="<body>";
		html+="<h1>홈페이지에 오신것을 환엽한디다.</h1>";
		HttpSession session=request.getSession();
		if(session!=null&&session.getAttribute("logginId")!=null) {
			html+="<ul>";
			html+="<li>메인화면</li>";
			html+="<li>갤러리</li>";
			html+="<li>게시판</li>";
			html+="</ul>";
			html+="<button onclick='location.replace(\""+request.getContextPath()+"/logout.do\")'>로그아웃</button>";
			
		}else {
			//로그인 실패 했을때
			html+="<from action='login.do' method='post'>";
			html+="아이디<input type='text' name='userId'> <br>";
			html+="패스워드<input type='password' name='password'> <br>";
			html+="<input type='submit' value='로그인'>";
			html+="</form>";
		}
		html+="</body>";
		html+="</html>";
		response.getWriter().print(html);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
