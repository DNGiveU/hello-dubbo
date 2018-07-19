package org.hello.core;

import org.hello.api.service.UserService;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import org.hello.core.ApplicationConfig;

public class ApplicationTest {
   
	@Test
	public void testApplicationCotnext() {
		AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(ApplicationConfig.class);
		UserService userService = applicationContext.getBean(UserService.class);
	}
}
