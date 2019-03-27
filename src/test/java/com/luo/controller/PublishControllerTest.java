package com.luo.controller;

import static org.hamcrest.Matchers.hasEntry;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class PublishControllerTest {
	
	PublishController controller = null;
	@Before
	public void setUp() throws Exception {
		controller = new PublishController();
	}

	@Test
	public void testPublish() {
		int result=controller.publish("story1");
		//assertNotNull(result);
		assertEquals(1,result);
		 result=controller.publish("story2");
		//assertNotNull(result);
		assertEquals(2,result);
		result=controller.publish("end");
		assertEquals(0,result);
	}

}
