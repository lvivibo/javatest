package com.luo.rules;

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

public class PrimeRuleTest {
	Cache cache = Cache.getInstance();
	PrimeRule rule = null;
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		rule = new PrimeRule();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public final void testcreateRule() {
		Map<String,String> params1 = new LinkedHashMap<String,String>();
		params1.put("LAST_TRADING_DATE", "14-03-2018");
		params1.put("DELIVERY_DATE", "18-03-2018");
		params1.put("MARKET", "LME_PB");
		params1.put("LABEL", "Lead 13 March 2018");	
		params1.put("TRADABLE","FALSE");
		Map<String,String> result = rule.createRule("PB_03_2018", params1);
	    assertNotNull(result);
		assertThat(result,hasEntry("LAST_TRADING_DATE", "14-03-2018"));
		assertThat(result,hasEntry("DELIVERY_DATE", "18-03-2018"));
		assertThat(result,hasEntry("MARKET", "LME_PB"));
		assertThat(result,hasEntry("LABEL", "Lead 13 March 2018"));
		assertThat(result,hasEntry("TRADABLE", "FALSE"));
	}

}
