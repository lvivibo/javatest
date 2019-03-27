package com.luo.service;

import static org.hamcrest.Matchers.hasEntry;
import static org.junit.Assert.*;

import java.util.LinkedHashMap;
import java.util.Map;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.luo.core.Cache;
import com.luo.rules.LMERule;
import com.luo.rules.PrimeRule;
import com.luo.rules.Rule;

public class Stroy2ServiceTest {
	final static String PRIME="PRIME";
	final static String LME="LME";
	Stroy2Service service=null;
	Cache cache = Cache.getInstance();
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		service = new Stroy2Service();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public final void testPublish() {
		
		service.publish("PB_03_2018");
    	Map<String,String> result = service.LME_RESULT;
	    assertNotNull(result);
		assertThat(result,hasEntry("LAST_TRADING_DATE", "15-03-2018"));
		assertThat(result,hasEntry("DELIVERY_DATE", "17-03-2018"));
		assertThat(result,hasEntry("MARKET", "LME_PB"));
		assertThat(result,hasEntry("LABEL", "Lead 13 March 2018"));
		if(cache.getSession(PRIME+"PB_03_2018")!=null) {
			assertThat(result,hasEntry("TRADABLE", "FALSE"));
		}else {
			assertThat(result,hasEntry("TRADABLE", "TRUE"));
		}
			
		
		
		Map<String,String>  result1=service.PRIME_RESULT;
		assertNotNull(result1);
		if(cache.getSession(LME+"PB_03_2018")!=null) {
			assertThat(result1,hasEntry("LAST_TRADING_DATE", "15-03-2018"));
			assertThat(result1,hasEntry("DELIVERY_DATE", "17-03-2018"));
		}else {
			assertThat(result1,hasEntry("LAST_TRADING_DATE", "14-03-2018"));
			assertThat(result1,hasEntry("DELIVERY_DATE", "18-03-2018"));
		}
		
		assertThat(result1,hasEntry("MARKET", "LME_PB"));
		assertThat(result1,hasEntry("LABEL", "Lead 13 March 2018"));
		assertThat(result1,hasEntry("TRADABLE", "FALSE"));
	}

}
