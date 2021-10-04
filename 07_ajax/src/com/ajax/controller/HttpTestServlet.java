package com.ajax.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class HttpTestServlet
 */
@WebServlet("/ajax/htmlTest.do")
public class HttpTestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HttpTestServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html;charset=utf-8");
//		String html="";
//		html+="<table>";
//		html+="<tr>";
//		html+="<th>이름</th><th>나이</th><th>성별</th>";
//		html+="</tr>";
//		html+="<tr>";
//		html+="<td>우병승</td><td>19</td><td>남</td>";
//		html+="</tr>";
//		html+="<tr>";
//		html+="<td>우병승</td><td>19</td><td>남</td>";
//		html+="</tr>";
//		html+="<tr>";
//		html+="<td>우병승</td><td>19</td><td>남</td>";
//		html+="</tr>";
//		html+="</table>";
//		response.getWriter().print(html);
		request.getRequestDispatcher("/views/response/htmltest.jsp").forward(request, response); 
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
