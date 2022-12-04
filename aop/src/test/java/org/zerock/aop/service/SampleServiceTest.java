package org.zerock.aop.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"file:src/main/webapp/WEB-INF/spring/**/root-context.xml"})
public class SampleServiceTest {
	@Autowired
	SampleService sampleService;
	
	@Test
	public void testClass() {
		System.out.println(sampleService);
		System.out.println(sampleService.getClass().getName());
	}
}
