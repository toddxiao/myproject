package com.mycompany.myproject.common.memsession;

import java.util.Enumeration;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionContext;

/** 
* @ClassName: HttpSessionWrapper 
* @Description: TODO 
* @author 肖聘  xiaopin@yhiker.com
* @date 2013-3-8 下午1:24:54 
*  
*/ 
@SuppressWarnings("deprecation")
public class HttpSessionWrapper implements HttpSession {

	private HttpSession session;

	public HttpSessionWrapper(HttpSession session) {
		this.session = session;
	}

	public Object getAttribute(String arg0) {
		return this.session.getAttribute(arg0);
	}

	public Enumeration<?> getAttributeNames() {
		return this.session.getAttributeNames();
	}

	public long getCreationTime() {
		return session.getCreationTime();
	}

	public String getId() {
		return session.getId();
	}

	public long getLastAccessedTime() {
		return session.getLastAccessedTime();
	}

	public int getMaxInactiveInterval() {
		return session.getMaxInactiveInterval();
	}

	public ServletContext getServletContext() {
		return session.getServletContext();
	}

	@Deprecated
    public HttpSessionContext getSessionContext() {
		return session.getSessionContext();
	}

	@Deprecated
    public Object getValue(String arg0) {
		return session.getValue(arg0);
	}

    @Deprecated
    public String[] getValueNames() {
		return session.getValueNames();
	}

	public void invalidate() {
		this.session.invalidate();
	}

	public boolean isNew() {
		return session.isNew();
	}

	@Deprecated
    public void putValue(String arg0, Object arg1) {
		session.putValue(arg0, arg1);
	}

	public void removeAttribute(String arg0) {
		this.session.removeAttribute(arg0);
	}

	@Deprecated
    public void removeValue(String arg0) {
		session.removeValue(arg0);
	}

	public void setAttribute(String arg0, Object arg1) {
		this.session.setAttribute(arg0, arg1);
	}

	public void setMaxInactiveInterval(int arg0) {
		session.setMaxInactiveInterval(arg0);
	}

}
