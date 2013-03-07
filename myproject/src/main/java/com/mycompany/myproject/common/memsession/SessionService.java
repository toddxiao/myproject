package com.mycompany.myproject.common.memsession;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.springside.modules.cache.memcached.SpyMemcachedClient;

public class SessionService {

	private static SessionService instance = null;

	@Resource
	private SpyMemcachedClient spyMemcachedClient;

	private String poolName = "sidsock";

	public static synchronized SessionService getInstance() {
		if (instance == null) {
			instance = new SessionService();
		}
		return instance;
	}

	private SessionService() {
		
	}

	public Map getSession(String id) {

		Map session = (Map) spyMemcachedClient.get(id);
		if (session == null) {
			session = new HashMap();
			spyMemcachedClient.safeSet(id, 1000000, session);
		}
		return session;
	}

	public void saveSession(String id, Map session) {
		spyMemcachedClient.safeSet(id, 1000000, session);
	}

	public void removeSession(String id) {
		spyMemcachedClient.delete(id);
	}


}
