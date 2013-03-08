package com.mycompany.myproject.common.memsession;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class HttpServletRequestWrapper extends
		javax.servlet.http.HttpServletRequestWrapper {

	String sid = "";

	public HttpServletRequestWrapper(String sid, HttpServletRequest request) {
		super(request);
		this.sid = sid;
	}

	public HttpSession getSession(boolean create) {
	    HttpSession session = super.getSession(create);
		return session==null?null:new HttpSessionSidWrapper(this.sid, session);
	}

	public HttpSession getSession() {
	    HttpSession session = super.getSession();
	    return session==null?null:new HttpSessionSidWrapper(this.sid, session);
	}

}
