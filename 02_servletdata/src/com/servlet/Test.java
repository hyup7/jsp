package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Test
 */
@WebServlet("/testPerson.do")
public class Test extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Test() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("uft-8");
		//클라이언트가 전송한 데이터 받기
		//1.기본데이터 받기(단일값) :request.getParamter("key");
		
		String name = request.getParameter("name");
		//다른 자료형으로 사용하려면 파싱처리해야한다. ->String -> int,String -> double
		//Integer,Double .. parseInt(),parseDouble()..
		
		int age = Integer.parseInt(request.getParameter("age"));
		double height=Double.parseDouble(request.getParameter("height"));
		
		String color=request.getParameter("color");
		//여러개의 값의 paramter를 가져올때
		//request.getParameterValues() ->다중값을 가져올때 사용
		String[] food=request.getParameterValues("food");
		//* 단일값도 getParamterValues() 메소드를 이용할 수 있다. -> 0번 인덱스에 대입
//		String[] na=request.getParameterValues("name");
		String animal=request.getParameter("animal");
		System.out.println(name+" : "+age+" : "+height+" : " +color);
		for(String f : food) {
			System.out.println(f);
		}
		System.out.println();
		System.out.println(animal);
		
		//paramter의 값을 가져오는 다른 방법
		//key값을 모를때 key값을 가져오는 방법
		//request.getParamterNames(); =>클라이언트가 보낸 데이터의 모든 key갑승 랍놯ㄴ
		//반황형이 Enumberation객체임(Iterator)
		ArrayList<String[]> paramterValues=new ArrayList();
		HashMap<String,String[]> pMap=new HashMap();
		//key값으로 values를 가져와서 저장시키는 객체
		System.out.println("========key값 확인=======");
		Enumeration<String> keys = request.getParameterNames();
		while(keys.hasMoreElements()) {
//			System.out.println(keys.nextElement());
			String key=keys.nextElement();
			paramterValues.add(request.getParameterValues(key));
			
		}
		for(String[] v : paramterValues) {
			for(String pv:v) {
				System.out.println("구분줄====");
				System.out.println("값 :"+pv) ;
			}
			System.out.println();
		}
		//클라이언트가 보낸 데이터의 key,value를 한번에 다 가져오기
		//Map형태로 가져옴.
		//request.getParmeterMap();
		Map<String,String[]> param=request.getParameterMap();
		System.out.println(param);
		
		Set<String> mkey=param.keySet();
		Iterator<String> ikey=mkey.iterator();
		while(ikey.hasNext()) {
			String k =ikey.next();
			String temp="";
			
			for(String v : param.get(k)) {
				temp+=v;
			}
			System.out.println(k+" :"+temp);
			
			
		}
		
		//응답페이지 작성하기
		//클라이언트 응답하기 위해서는 HttpServletReponse 객체를 이용한다.
		//response객체는 응답하기위한 각종 정보를 가지고 있는 객체이다.
		
		//1. 응답하는 방식을 결정 -> response.setContentType();
		//전송되는 데이터의 MIME타입과 인코딩 방식을 결정 
		response.setContentType("text/html;charset=utf-8");
		//2.클라이언트에게 데이터를(페이지내용을) 전송하기 위해 Stream을 가져온다
		//response.getWriter() response.getOutputStream():바이너리파일(동영상,사진,일반파일,노래)
		PrintWriter out=response.getWriter();
		//응답할 페이지 구문을 작성해서 out스트림에 보냄
		String html="<html>";
		html+="<body>";
		html+="<h1>당신의 이름은"+name+"이고<h1>";
		html+="<h2>당신의 나이은"+age+"살이고,키는"+height+"cm이다<h2>";
		html+="<p>당신이 좋아하는 색은 <span style='color:"+color+"'>"+color+"</span>이고,</p>";
		html+="<ul>좋아하는 음식";
		for(String f : food) {
			String src="";
			switch(f) {
				case "제육볶음" : src="https://cloudfront.haemukja.com/vh.php?url=https://d1hk7gw6lgygff.cloudfront.net/uploads/direction/image_file/66730/pad_thumb_____2019-01-29-19-03-49.jpg&convert=jpgmin&rt=600";break;
				case "가브리살" : src="https://lh3.googleusercontent.com/proxy/phPJO1l_t_LmeaTWQW9h7-UvUOf0MwAyKrCz73tkUdfATq77xcPXnQ-cTdZLRlBipWcbPldt7RFOcWyndpEFvX_kTkW0VY1y6MIupKy9cacuH3dl0tQ5M94rvGqM7aFh5nbh80LcO9MZCibHqbn1FUj1VhWCv0quvKwms97wULhmdcpPaoF8eRWzg4fJyfohO4yqGvs";break;
				case "갈비" : src="http://image.gsshop.com/image/60/88/60884596_L1.jpg";break;
				case "토다이" : src="https://cdn.todaykorea.co.kr/news/photo/202102/283303_213716_1916.jpg";break;
				case "계란초밥" : src="https://recipe1.ezmember.co.kr/cache/recipe/2018/09/29/bc9e3809829df0e0560b25484bb620f81.jpg"; break;
					
			}			
			html+="<li><img src='"+src+"' height='200' width='200'></li>";
		}
		html+="</ul>";
		html+="<h3>당신의 좋아하는 동물은"+animal+"이고<h3>";
		html+="<h4>이용해 주셔서 갑사합니다! ^~<h4>";
		html+="<button onclick='history.back();'>뒤로가기</button>";
		html+="</body>";
		html+="</html>";
				
		out.write(html);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
