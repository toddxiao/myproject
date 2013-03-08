/**
 * Description:
 * SpyMemcachedClientTest.java Create on 2013-3-8 上午10:33:34 
 * @author 肖聘   xiaopin@yhiker.com
 * @version 1.0
 * Copyright (c) 2013 Hiker,Inc. All Rights Reserved.
 */
package com.mycompany.myproject.domain;

import java.util.Map;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springside.modules.cache.memcached.SpyMemcachedClient;

import com.google.common.collect.Maps;

/** 
 * @ClassName: SpyMemcachedClientTest 
 * @Description: TODO 
 * @author 肖聘  xiaopin@yhiker.com
 * @date 2013-3-8 上午10:33:34 
 *  
 */
public class SpyMemcachedClientTest {
    
    private SpyMemcachedClient spyMemcachedClient;
    @Before
    public void init() {
        System.setProperty("spring.profiles.active", "development");
        ApplicationContext cxt = new ClassPathXmlApplicationContext("applicationContext.xml");
        spyMemcachedClient = (SpyMemcachedClient)cxt.getBean("spyMemcachedClient");
    }

    @Test
    public void Test() {
        String key="testkey";
        String value="testvalue";
        Map<String,Object> value1 = Maps.newHashMap();
        value1.put("121", value);
        spyMemcachedClient.set(key, 1000*60, value1);
        Object getvalue = spyMemcachedClient.get(key);
        System.out.println(getvalue);
    }
}
