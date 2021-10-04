package com.board.controller;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class BoardFileDownServlet
 */
@WebServlet("/board/filedown")
public class BoardFileDownServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BoardFileDownServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String filename=request.getParameter("name");
		String filerename=request.getParameter("rename");
		String path=getServletContext().getRealPath("/upload/board/");
		File f=new File(path+filerename);
		
		FileInputStream is =new FileInputStream(f);
		BufferedInputStream bis=new BufferedInputStream(is);
		
		String header=request.getHeader("user-agent");
		boolean isMs=header.contains("Trident")||header.contains("MSIE");
		String reFileName="";
		if(isMs) {
			reFileName=URLEncoder.encode(filename,"utf-8");
			reFileName=reFileName.replace("\\", "%20");
		}else {
			reFileName=new String(filename.getBytes("utf-8"),"ISO-8859-1");
		}
		
		response.setContentType("application/octet-stream");
		response.setHeader("Content-Disposition", "attachment;filename="+reFileName);
		
		BufferedOutputStream bos=new BufferedOutputStream(response.getOutputStream());
		
		int read=-1;
		while((read=bis.read())!=-1) {
			bos.write(read);
		}
		bis.close();
		bos.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
