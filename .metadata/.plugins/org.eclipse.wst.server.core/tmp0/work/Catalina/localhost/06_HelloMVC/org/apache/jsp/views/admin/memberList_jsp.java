/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/9.0.45
 * Generated at: 2021-06-18 12:37:59 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.views.admin;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.List;
import com.member.model.vo.Member;
import com.member.model.vo.Member;

public final class memberList_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(4);
    _jspx_dependants.put("/WEB-INF/lib/taglibs-standard-impl-1.2.5.jar", Long.valueOf(1624019354747L));
    _jspx_dependants.put("jar:file:/C:/Users/user/Desktop/jsp/.metadata/.plugins/org.eclipse.wst.server.core/tmp0/wtpwebapps/06_HelloMVC/WEB-INF/lib/taglibs-standard-impl-1.2.5.jar!/META-INF/c.tld", Long.valueOf(1425946270000L));
    _jspx_dependants.put("/views/common/header.jsp", Long.valueOf(1621494761798L));
    _jspx_dependants.put("/views/common/footer.jsp", Long.valueOf(1620377786229L));
  }

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_classes = new java.util.HashSet<>();
    _jspx_imports_classes.add("java.util.List");
    _jspx_imports_classes.add("com.member.model.vo.Member");
  }

  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fc_005fif_0026_005ftest;
  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvar_005fitems;

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
    _005fjspx_005ftagPool_005fc_005fif_0026_005ftest = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvar_005fitems = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
  }

  public void _jspDestroy() {
    _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.release();
    _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvar_005fitems.release();
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
      out.write("\r\n");
      out.write("    \r\n");
      out.write("    ");

    	List<Member> list=(List<Member>)request.getAttribute("list");
    	String key=request.getParameter("searchKeyword");
    	String type=request.getParameter("searchType");
    	
    
    
      out.write("\r\n");
      out.write("    \r\n");
      out.write("    ");
      out.write("\r\n");
      out.write("    \r\n");
      out.write("    ");

  //  Member loginMember=(Member)request.getAttribute("loginMember");
    Member loginMember=(Member)session.getAttribute("loginMember");
    
    
    //Cookie에 있는 값 가져오기
    Cookie[] cookies=request.getCookies();
    String saveId=null;
    if(cookies!=null){
    	for(Cookie c : cookies){
    		if(c.getName().equals("saveId")){
    			saveId=c.getValue();
    			break;
    		}
    	}
    }
    
    
      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("\r\n");
      out.write("<meta charset=\"UTF-8\">\r\n");
      out.write("<title>Insert title here</title>\r\n");
      out.write("</head>\r\n");
      out.write("<link rel=\"stylesheet\" type=\"text/css\" href=\"");
      out.print(request.getContextPath() );
      out.write("/css/style.css\">\r\n");
      out.write("<script src=\"");
      out.print(request.getContextPath() );
      out.write("/js/jquery-3.6.0.min.js\"\r\n");
      out.write("\tonsubmit=\"return fn_invalidate();\"></script>\r\n");
      out.write("<body>\r\n");
      out.write("\t<div id=\"container\">\r\n");
      out.write("\t\t<header>\r\n");
      out.write("\t\t\t<h1>Hello MVC</h1>\r\n");
      out.write("\t\t\t<div class=\"login-container\">\r\n");
      out.write("\t\t\t");
if(loginMember==null){ 
      out.write("\r\n");
      out.write("\t\t\t\t<form id=\"loginFrm\" action=\"");
      out.print(request.getContextPath());
      out.write("/login\" method=\"post\"\r\n");
      out.write("\t\t\t\t\tonsubmit=\"return fn_invalidate();\">\r\n");
      out.write("\t\t\t\t\t<table>\r\n");
      out.write("\t\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t\t<td><input type=\"text\" name=\"userId\" id=\"userId\" palceholder=\"아이디\" value=\"");
      out.print(saveId==null?"":saveId);
      out.write("\"></td>\r\n");
      out.write("\t\t\t\t\t\t\t<td></td>\r\n");
      out.write("\t\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t\t<td><input type=\"password\" name=\"password\" id=\"password\" placeholder=\"패스워드\"></td>\r\n");
      out.write("\t\t\t\t\t\t\t<td></td>\r\n");
      out.write("\t\t\t\t\t\t\t<td><input type=\"submit\" value=\"로그인\"></td>\r\n");
      out.write("\t\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t<td colspan=\"2\">\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t\t\t<input type=\"checkbox\" name=\"saveId\" id=\"saveId\" ");
      out.print(saveId!=null?"checked":"" );
      out.write(">\r\n");
      out.write("\t\t\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t\t\t<label for=\"saveId\">아이디저장</label>\r\n");
      out.write("\t\t\t\t\t\t\t<input type=\"button\" value=\"회원가입\" onclick=\"location.assign('");
      out.print(request.getContextPath());
      out.write("/enrollMember')\">\r\n");
      out.write("\t\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t</table>\r\n");
      out.write("\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t</form>\r\n");
      out.write("\t\t\t\t\t");
}else{ 
      out.write("\r\n");
      out.write("\t\t\t\t\t\t<table id=\"logged-in\">\r\n");
      out.write("\t\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t<td colspan=\"2\">\r\n");
      out.write("\t\t\t\t\t\t");
      out.print(loginMember.getUserName());
      out.write("님,환영합니다.\r\n");
      out.write("\t\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t<td>\r\n");
      out.write("\t\t\t\t\t\t<input type=\"button\" value=\"내정보보기\" onclick=\"location.assign('");
      out.print(request.getContextPath());
      out.write("/memberView.do?userId=");
      out.print(loginMember.getUserId());
      out.write("')\">\r\n");
      out.write("\t\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t\t<td>\r\n");
      out.write("\t\t\t\t\t\t<input type=\"button\" value=\"로그아웃\" onclick=\"fn_logout();\">\r\n");
      out.write("\t\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t\t</table>\r\n");
      out.write("\t\t\t\t\t");
} 
      out.write("\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t\t<nav>\r\n");
      out.write("\t\t\t\t<ul class=\"main-nav\">\r\n");
      out.write("\t\t\t\t\t<li class=\"home\"><a href=\"\">Home</a></li>\r\n");
      out.write("\t\t\t\t\t<li id=\"notice\"><a href=\"");
      out.print(request.getContextPath());
      out.write("/notice/notice\">공지사항</a></li>\r\n");
      out.write("\t\t\t\t\t<li id=\"board\"><a href=\"");
      out.print(request.getContextPath());
      out.write("/board/boardlist\">게시판</a></li>\r\n");
      out.write("\t\t\t\t\t");
if(loginMember!=null&&loginMember.getUserId().equals("admin")){ 
      out.write("\r\n");
      out.write("\t\t\t\t   <li id=\"memberManage\"><a href=\"");
      out.print(request.getContextPath());
      out.write("/admin/memberList\">회원관리</a></li>\r\n");
      out.write("\t\t\t\t\t");
} 
      out.write("\r\n");
      out.write("\t\t\t\t\t\r\n");
      out.write("\t\t\t\t</ul>\r\n");
      out.write("\t\t\t</nav>\r\n");
      out.write("\t\t</header>\r\n");
      out.write("\t\t<script>\r\n");
      out.write("\t\t\tconst fn_invalidate=()=>{\r\n");
      out.write("\t\t\t\tconsole.log(\"안녕\");\r\n");
      out.write("\t\t\t\tconst userId=$(\"#userId\").val();\r\n");
      out.write("\t\t\t\tconst pw=$(\"#password\").val();\r\n");
      out.write("\t\t\t\tif(userId.trim().length<4){\r\n");
      out.write("\t\t\t\t\talert(\"아이디를 4글자 이상 입력하세요\");\r\n");
      out.write("\t\t\t\t\treturn false;\r\n");
      out.write("\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t\r\n");
      out.write("\t\t\t\t}\r\n");
      out.write("\t\t\t\tif(pw.trim().length==0){\r\n");
      out.write("\t\t\t\t\talert(\"패스워드를 입력하세요!\")\r\n");
      out.write("\t\t\t\t\treturn false;\r\n");
      out.write("\t\t\t\t}\r\n");
      out.write("\t\t\t\treturn true;\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t\tconst fn_logout=()=>{\r\n");
      out.write("\t\t\t\tlocation.replace(\"");
      out.print(request.getContextPath());
      out.write("/logout\");\t\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t</script>");
      out.write("\r\n");
      out.write("<style type=\"text/css\">\r\n");
      out.write("    section#memberList-container {text-align:center;}\r\n");
      out.write("    \r\n");
      out.write("    section#memberList-container table#tbl-member {width:100%; border:1px solid gray; border-collapse:collapse;}\r\n");
      out.write("    section#memberList-container table#tbl-member th, table#tbl-member td {border:1px solid gray; padding:10px; }\r\n");
      out.write("        div#search-container {margin:0 0 10px 0; padding:3px; \r\n");
      out.write("    background-color: rgba(0, 188, 212, 0.3);}\r\n");
      out.write("    div#search-userId{display:inline-block;}\r\n");
      out.write("    div#search-userName{display:none;}\r\n");
      out.write("    div#search-gender{display:none;}\r\n");
      out.write("    div#numPerpage-container{float:right;}\r\n");
      out.write("    form#numperPageFrm{display:inline;}\r\n");
      out.write("    </style>\r\n");
      out.write("    \r\n");
      out.write("    <section id=\"memberList-container\">\r\n");
      out.write("        <h2>회원관리</h2>\r\n");
      out.write("        <div id=\"search-container\">\r\n");
      out.write("        검색타입:\r\n");
      out.write("        <select id=\"searchType\">\r\n");
      out.write("        <option value=\"userId\" ");
      out.print(type!=null&&type.equals("userId")?"selected":"" );
      out.write(">아이디</option>\r\n");
      out.write("        <option value=\"userName\" ");
      out.print(type!=null&&type.equals("userName")?"selected":"" );
      out.write(">회원이름</option>\r\n");
      out.write("        <option value=\"gender\" ");
      out.print(type!=null&&type.equals("gender")?"selected":"" );
      out.write(">성별</option>\r\n");
      out.write("        </select>\r\n");
      out.write("        <div id=\"search-userId\">\r\n");
      out.write("        <form action=\"");
      out.print(request.getContextPath() );
      out.write("/admin/searchMemberList\" method=\"post\">\r\n");
      out.write("        \t<input type=\"text\" name=\"searchKeyword\" size=\"25\" placeholder=\"검색할 아이디를 입력해주세요\" value=\"");
      out.print(type!=null&&type.equals("userId")?key:"");
      out.write("\">\r\n");
      out.write("        \t<input type=\"hidden\" name=\"searchType\" value=\"userId\">\r\n");
      out.write("        \t<button type=\"submit\">조회</button>\r\n");
      out.write("        </form>\r\n");
      out.write("        </div>\r\n");
      out.write("            <div id=\"search-userName\">\r\n");
      out.write("        <form action=\"");
      out.print(request.getContextPath() );
      out.write("/admin/searchMemberList\" method=\"post\">\r\n");
      out.write("        \t<input type=\"text\" name=\"searchKeyword\" size=\"25\" placeholder=\"검색할 회원이름를 입력해주세요\" value=\"");
      out.print(type!=null&&type.equals("userName")?key:"");
      out.write("\">\r\n");
      out.write("        \t<input type=\"hidden\" name=\"searchType\" value=\"userName\">\r\n");
      out.write("        \t<button type=\"submit\">조회</button>\r\n");
      out.write("        </form>\r\n");
      out.write("        </div>\r\n");
      out.write("            <div id=\"search-gender\">\r\n");
      out.write("        <form action=\"");
      out.print(request.getContextPath() );
      out.write("/admin/searchMemberList\" method=\"post\">\r\n");
      out.write("        \t<label><input type=\"radio\" name=\"searchKeyword\" value=\"M ");
      out.print(type!=null&&type.equals("gender")&&key.equals("M")?"checked":"");
      out.write("\">남</label>\r\n");
      out.write("        \t<label><input type=\"radio\" name=\"searchKeyword\" value=\"F ");
      out.print(type!=null&&type.equals("gender")&&key.equals("F")?"checked":"");
      out.write("\">여</label>\r\n");
      out.write("        \t<input type=\"hidden\" name=\"searchType\" value=\"gender\">\r\n");
      out.write("        \t<button type=\"submit\">조회</button>\r\n");
      out.write("        </form>\r\n");
      out.write("        </div>\r\n");
      out.write("        </div>\r\n");
      out.write("        <div id=\"numPerpage-container\">\r\n");
      out.write("        \t페이지당 회원수 :\r\n");
      out.write("        \t<form id=\"numPerFrm\" action=\"\">\r\n");
      out.write("        \t\t<select name=\"numPerapge\" id=\"numPerpage\">\r\n");
      out.write("        \t\t\t<option value=\"10\">10</option> \r\n");
      out.write("        \t\t\t<option value=\"5\" selected>5</option> \r\n");
      out.write("        \t\t\t<option value=\"3\">3</option> \r\n");
      out.write("        \t\t</select>\r\n");
      out.write("        \t</form>\r\n");
      out.write("        </div>\r\n");
      out.write("        <table id=\"tbl-member\">\r\n");
      out.write("            <thead>\r\n");
      out.write("                <tr>\r\n");
      out.write("                    <th>아이디</th>\r\n");
      out.write("\t\t    <th>이름</th>\r\n");
      out.write("\t\t    <th>성별</th>\r\n");
      out.write("\t\t    <th>나이</th>\r\n");
      out.write("\t\t    <th>이메일</th>\r\n");
      out.write("\t\t    <th>전화번호</th>\r\n");
      out.write("\t\t    <th>주소</th>\r\n");
      out.write("\t\t    <th>취미</th>\r\n");
      out.write("\t\t    <th>가입날짜</th>\r\n");
      out.write("                </tr>\r\n");
      out.write("            </thead>\r\n");
      out.write("            <tbody>\r\n");
      out.write("            ");
      if (_jspx_meth_c_005fif_005f0(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("            ");
      if (_jspx_meth_c_005fforEach_005f0(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("   \r\n");
      out.write("            </tbody>\r\n");
      out.write("        </table>\r\n");
      out.write("        <div id=\"pageBar\">\r\n");
      out.write("        \t");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pagebar }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("\r\n");
      out.write("        </div>\r\n");
      out.write("    </section>\r\n");
      out.write("    <script>\r\n");
      out.write("  \r\n");
      out.write("    $(\"#numPerpage\").change((e)=>{\r\n");
      out.write("    \tvar numPerpage=$(e.target).val();\r\n");
      out.write("    \tconsole.log($(\"#numPerpage\"));\r\n");
      out.write("    \t $(\"#numPerpage\").children().removeAttr(\"selected\");\r\n");
      out.write("    \t$(e.target).attr(\"selected\",\"selected\");\r\n");
      out.write("    \tlocation.assign('");
      out.print(request.getContextPath());
      out.write("/admin/memberList?numPerpage='+numPerpage);\r\n");
      out.write("    \t\r\n");
      out.write("    });\r\n");
      out.write("   \t\r\n");
      out.write("   \t \r\n");
      out.write("    $(\"#searchType\").change((e)=>{\r\n");
      out.write("    \t let type=$(\"#searchType\").val();\r\n");
      out.write("    \tconsole.log(type);\r\n");
      out.write("    \tif(type==\"userId\"){\r\n");
      out.write("    \t\t$(\"#search-userId\").css(\"display\",\"inline-block\");\r\n");
      out.write("    \t\t$(\"#search-userName\").css(\"display\",\"none\");\r\n");
      out.write("    \t\t$(\"#search-gender\").css(\"display\",\"none\");\t\r\n");
      out.write("    \t}\r\n");
      out.write("    \tif(type==\"userName\"){\r\n");
      out.write("    \t\t$(\"#search-userId\").css(\"display\",\"none\");\r\n");
      out.write("    \t\t$(\"#search-userName\").css(\"display\",\"inline-block\");\r\n");
      out.write("    \t\t$(\"#search-gender\").css(\"display\",\"none\");\t\r\n");
      out.write("    \t}\r\n");
      out.write("       \tif(type==\"gender\"){\r\n");
      out.write("    \t\t$(\"#search-userId\").css(\"display\",\"none\");\r\n");
      out.write("    \t\t$(\"#search-userName\").css(\"display\",\"none\");\r\n");
      out.write("    \t\t$(\"#search-gender\").css(\"display\",\"inline-block\");\t\r\n");
      out.write("    \t}\r\n");
      out.write("    \t\r\n");
      out.write("    })\r\n");
      out.write("    \r\n");
      out.write("    \r\n");
      out.write("    </script>\r\n");
      out.write("    ");
      out.write("\r\n");
      out.write("\t\t<footer>\r\n");
      out.write("\t\t\t<p>&gt;CopyRight 2021. \r\n");
      out.write("\t\t\t<strong>KH정보교육원</strong> \r\n");
      out.write("\t\t\t. All rights reserved.&gt; </p>\r\n");
      out.write("\t\t</footer>\r\n");
      out.write("\t</div>\r\n");
      out.write("</body>\r\n");
      out.write("</html>");
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

  private boolean _jspx_meth_c_005fif_005f0(javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  c:if
    org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_005fif_005f0 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
    boolean _jspx_th_c_005fif_005f0_reused = false;
    try {
      _jspx_th_c_005fif_005f0.setPageContext(_jspx_page_context);
      _jspx_th_c_005fif_005f0.setParent(null);
      // /views/admin/memberList.jsp(85,12) name = test type = boolean reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
      _jspx_th_c_005fif_005f0.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${empty list }", boolean.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null)).booleanValue());
      int _jspx_eval_c_005fif_005f0 = _jspx_th_c_005fif_005f0.doStartTag();
      if (_jspx_eval_c_005fif_005f0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\r\n");
          out.write("            \t<tr>\r\n");
          out.write("    \t\t\t\t<td colspan=\"9\">조회된 회원이 없읍니다</td>\r\n");
          out.write("    \t\t\t</tr>\t\t\r\n");
          out.write("            ");
          int evalDoAfterBody = _jspx_th_c_005fif_005f0.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_c_005fif_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
      _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.reuse(_jspx_th_c_005fif_005f0);
      _jspx_th_c_005fif_005f0_reused = true;
    } finally {
      org.apache.jasper.runtime.JspRuntimeLibrary.releaseTag(_jspx_th_c_005fif_005f0, _jsp_getInstanceManager(), _jspx_th_c_005fif_005f0_reused);
    }
    return false;
  }

  private boolean _jspx_meth_c_005fforEach_005f0(javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  c:forEach
    org.apache.taglibs.standard.tag.rt.core.ForEachTag _jspx_th_c_005fforEach_005f0 = (org.apache.taglibs.standard.tag.rt.core.ForEachTag) _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvar_005fitems.get(org.apache.taglibs.standard.tag.rt.core.ForEachTag.class);
    boolean _jspx_th_c_005fforEach_005f0_reused = false;
    try {
      _jspx_th_c_005fforEach_005f0.setPageContext(_jspx_page_context);
      _jspx_th_c_005fforEach_005f0.setParent(null);
      // /views/admin/memberList.jsp(90,12) name = var type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
      _jspx_th_c_005fforEach_005f0.setVar("m");
      // /views/admin/memberList.jsp(90,12) name = items type = javax.el.ValueExpression reqTime = true required = false fragment = false deferredValue = true expectedTypeName = java.lang.Object deferredMethod = false methodSignature = null
      _jspx_th_c_005fforEach_005f0.setItems(new org.apache.jasper.el.JspValueExpression("/views/admin/memberList.jsp(90,12) '${list }'",_jsp_getExpressionFactory().createValueExpression(_jspx_page_context.getELContext(),"${list }",java.lang.Object.class)).getValue(_jspx_page_context.getELContext()));
      int[] _jspx_push_body_count_c_005fforEach_005f0 = new int[] { 0 };
      try {
        int _jspx_eval_c_005fforEach_005f0 = _jspx_th_c_005fforEach_005f0.doStartTag();
        if (_jspx_eval_c_005fforEach_005f0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
          do {
            out.write("\r\n");
            out.write("            \t<tr>\r\n");
            out.write("    \t\t\t\t <td>");
            out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${m.userid }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
            out.write("</td>\r\n");
            out.write("    \t\t\t\t <td>");
            out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${m.username }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
            out.write("</td>\r\n");
            out.write("    \t\t\t\t <td>");
            out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${m.gender }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
            out.write("</td>\r\n");
            out.write("    \t\t\t\t <td>");
            out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${m.age }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
            out.write("</td>\r\n");
            out.write("    \t\t\t\t <td>");
            out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${m.email }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
            out.write("</td>\r\n");
            out.write("    \t\t\t\t <td>");
            out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${m.phone }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
            out.write("</td>\r\n");
            out.write("    \t\t\t\t \r\n");
            out.write("    \t\t\t\t <td>");
            out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${m.address }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
            out.write("</td>\r\n");
            out.write("    \t\t\t\t <td>");
            out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${m.hobby }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
            out.write("</td>\r\n");
            out.write("    \t\t\t\t <td>");
            out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${m.enrolldate }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
            out.write("</td>\r\n");
            out.write("    \t\t\t\t</tr>\r\n");
            out.write("            ");
            int evalDoAfterBody = _jspx_th_c_005fforEach_005f0.doAfterBody();
            if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
              break;
          } while (true);
        }
        if (_jspx_th_c_005fforEach_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
          return true;
        }
      } catch (java.lang.Throwable _jspx_exception) {
        while (_jspx_push_body_count_c_005fforEach_005f0[0]-- > 0)
          out = _jspx_page_context.popBody();
        _jspx_th_c_005fforEach_005f0.doCatch(_jspx_exception);
      } finally {
        _jspx_th_c_005fforEach_005f0.doFinally();
      }
      _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvar_005fitems.reuse(_jspx_th_c_005fforEach_005f0);
      _jspx_th_c_005fforEach_005f0_reused = true;
    } finally {
      org.apache.jasper.runtime.JspRuntimeLibrary.releaseTag(_jspx_th_c_005fforEach_005f0, _jsp_getInstanceManager(), _jspx_th_c_005fforEach_005f0_reused);
    }
    return false;
  }
}