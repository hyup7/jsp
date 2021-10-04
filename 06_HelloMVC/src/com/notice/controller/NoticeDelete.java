package com.notice.controller;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.notice.model.service.NoticeService;

/**
 * Servlet implementation class NoticeDelete
 */
@WebServlet("/notice/noticedelete")
public class NoticeDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NoticeDelete() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int no=Integer.parseInt(request.getParameter("no"));
		int result=0;
		String fileName=request.getParameter("filename");

		result=new NoticeService().noticeDelete(no);
		
		if(result>0) {	
		
		String path=getServletContext().getRealPath("/upload/notice/");
			
		File f = new File(path+fileName);
		if(f.exists()) {
		 f.delete();
		}
		 request.setAttribute("msg", "삭제성공");
		 request.setAttribute("loc", "/notice/notice");
		 
		}else {
			 request.setAttribute("msg", "삭제실패");
			 request.setAttribute("loc", "/notice/notice");
		}
		
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
