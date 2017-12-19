package com.darklar7.mybatis.controller;

import com.darklar7.mybatis.model.User;
import com.darklar7.mybatis.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author xiaojunli
 * @date 2017/12/19
 */
@RestController
public class UserController {

	@Autowired
	private UserService userService;

	@PostMapping("user")
	public User addUser(@RequestBody User user){
		return userService.save(user);
	}
}
