package com.mycompany.myproject.common.memsession;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class HttpServletRequestWrapper extends
		javax.servlet.http.HttpServletRequestWrapper {

	String sid = "";

	public HttpServletRequestWrapper(String sid, HttpServletRequest arg0) {
		super(arg0);
		this.sid = sid;
	}

	public HttpSession getSession(boolean create) {
		return new HttpSessionSidWrapper(this.sid, super.getSession(create));
	}

	public HttpSession getSession() {
		return new HttpSessionSidWrapper(this.sid, super.getSession());
	}

}
