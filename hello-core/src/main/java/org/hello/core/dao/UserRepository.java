package org.hello.core.dao;

import org.hello.api.domain.User;

/**
 *
 * @author: hanqiang
 * @Date: 2018年7月17日
 */
public interface UserRepository {

	User getById(String id);
	
	void create(User user);
}
