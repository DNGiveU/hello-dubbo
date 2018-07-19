package org.hello.api.service;

import org.hello.api.domain.User;

/**
 *
 * @author: hanqiang
 * @Date: 2018年7月17日
 */
public interface UserService {

	User getById(String id);
	
	void create(User user);
}
