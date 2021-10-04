package com.board.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.board.model.service.BoardService;
import com.board.model.vo.Board;
import com.board.model.vo.BoardComment;

/**
 * Servlet implementation class Boardinfromservlet
 */
@WebServlet("/board/boardinfrom")
public class Boardinfromservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Boardinfromservlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		int no=Integer.parseInt(request.getParameter("no"));
		//읽었는지 안읽엇는지 채킹
		//cookie에 읽은 게시글의 번호를 저장해놓고 운영하자
		boolean readFlag=false;//안읽음
		//글번호를 저장할 변수
		String boardReadNo="";
		Cookie[] cooikes=request.getCookies();
		if(cooikes!=null) {
			for(Cookie c:cooikes) {
				String name=c.getName();//키값
				String value=c.getValue();//값
				if(name.equals("boardReadNo")) {
					if(value.contains("|"+no+"|")) {
						readFlag=true;
						break;
					}
					boardReadNo=value;//현재읽은 게시글 번호
				}
			}
		}
		//읽지않은 글이면 쿠키글에 추가하기 위한 로직
		if(!readFlag) {
			Cookie c=new Cookie("boardReadNo",boardReadNo+"|"+no+"|");
			c.setMaxAge(-1);
			response.addCookie(c);
		}
		
		Board b = new BoardService().selectinfrom(no,readFlag);
		List<BoardComment> list=new BoardService().selectBoardComment(no);
		System.out.println(list);
		
		request.setAttribute("boardcomment", list);
		request.setAttribute("board", b);
		
		//페이지 전환해주기
		request.getRequestDispatcher("/views/board/boardinfrom.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
