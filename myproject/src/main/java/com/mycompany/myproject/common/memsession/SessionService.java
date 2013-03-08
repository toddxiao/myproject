package com.mycompany.myproject.common.memsession;

import java.util.HashMap;
import java.util.Map;

import org.springside.modules.cache.memcached.SpyMemcachedClient;

import com.mycompany.myproject.common.context.SpringContextHolder;

/**
 * @ClassName: SessionService
 * @Description: TODO
 * @author 肖聘 xiaopin@yhiker.com
 * @date 2013-3-8 下午1:25:02
 * 
 */
public class SessionService {

    private static SessionService instance = new SessionService();

    private SpyMemcachedClient spyMemcachedClient;

    public static synchronized SessionService getInstance() {
        return instance;
    }

    private SessionService() {
        spyMemcachedClient = SpringContextHolder.getBean("spyMemcachedClient");
    }

    public Map<String, Object> getSession(String id) {

        Map<String, Object> session = spyMemcachedClient.get(id);
        if (session == null) {
            session = new HashMap<String, Object>();
            spyMemcachedClient.set(id, 60 * 60 * 24, session);
        }
        return session;
    }

    public void saveSession(String id, Map<String, Object> session) {
        spyMemcachedClient.set(id, 60 * 60 * 24, session);
    }

    public void removeSession(String id) {
        spyMemcachedClient.delete(id);
    }

}
