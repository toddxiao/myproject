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

	public Object getAttribute(String name) {
		return this.session.getAttribute(name);
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
    public Object getValue(String name) {
		return session.getValue(name);
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
    public void putValue(String name, Object value) {
		session.putValue(name, value);
	}

	public void removeAttribute(String name) {
		this.session.removeAttribute(name);
	}

	@Deprecated
    public void removeValue(String name) {
		session.removeValue(name);
	}

	public void setAttribute(String name, Object value) {
		this.session.setAttribute(name, value);
	}

	public void setMaxInactiveInterval(int interval) {
		session.setMaxInactiveInterval(interval);
	}

}
