package org.hello.core.service.impl;

import org.hello.api.domain.User;
import org.hello.api.service.HelloService;
import org.hello.api.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author: hanqiang
 * @Date: 2018年7月17日
 */
@Service("helloService")
public class DefaultHelloService implements HelloService {
	
	@Autowired
	private UserService userService;

	@Override
	public String sayHello(String userId) {
		User user = userService.getById(userId);
		return String.format("Hello, %s.", user.getName());
	}
}
