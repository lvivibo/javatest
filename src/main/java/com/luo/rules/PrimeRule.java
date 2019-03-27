package com.luo.rules;


import java.util.LinkedHashMap;
import java.util.Map;

import com.luo.core.Cache;

public class PrimeRule implements Rule {
	Cache cache = Cache.getInstance();
	final static String PRIME ="PRIME";
	Map<String,String> result= new LinkedHashMap<String,String>();
	//final static String LME ="LME";
	@Override
	public Map<String, String> createRule(String instrument,Map<String, String> params) {
		params.remove("EXCHANGE_CODE","PB_03_2018");
		cache.putSession(PRIME+instrument,params);
		result.putAll(params);
		return result;
	}
	
}
