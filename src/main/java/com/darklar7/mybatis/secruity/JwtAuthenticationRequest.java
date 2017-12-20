package com.darklar7.mybatis.secruity;

import lombok.Data;

import java.io.Serializable;

/**
 * @author xiaojunli
 * @date 2017/12/20
 */
@Data
public class JwtAuthenticationRequest implements Serializable{

	private static final long serialVersionUID = -8445943548965154778L;

	private String username;
	private String password;


}
