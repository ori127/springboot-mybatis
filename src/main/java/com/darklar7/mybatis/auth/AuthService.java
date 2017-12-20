package com.darklar7.mybatis.auth;

import com.darklar7.mybatis.model.User;

/**
 * @author xiaojunli
 * @date 2017/12/20
 */
public interface AuthService {
	User register(User userToAdd);
	String login(String username, String password);
	String refresh(String oldToken);
}
