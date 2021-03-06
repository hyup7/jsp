package com.common.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.member.model.vo.Member;

/**
 * Servlet Filter implementation class LoginCheckFilter
 */
@WebFilter(urlPatterns = {"/memberView.do","/updateMember"})
public class LoignCheckFilter implements Filter {

    /**
     * Default constructor. 
     */
    public LoignCheckFilter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		// place your code here
		//로그인여부를 확인하는 filter 로그인을 했으면 정상적으로 서비스를 실행하고
		//로그인이 안된상태면 접근 금지시킴
		HttpSession session=((HttpServletRequest)request).getSession();
		String userId=request.getParameter("userId");
		Member m=(Member)session.getAttribute("loginMember");
		if(m==null||!m.getUserId().equals(userId)) {
			//로그인 하지 않았으면.......
			request.setAttribute("msg", "잘못된 접근입니다. 로그인 후 이용할 수 있는 서비스입니다.");
			request.setAttribute("loc","/");
			request.getRequestDispatcher("/views/common/msg.jsp")
			.forward(request, response);
		}else {
		
			// pass the request along the filter chain
			chain.doFilter(request, response);
		}
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}

