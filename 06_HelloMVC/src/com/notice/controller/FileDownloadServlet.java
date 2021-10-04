package com.notice.controller;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class FileDownloadServlet
 */
@WebServlet("/fileDownload")
public class FileDownloadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FileDownloadServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String fileName=request.getParameter("filename");
		String path=getServletContext().getRealPath("/upload/notice/");
		File f=new File(path+fileName);
		
		FileInputStream is =new FileInputStream(f);
		BufferedInputStream bis=new BufferedInputStream(is);
		
		
		//파일명이 한글일경우 깨지는 현상을 막기 -> 인코딩처리
		String fileRename="";
		String header=request.getHeader("user-agent");
		boolean isMs=header.contains("Trident")||header.contains("MSIE");
		if(isMs) {
			//익스플로어일때 분기처리
			fileRename=URLEncoder.encode(fileName,"utf-8").replaceAll("\\+","%20");
		}else {
			fileRename=new String(fileName.getBytes("UTF-8"),"ISO_8859_1");
		}
		
		//응답메세지를 작성
		response.setContentType("application/octet-stream");
		response.setHeader("Content-disposition", "attachment;filename="+fileRename);
		
		//파일을 출력해줄 stream을 가져옴
		ServletOutputStream sos=response.getOutputStream();
		BufferedOutputStream bos=new BufferedOutputStream(sos);
		
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
