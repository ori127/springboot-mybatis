package com.darklar7.mybatis.secruity;

import com.darklar7.mybatis.model.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author xiaojunli
 * @date 2017/12/19
 */
public class JwtUserFactory {
	private JwtUserFactory() {
	}

	public static JwtUser create(User user) {
		return new JwtUser(
				user.getId(),
				user.getUsername(),
				user.getPassword(),
				mapToGrantedAuthorities(user.getRoles())
		);
	}

	private static List<GrantedAuthority> mapToGrantedAuthorities(List<String> authorities) {
		return authorities.stream()
				.map(SimpleGrantedAuthority::new)
				.collect(Collectors.toList());
	}
}
