package org.hello.core.dao.impl;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import org.hello.api.domain.User;
import org.hello.core.dao.UserRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author: hanqiang
 * @Date: 2018年7月17日
 */
@Repository("userRepository")
public class InMemoryUserRepository implements UserRepository {
	
	private static final Map<String, User> STORE = new HashMap<>();
	
	static {
		User user = new User();
		user.setId("tom");
		user.setName("Tom Sawyer");
		user.setCreatedTime(LocalDateTime.now());
		STORE.put(user.getId(), user);
	}

	@Override
	public User getById(String id) {
		return STORE.get(id);
	}

	@Override
	public void create(User user) {
		STORE.put(user.getId(), user);
	}
}
