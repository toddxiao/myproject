package com.mycompany.myproject.common.memsession;

import java.util.HashMap;
import java.util.Map;

import org.springside.modules.cache.memcached.SpyMemcachedClient;

import com.mycompany.myproject.common.context.SpringContextHolder;

public class SessionService {

	private static SessionService instance = null;

	private SpyMemcachedClient spyMemcachedClient;


	public static synchronized SessionService getInstance() {
		if (instance == null) {
			instance = new SessionService();
		}
		return instance;
	}

	private SessionService() {
	    spyMemcachedClient = SpringContextHolder.getBean("spyMemcachedClient");
	}

	@SuppressWarnings("rawtypes")
	public Map getSession(String id) {

		Map session = (Map) spyMemcachedClient.get(id);
		if (session == null) {
			session = new HashMap();
			spyMemcachedClient.set(id, 1000*60, session);
		}
		return session;
	}

	@SuppressWarnings("rawtypes")
	public void saveSession(String id, Map session) {
		spyMemcachedClient.set(id, 1000*60, session);
	}

	public void removeSession(String id) {
		spyMemcachedClient.delete(id);
	}


}
