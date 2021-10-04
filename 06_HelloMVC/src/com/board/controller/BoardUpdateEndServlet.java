package com.board.controller;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;

import com.board.model.service.BoardService;
import com.board.model.vo.Board;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

/**
 * Servlet implementation class BoardUpdateEndServlet
 */
@WebServlet("/board/boardupdateend")
public class BoardUpdateEndServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BoardUpdateEndServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		if(!ServletFileUpload.isMultipartContent(request)) {
			request.setAttribute("msg", "게시판 수정실패[form:enctype]");
			request.setAttribute("loc", "/board/boardlist");
			request.getRequestDispatcher("/views/common/msg.jsp").forward(request, response);
			return;
		}
		
		String path=getServletContext().getRealPath("/upload/board");
		MultipartRequest mr=new MultipartRequest(request,path,1024*1024*10,"utf-8",new DefaultFileRenamePolicy());
		
		
		Board b=new Board();
		b.setBoardNo(Integer.parseInt(mr.getParameter("no")));
		b.setBoardTitle(mr.getParameter("boardtitle"));
		b.setBoardWriter(mr.getParameter("boardwriter"));
		b.setBoardContent(mr.getParameter("boardcontent"));
		
		String fileName=mr.getFilesystemName("up_load");
		//파일처리하기
		File f=mr.getFile("up_file");
		
		if(f!=null&&f.length()>0) {
			//새로운 파일이 전달됨,
			//이전파일을 삭제
			File del=new File(path+mr.getParameter("oldfile"));
			del.delete();
		}else {
			// 새로운 파일이 없음
			fileName=mr.getParameter("oldfile");
			
		}
		b.setBoardRenamedFilename(fileName);
		int result=new BoardService().BoardUpdate(b);
		String msg="";
		String loc="";
		if(result>0) {
			msg="수정 성공";
			loc="/board/boardlist";
		}else {
			msg="수정 실패";
			loc="/board/boardlist";
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
