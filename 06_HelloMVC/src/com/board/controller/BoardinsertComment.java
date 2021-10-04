package com.board.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.board.model.service.BoardService;
import com.board.model.vo.BoardComment;

/**
 * Servlet implementation class BoardinsertComment
 */
@WebServlet("/board/insertComment")
public class BoardinsertComment extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BoardinsertComment() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String content=request.getParameter("content");
		int level=Integer.parseInt(request.getParameter("level"));
		int commentRef=Integer.parseInt(request.getParameter("commentRef"));
		String writer=request.getParameter("commentWriter");
		int boardRef=Integer.parseInt(request.getParameter("boardRef"));
		
		BoardComment bc =new BoardComment();
		
		bc.setBoardCommentContent(content);
		bc.setBoardCommentWriter(writer);
		bc.setBoardCommentLevel(level);
		bc.setBoardCommentRef(commentRef);
		bc.setBoardRef(boardRef);
		
		int result = new BoardService().insertCommnet(bc);
		
		String msg="";
		String loc="";
		if(result>0) {
			msg="등록 성공";
			loc="/board/boardinfrom?no="+boardRef;
			
		}else {
			msg="등록 실패";
			loc="/board/boardinfrom?no="+boardRef;
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
