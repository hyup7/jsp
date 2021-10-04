package com.notice.controller;

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
import com.oreilly.servlet.multipart.FileRenamePolicy;

/**
 * Servlet implementation class NoticesubmitServlet
 */
@WebServlet("/notice/noticeWriterEnd")
public class NoticeWriterEnd extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NoticeWriterEnd() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//파일 업로드 로직을 처리하기
		//파일 업로드 시에는 cos.jar에서 제공하는 클래스를 이용함.
		//MutilpartRequest클래스를 생성해서 이용함. -> 파일업로드를 해줌.
		
		//enctype체킹하기 ->mutipart/form-data로 넘어오는가?
		if(!ServletFileUpload.isMultipartContent(request)) {
			//잘못된 요청으로 에러처리함.
			request.setAttribute("msg", "공지사항작성오류 [form:enctype 관리자에게 문의하세요^^");
			request.setAttribute("loc", "/notice/noticeadd");
			request.getRequestDispatcher("/views/common/msg.jsp").forward(request, response);
			return;
		}
		
		//파일업로드는 cos.jar.에서 제공하는 MultipartRequest클래스를 생성해서 구현을함.
		//MulipartRequest클래스를 생성할때 매개변수가 있는 생성자를 이용
		//1.HttpServletrequest / 2.업로드된 파일을 저장할 경로 / 3. 파일의 최대크기
		//4. 파일에 대한 인코딩/ 5. 업로드파일명 리네임로직(객체)
		
		//파일업로드경로는 HDD에 있는 경로는 직접경로로 가져와야함.
		//Serlvetcontext객체의 getRealPath()매소드를 이용하면 contextroot의 경로를 가져옴
		String path=getServletContext().getRealPath("/upload/notice/");
		System.out.println(path);
		//2.파일사이즈설정 ->최대용량
		int maxSize=1024*1024*10;//10MB
		//3.파일인코딩값
		String encode="UTF-8";
		//4.rename클래스 DafaultFileRenamePolicy클래스 이용
		FileRenamePolicy policy=new DefaultFileRenamePolicy();
		
		MultipartRequest mr=new MultipartRequest(request,path,maxSize,encode,policy);
		
		
		//multipartRequest객체를 생성하면 그 객체로 파라미터값을 받아올 수 있다.
		
		Notice n =new Notice();
		n.setNoticeTitle(mr.getParameter("noticetitle"));
		n.setNoticeWriter(mr.getParameter("noticewriter"));
		n.setNoticeContent(mr.getParameter("noticecontext"));
		
		
		
		//Db에는 리네임된 파일명을 저장
		//리네임된 파일명은 MulitpartRequest객체의 getFilesystemName("
		n.setFilepath(mr.getFilesystemName("noticefile"));
		System.out.println(mr.getOriginalFileName("noticefile"));
		System.out.println(n);
		int result=new NoticeService().InsertNotice(n);
		if(result>0) {
		//등록성공하면 등록 성공 메서지출력 후 리스트화면으로	
			request.setAttribute("msg", "등록성공!");
			request.setAttribute("loc", "/notice/notice");
		}else {
		//등록실패하면 
			request.setAttribute("msg", "등록실패!");
			request.setAttribute("loc", "/");

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
