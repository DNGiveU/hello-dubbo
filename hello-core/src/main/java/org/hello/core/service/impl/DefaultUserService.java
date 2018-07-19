package org.hello.core.service.impl;

import java.time.LocalDateTime;

import org.hello.api.domain.User;
import org.hello.api.service.UserService;
import org.hello.core.dao.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author: hanqiang
 * @Date: 2018年7月17日
 */
@Service("userService")
public class DefaultUserService implements UserService {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(DefaultUserService.class);
	
	@Autowired
	private UserRepository userRepository;

	@Override
	public User getById(String id) {
		User user = userRepository.getById(id);
		LOGGER.info(user.toString());
		return user;
	}

	@Override
	public void create(User user) {
		user.setCreatedTime(LocalDateTime.now());
		userRepository.create(user);
		LOGGER.info(user.toString());
	}
}
