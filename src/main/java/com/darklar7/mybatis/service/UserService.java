package com.darklar7.mybatis.service;

import com.darklar7.mybatis.mapper.UserMapper;
import com.darklar7.mybatis.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author xiaojunli
 * @date 2017/12/19
 */
@Service
public class UserService {

	@Autowired
	private UserMapper userMapper;

	public User save(User user){
		userMapper.insert(user);
		return user;
	}
}
