package com.luo.service;

import java.util.LinkedHashMap;
import java.util.Map;

import com.luo.rules.LMERule;
import com.luo.rules.Rule;

public class Stroy1Service implements Service{
	Map<String,String> LME_RESULT;
	public void publish(String instrument) {
		Map<String,String> params1 = new LinkedHashMap<String,String>();
		params1.put("LAST_TRADING_DATE", "15-03-2018");
		params1.put("DELIVERY_DATE", "17-03-2018");
		params1.put("MARKET", "LME_PB");
		params1.put("LABEL", "Lead 13 March 2018");
		Rule rule1=new LMERule();
		System.out.println("Input data:");
		display(params1);
		System.out.println("Output data:");
		LME_RESULT = rule1.createRule(instrument, params1);
		display(LME_RESULT);
		
		
		
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
