package com.darklar7.mybatis.auth;

import com.darklar7.mybatis.mapper.UserMapper;
import com.darklar7.mybatis.model.User;
import com.darklar7.mybatis.secruity.JwtTokenUtil;
import com.darklar7.mybatis.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import static java.util.Arrays.asList;

/**
 * @author xiaojunli
 * @date 2017/12/20
 */
@Service
public class AuthServiceImpl implements AuthService{

	private AuthenticationManager authenticationManager;
	private UserDetailsService userDetailsService;
	private JwtTokenUtil jwtTokenUtil;
	private UserService userService;
	private UserMapper userMapper;

	@Value("${jwt.tokenHead}")
	private String tokenHead;

	@Autowired
	public AuthServiceImpl(
			AuthenticationManager authenticationManager,
			UserDetailsService userDetailsService,
			JwtTokenUtil jwtTokenUtil,
			UserService userService,
			UserMapper userMapper) {
		this.authenticationManager = authenticationManager;
		this.userDetailsService = userDetailsService;
		this.jwtTokenUtil = jwtTokenUtil;
		this.userService = userService;
		this.userMapper = userMapper;
	}

	@Override
	public User register(User userToAdd) {
		final String username = userToAdd.getUsername();
		if(userMapper.findByUsername(username)!=null) {
			return null;
		}
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		final String rawPassword = userToAdd.getPassword();
		userToAdd.setPassword(encoder.encode(rawPassword));
		userToAdd.setRoles(asList("ROLE_USER"));
		return userService.save(userToAdd);
	}

	@Override
	public String login(String username, String password) {
		UsernamePasswordAuthenticationToken upToken = new UsernamePasswordAuthenticationToken(username, password);
		// Perform the security
		final Authentication authentication = authenticationManager.authenticate(upToken);
		SecurityContextHolder.getContext().setAuthentication(authentication);

		// Reload password post-security so we can generate token
		final UserDetails userDetails = userDetailsService.loadUserByUsername(username);
		final String token = jwtTokenUtil.generateToken(userDetails);
		return token;
	}

	@Override
	public String refresh(String oldToken) {
		return null;
	}
}
