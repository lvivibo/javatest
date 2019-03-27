package com.luo.core;


import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Cache {
	private static Cache cache = new Cache();
	public static Cache getInstance() {
		return cache;
	}
	private  Map<String, Map<String,String>> sessionMap = new ConcurrentHashMap<String, Map<String,String>>();
	
	public Map<String,String> getSession(String instrumentId) {
		return sessionMap.get(instrumentId);
	}
	
	public Map<String,String> putSession(String instrumentId, Map<String,String> session) {
		return sessionMap.put(instrumentId, session);
	}
}