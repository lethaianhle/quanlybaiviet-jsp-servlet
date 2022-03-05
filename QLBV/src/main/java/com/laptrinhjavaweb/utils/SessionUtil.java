package com.laptrinhjavaweb.utils;

import javax.servlet.http.HttpServletRequest;

//maintain userloggedIn's information by Session(Util)
//SessionUtil allow u to not create new Session object every time u call it's fuction
public class SessionUtil {
	
	private static SessionUtil sessionUtil = null;
	
	@SuppressWarnings("unused")
	public static SessionUtil getInstance() {
		if(sessionUtil == null) {
			sessionUtil = new SessionUtil();
		}
		return sessionUtil;
	}
	
	//save user loggedIn's information
	public void putValue(HttpServletRequest request, String key, Object value) {
		request.getSession().setAttribute(key, value);
	}
	
	
	//get information user logged in
	public Object getValue(HttpServletRequest request, String key) {
		return request.getSession().getAttribute(key);
	}
	
	// remove => logout
	public void removeValue(HttpServletRequest request, String key) {
		request.getSession().removeAttribute(key);
	}
	
}
