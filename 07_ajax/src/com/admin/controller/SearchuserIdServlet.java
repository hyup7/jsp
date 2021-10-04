package com.admin.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.admin.model.service.AdminService;
import com.member.model.vo.Member;

/**
 * Servlet implementation class SearchuserIdServlet
 */
@WebServlet("/admin/searchMemberList")
public class SearchuserIdServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchuserIdServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		


			String userId=request.getParameter("searchType");
			String keyword=request.getParameter("searchKeyword");
			
			System.out.println(userId+keyword);
	
		int cPage;
		try {
			cPage=Integer.parseInt(request.getParameter("cPage"));
		}catch(NumberFormatException e) {
			cPage=1;
		}
		//2.페이지당 출력할 데이터수
		int numPerpage;
		try {
		 numPerpage=Integer.parseInt(request.getParameter("numPerpage"));
		}catch(NumberFormatException e) {
			numPerpage=5;
		}
		
		//pageBar태그 만들기
		int totalData=new AdminService().selectMemberSearchCount(userId,keyword);
		int totalPage=(int)Math.ceil((double)totalData/numPerpage);
		
		int pageBarSize=5;
		int pageNo=((cPage-1)/pageBarSize)*pageBarSize+1;
		int pageEnd=pageNo+pageBarSize-1;
		
		//페이지바 html로 구성하기
		String pageBar="";
		// [이전] 1 2 3 4 5 [다음] > [이전] 6 7 8 9 10 [다음]
		if(pageNo==1) {
			pageBar+="<span>[이전]</span>";
		}else {
			pageBar+="<a href='"+request.getContextPath()+"/admin/searchMemberList?cPage="+(pageNo-1)+"&searchKeyword="+keyword+"&searchType="+userId+"'>[이전]</a>";
			System.out.println(userId+keyword);
		}
		while(!(pageNo>pageEnd||pageNo>totalPage)) {
			if(cPage==pageNo) {
				pageBar+="<span>"+pageNo+"</span>";
			}else {
				pageBar+="<a href='"+request.getContextPath()+"/admin/searchMemberList?cPage="+pageNo+"&searchKeyword="+keyword+"&searchType="+userId+"'>"+pageNo+"</a>";
				System.out.println(userId+keyword);
			
			}
			pageNo++;
		}
		if(pageNo>totalPage) {
			pageBar="<span>[다음]</sapn>";
		}else {
			pageBar+="<a href='"+request.getContextPath()+"/admin/searchMemberList?cPage="+pageNo+"&searchKeyword="+keyword+"&searchType="+userId+"'>[다음]</a>";
			System.out.println(userId+keyword);
		}
		
		request.setAttribute("pageBar", pageBar);
		
		
		
		List<Member> list=new AdminService().SearchId(userId,keyword,cPage,numPerpage);
		request.setAttribute("list", list);
		request.setAttribute("keyword", keyword);
		request.getRequestDispatcher("/views/admin/memberList.jsp")
		.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
