package com.laptrinhjavaweb.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.laptrinhjavaweb.model.UserModel;
import com.laptrinhjavaweb.utils.SessionUtil;

public class AuthorizationFilter implements Filter {
	
	private ServletContext context;

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		this.context = filterConfig.getServletContext();
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest httpServletRequest = (HttpServletRequest) request;
		HttpServletResponse httpServletResponse = (HttpServletResponse) response;
		String url = httpServletRequest.getRequestURI();
		if(url.contains("/admin/")) {
			UserModel userLoggedIn = (UserModel) SessionUtil.getInstance().getValue(httpServletRequest, "userLoggedIn");
			if(userLoggedIn != null) {
				if(userLoggedIn.getRole().getRoleCode().equals("USER")) {
					httpServletResponse.sendRedirect(httpServletRequest.getContextPath() + "/login?action=login&message=notPermission");
				} else if(userLoggedIn.getRole().getRoleCode().equals("ADMIN")) {
					chain.doFilter(request, response);
				}
				
			} else {
				httpServletResponse.sendRedirect(httpServletRequest.getContextPath() + "/login?action=login&message=notLoggedIn");
			}
			
		} else {
			chain.doFilter(request, response);
		}
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

}
