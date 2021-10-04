/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/9.0.45
 * Generated at: 2021-08-13 09:21:52 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class index_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_classes = null;
  }

  private volatile javax.el.ExpressionFactory _el_expressionfactory;
  private volatile org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public java.util.Set<java.lang.String> getPackageImports() {
    return _jspx_imports_packages;
  }

  public java.util.Set<java.lang.String> getClassImports() {
    return _jspx_imports_classes;
  }

  public javax.el.ExpressionFactory _jsp_getExpressionFactory() {
    if (_el_expressionfactory == null) {
      synchronized (this) {
        if (_el_expressionfactory == null) {
          _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
        }
      }
    }
    return _el_expressionfactory;
  }

  public org.apache.tomcat.InstanceManager _jsp_getInstanceManager() {
    if (_jsp_instancemanager == null) {
      synchronized (this) {
        if (_jsp_instancemanager == null) {
          _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
        }
      }
    }
    return _jsp_instancemanager;
  }

  public void _jspInit() {
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
      throws java.io.IOException, javax.servlet.ServletException {

    if (!javax.servlet.DispatcherType.ERROR.equals(request.getDispatcherType())) {
      final java.lang.String _jspx_method = request.getMethod();
      if ("OPTIONS".equals(_jspx_method)) {
        response.setHeader("Allow","GET, HEAD, POST, OPTIONS");
        return;
      }
      if (!"GET".equals(_jspx_method) && !"POST".equals(_jspx_method) && !"HEAD".equals(_jspx_method)) {
        response.setHeader("Allow","GET, HEAD, POST, OPTIONS");
        response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSP들은 오직 GET, POST 또는 HEAD 메소드만을 허용합니다. Jasper는 OPTIONS 메소드 또한 허용합니다.");
        return;
      }
    }

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta charset=\"UTF-8\">\r\n");
      out.write("<title>기본채팅구성하기</title>\r\n");
      out.write("<script src=\"http://code.jquery.com/jquery-3.6.0.min.js\"></script>\r\n");
      out.write("<style>\r\n");
      out.write("\t#msgContainer{\r\n");
      out.write("\t\theight:500px;\r\n");
      out.write("\t}\r\n");
      out.write("</style>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("\t보내는사람 <input type=\"text\" id=\"sender\" size=\"8\"><br>\r\n");
      out.write("\t받는 사람 <input type=\"text\" id=\"receiver\" size=\"8\"><br>\r\n");
      out.write("\t<input type=\"text\" id=\"msg\" placeholder=\"전송할 메세지 입력\">\r\n");
      out.write("\t<button id=\"sendMsg\">메세지 전송</button>\r\n");
      out.write("\t<div id=\"msgContainer\"></div>\r\n");
      out.write("\t<script>\r\n");
      out.write("\t\t//웹소켓을 이용하기 위한 웹소켓 객체 생성\r\n");
      out.write("\t\tconst socket=new WebSocket(\"ws://localhost:9090/");
      out.print(request.getContextPath());
      out.write("/chatting\");\r\n");
      out.write("\t\t//주소작성 : ws://서버주소 -> http통신\r\n");
      out.write("\t\t//주소작성 : wss://서버주소 -> https통신\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t//각 이벤트속성 설정하기\r\n");
      out.write("\t\tsocket.onopen=e=>{\r\n");
      out.write("\t\t\t//alert('웹소켓서버접속 완료');\r\n");
      out.write("\t\t\tconsole.log(e);\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\t\r\n");
      out.write("\t\tsocket.onmessage=e=>{\r\n");
      out.write("\t\t\t//서버에서 전송한 데이터를 수신하고 페이지에 적용하는 함수\r\n");
      out.write("\t\t\tconsole.log(e);\r\n");
      out.write("\t\t\t//전송온 데이터를 파싱처리하기\r\n");
      out.write("\t\t\t/* let data=e.data.split(\",\");\r\n");
      out.write("\t\t\tconsole.log(data); */\r\n");
      out.write("\t\t\t//자바스크립트 객체 형식으로 넘어온 문자열은 객체로 변환할 수 있다.\r\n");
      out.write("\t\t\t//JSON.parse()함수이용함.\r\n");
      out.write("\t\t\tconsole.log(JSON.parse(e.data));\r\n");
      out.write("\t\t\tlet data=JSON.parse(e.data);\r\n");
      out.write("\t\t\tlet msg;\r\n");
      out.write("\t\t\tif($(\"#sender\").val()==data[\"sender\"]){\r\n");
      out.write("\t\t\t\t//자신\r\n");
      out.write("\t\t\t\tmsg=$(\"<h3>\").html(data[\"sender\"]+\" : \"+data[\"msg\"]).css({\r\n");
      out.write("\t\t\t\t\t\"text-align\":\"left\",\r\n");
      out.write("\t\t\t\t\t\"background-color\":\"gold\"\r\n");
      out.write("\t\t\t\t});\r\n");
      out.write("\t\t\t}else{\r\n");
      out.write("\t\t\t\t//상대방\r\n");
      out.write("\t\t\t\tmsg=$(\"<h3>\").html(data[\"sender\"]+\" : \"+data[\"msg\"]).css({\r\n");
      out.write("\t\t\t\t\t\"text-align\":\"right\",\r\n");
      out.write("\t\t\t\t\t\"background-color\":\"cornflowerblue\"\r\n");
      out.write("\t\t\t\t});\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t\t$(\"#msgContainer\").append(msg);\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\r\n");
      out.write("\t\tsocket.onclose=e=>{\r\n");
      out.write("\t\t\tconsole.log(e);\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t$(\"#sendMsg\").click(e=>{\r\n");
      out.write("\t\t\tconst sendMsg=new Message($(\"#sender\").val(),\r\n");
      out.write("\t\t\t\t\t$(\"#receiver\").val(),$(\"#msg\").val());\r\n");
      out.write("\t\t\tsocket.send(JSON.stringify(sendMsg));//서버의 @OnMessage메소드가 실행\r\n");
      out.write("\t\t})\r\n");
      out.write("\t\t\r\n");
      out.write("\t\tfunction Message(sender, receiver, msg){\r\n");
      out.write("\t\t\tthis.sender=sender;\r\n");
      out.write("\t\t\tthis.receiver=receiver;\r\n");
      out.write("\t\t\tthis.msg=msg;\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t\r\n");
      out.write("\t</script>\r\n");
      out.write("\r\n");
      out.write("</body>\r\n");
      out.write("</html>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try {
            if (response.isCommitted()) {
              out.flush();
            } else {
              out.clearBuffer();
            }
          } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}