package com.mycompany.myproject.common.memsession;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/** 
* @ClassName: HttpServletRequestWrapper 
* @Description: TODO 
* @author 肖聘  xiaopin@yhiker.com
* @date 2013-3-8 下午1:24:31 
*  
*/ 
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
