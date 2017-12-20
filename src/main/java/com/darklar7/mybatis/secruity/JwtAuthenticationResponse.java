package com.darklar7.mybatis.secruity;

import lombok.Data;

import java.io.Serializable;

/**
 * @author xiaojunli
 * @date 2017/12/20
 */
@Data
public class JwtAuthenticationResponse implements Serializable{
	private static final long serialVersionUID = 1250166508152483573L;

	private final String token;
}
