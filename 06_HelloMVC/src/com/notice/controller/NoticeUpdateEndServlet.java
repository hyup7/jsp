package com.notice.controller;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;

import com.notice.model.service.NoticeService;
import com.notice.model.vo.Notice;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

/**
 * Servlet implementation class NoticeUpdateEndServlet
 */
@WebServlet("/notice/noticeupdateend")
public class NoticeUpdateEndServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NoticeUpdateEndServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		if(!ServletFileUpload.isMultipartContent(request)) {
			request.setAttribute("msg", "공지사항 수정실패[form:enctype]");
			request.setAttribute("loc", "/notice/notice");
			request.getRequestDispatcher("/views/common/msg.jsp").forward(request, response);
			return;
		}
		
		String path=getServletContext().getRealPath("/upload/notice");
		MultipartRequest mr=new MultipartRequest(request,path,1024*1024*10,"utf-8",new DefaultFileRenamePolicy());
		
		
		Notice n=new Notice();
		n.setNoticeNo(Integer.parseInt(mr.getParameter("no")));
		n.setNoticeTitle(mr.getParameter("noticetitle"));
		n.setNoticeWriter(mr.getParameter("noticewriter"));
		n.setNoticeContent(mr.getParameter("content"));
		
		String fileName=mr.getFilesystemName("up_file");
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
		n.setFilepath(fileName);
		//DB수정하고
		int result=new NoticeService().noticeUpdate(n);
		String msg="";
		String loc="";
		if(result>0) {
			msg="수정 성공";
			loc="/notice/notice";
		}else {
			msg="수정 실패";
			loc="/notice/notice";
		}
		
		request.setAttribute("msg", msg);
		request.setAttribute("loc", loc);
		request.getRequestDispatcher("/views/common/msg.jsp").forward(request, response);
		
		//화면 선택
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
