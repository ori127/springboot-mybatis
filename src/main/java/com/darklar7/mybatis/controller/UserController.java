package com.darklar7.mybatis.controller;

import com.darklar7.mybatis.model.User;
import com.darklar7.mybatis.service.UserService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author xiaojunli
 * @date 2017/12/19
 */
@RestController
@PreAuthorize("hasRole('ROLE_USER')")
public class UserController {

	@Autowired
	private UserService userService;

	@PostMapping("user")
	public User addUser(@RequestBody User user){
		return userService.save(user);
	}

	@GetMapping("user")
	public PageInfo<User> getAll(){
		PageHelper.startPage(2,5);
		List<User> list = userService.getAll();
		return new PageInfo<>(list);
	}
}
