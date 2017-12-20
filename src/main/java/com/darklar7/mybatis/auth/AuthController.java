package com.darklar7.mybatis.auth;

import com.darklar7.mybatis.model.User;
import com.darklar7.mybatis.secruity.JwtAuthenticationRequest;
import com.darklar7.mybatis.secruity.JwtAuthenticationResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * @author xiaojunli
 * @date 2017/12/20
 */
@RestController
public class AuthController {
	@Value("${jwt.header}")
	private String tokenHeader;

	@Autowired
	private AuthService authService;

	@PostMapping("/auth")
	public ResponseEntity<?> createAuthenticationToken(
			@RequestBody JwtAuthenticationRequest authenticationRequest) throws AuthenticationException {
		final String token = authService.login(authenticationRequest.getUsername(), authenticationRequest.getPassword());

		// Return the token
		return ResponseEntity.ok(new JwtAuthenticationResponse(token));
	}

	@GetMapping("/auth/refresh")
	public ResponseEntity<?> refreshAndGetAuthenticationToken(
			HttpServletRequest request) throws AuthenticationException{
		String token = request.getHeader(tokenHeader);
		String refreshedToken = authService.refresh(token);
		if(refreshedToken == null) {
			return ResponseEntity.badRequest().body(null);
		} else {
			return ResponseEntity.ok(new JwtAuthenticationResponse(refreshedToken));
		}
	}

	@PostMapping("/auth/register")
	public User register(@RequestBody User addedUser) throws AuthenticationException{
		return authService.register(addedUser);
	}

}
