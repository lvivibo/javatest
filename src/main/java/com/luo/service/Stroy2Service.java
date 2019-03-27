package com.luo.service;

import java.util.LinkedHashMap;
import java.util.Map;

import com.luo.core.Cache;
import com.luo.rules.LMERule;
import com.luo.rules.PrimeRule;
import com.luo.rules.Rule;

public class Stroy2Service implements Service{
	
	
	final static String PRIME="PRIME";
	final static String LME="LME";
	 public Map<String,String> LME_RESULT;
	public Map<String,String> PRIME_RESULT;	
	Cache cache = Cache.getInstance();
	public void publish(String instrument) {
		Map<String,String> LME_params = new LinkedHashMap<String,String>();
		LME_params.put("LAST_TRADING_DATE", "15-03-2018");
		LME_params.put("DELIVERY_DATE", "17-03-2018");
		LME_params.put("MARKET", "LME_PB");
		LME_params.put("LABEL", "Lead 13 March 2018");
		Rule rule1 = new LMERule();
		System.out.println("LME:");
		System.out.println("Input Data:");
		display(LME_params);
		System.out.println("Output Data:");	
		
		
		LME_RESULT = rule1.createRule("PB_03_2018", LME_params);
		if (cache.getSession(PRIME+instrument)!=null) {
			LME_RESULT.put("TRADABLE", "FALSE");
		}
		
		display(LME_RESULT);
		Rule rule2 = new PrimeRule();
		Map<String,String> Prime_params = new LinkedHashMap<String,String>();
		Prime_params.put("LAST_TRADING_DATE", "14-03-2018");
		Prime_params.put("DELIVERY_DATE", "18-03-2018");
		Prime_params.put("MARKET", "LME_PB");
		Prime_params.put("LABEL", "Lead 13 March 2018");
		Prime_params.put("EXCHANGE_CODE","PB_03_2018");
		Prime_params.put("TRADABLE","FALSE");
		System.out.println("PRIME:");
		System.out.println("Input Data:");
		display(Prime_params);
		System.out.println("Output Data:");	
		if (cache.getSession(LME+instrument)!=null) {
			Prime_params.put("LAST_TRADING_DATE",cache.getSession(LME+instrument).get("LAST_TRADING_DATE"));
			Prime_params.put("DELIVERY_DATE", cache.getSession(LME+instrument).get("DELIVERY_DATE"));
			
		}
		PRIME_RESULT=rule2.createRule(instrument, Prime_params);
		display(rule2.createRule(instrument, Prime_params));
		
	}
	 private void  display(Map<String,String> params) {
		  String k = "|";
		  String v= "|";

		  for (Map.Entry<String,String> entry : params.entrySet()) { 
			  k =k+entry.getKey()+"|"; 
			  v =v+entry.getValue()+"|";
		  }
		  	  System.out.println(k);
			  System.out.println(v);

		}
	
}
