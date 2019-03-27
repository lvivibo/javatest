package com.luo.service;

import static org.junit.Assert.*;
import static org.hamcrest.Matchers.*;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.luo.core.Cache;
import com.luo.rules.LMERule;
import com.luo.rules.Rule;

public class Stroy1ServiceTest {
	Stroy1Service service = null;
	Cache cache = Cache.getInstance();
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		service=new Stroy1Service();
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
		assertThat(result,hasEntry("TRADABLE", "TRUE"));	
		
        
	
	
	}

}
