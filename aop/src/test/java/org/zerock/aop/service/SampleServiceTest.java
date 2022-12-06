package org.zerock.aop.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"file:src/main/webapp/WEB-INF/spring/**/root-context.xml"})
@Log4j
public class SampleServiceTest {
	@Autowired
	SampleService sampleService;
	
	@Test
	public void testClass() {
		System.out.println(sampleService);
		System.out.println(sampleService.getClass().getName());
	}
	
	@Test
	public void testAdd() throws Exception {
		log.info(sampleService.doAdd("123", "456"));
	}
	
	@Test(expected = Throwable.class)
	public void testAddError() throws Exception {
		//고의 예외 발생
		log.info(sampleService.doAdd("123", "ABC"));
	}
}
