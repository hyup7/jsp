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
 * Servlet Filter implementation class AdminCheckFIlter
 */
@WebFilter("/admin/*")
public class AdminCheckFIlter implements Filter {

    /**
     * Default constructor. 
     */
    public AdminCheckFIlter() {
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
		HttpSession sesion=((HttpServletRequest)request).getSession();
		Member m=(Member)sesion.getAttribute("loginMember");
		if(m==null||!m.getUserId().equals("admin")) {
			request.setAttribute("msg", "잘못된 접근입니다. 관리자에게 문의하세요");
			request.setAttribute("loc", "/");
			request.getRequestDispatcher("/views/common/msg.jsp").forward(request, response);
		}else {
			
			chain.doFilter(request, response);
		}
		// pass the request along the filter chain
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
