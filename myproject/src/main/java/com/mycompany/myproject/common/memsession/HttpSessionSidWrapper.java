package com.mycompany.myproject.common.memsession;

import java.util.Collections;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpSession;

/** 
* @ClassName: HttpSessionSidWrapper 
* @Description: TODO 
* @author 肖聘  xiaopin@yhiker.com
* @date 2013-3-8 下午1:24:49 
*  
*/ 
public class HttpSessionSidWrapper extends HttpSessionWrapper {

    private String sid = "";

    private Map<String, Object> map = null;

    public HttpSessionSidWrapper(String sid, HttpSession session) {
        super(session);
        this.sid = sid;
        this.map = SessionService.getInstance().getSession(sid);
    }

    public Object getAttribute(String arg0) {
        return this.map.get(arg0);
    }

    public Enumeration<?> getAttributeNames() {
        Set<String> keyNames = new HashSet<String>(map.size());
        keyNames = new HashSet<String>(map.size());
        for (String o : map.keySet()) {
            keyNames.add(o);
        }
        return Collections.enumeration(keyNames); 
    }

    public void invalidate() {
        this.map.clear();
        SessionService.getInstance().removeSession(this.sid);
    }

    public void removeAttribute(String arg0) {
        this.map.remove(arg0);
        SessionService.getInstance().saveSession(this.sid, this.map);
    }

    public void setAttribute(String arg0, Object arg1) {
        this.map.put(arg0, arg1);
        SessionService.getInstance().saveSession(this.sid, this.map);
    }
}
