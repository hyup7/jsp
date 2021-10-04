package com.board.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;

import com.board.model.service.BoardService;
import com.board.model.vo.Board;
import com.common.MyRenameFile;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

/**
 * Servlet implementation class BoardwriteServlet
 */
@WebServlet("/board/boardwrite")
public class BoardwriteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BoardwriteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		if(!ServletFileUpload.isMultipartContent(request)) {
			request.setAttribute("msg", "잘못된접근입니다");
			request.setAttribute("loc", "/board/boardlist");
			request.getRequestDispatcher("/views/common/msg.jsp").forward(request, response);
			return;
		}
		
		String path=getServletContext().getRealPath("upload/board/");
		MultipartRequest mr =new MultipartRequest(request,path,1024*1024*200,"utf-8",new MyRenameFile());
		Board b =new Board();
		b.setBoardTitle(mr.getParameter("boardtitle"));
		b.setBoardWriter(mr.getParameter("boardwriter"));
		b.setBoardContent(mr.getParameter("boardcontent"));
		b.setBoardRenamedFilename(mr.getFilesystemName("up_load"));
		b.setBoardOriginalFilename(mr.getOriginalFileName("up_load"));
		
		int result =new BoardService().insertBoard(b);
		
		String msg="";
		String loc="";
		if(result>0) {
			msg="게시글이 등록되었습니다";
			loc="/board/boardlist";
			
		}else {
			msg="게시글 등록 실패하셧습니다";
			loc="/board/boardwrite";
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
