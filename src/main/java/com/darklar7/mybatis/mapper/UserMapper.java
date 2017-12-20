package com.darklar7.mybatis.mapper;

import com.darklar7.mybatis.model.User;
import com.darklar7.mybatis.utils.MyMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

@Mapper
@Component
public interface UserMapper extends MyMapper<User> {
	/**
	 * 根据用户名获取单个用户信息
	 * @param username
	 * @return
	 */
	User findByUsername(String username);
}