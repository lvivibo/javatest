package com.luo.rules;


import java.util.Map;

public interface Rule {
	///Map<String,String> result= new LinkedHashMap<String,String>();
	
	Map<String,String> createRule(String instrument,Map<String,String> params);
		
}
