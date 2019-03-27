package com.luo.rules;


import java.util.LinkedHashMap;
import java.util.Map;

import com.luo.core.Cache;

public class LMERule implements Rule{
	Cache cache = Cache.getInstance();
	final static String LME ="LME";
	Map<String,String> result= new LinkedHashMap<String,String>(); 
	@Override
	public Map<String,String> createRule(String instrument,Map<String,String> params) {
		
		
		result.putAll(params);
		result.put("TRADABLE", "TRUE");	
		cache.putSession(LME+instrument, result);
		return result;
	}

	
}
