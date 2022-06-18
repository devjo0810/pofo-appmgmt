package com.pofo.appmgmt.login.service;

import javax.validation.Valid;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import com.pofo.appmgmt.common.model.UserModel;
import com.pofo.appmgmt.login.mapper.LoginMapper;
import com.pofo.appmgmt.login.model.LoginModel;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
@RequiredArgsConstructor
public class LoginService {
	
	private final RedisTemplate redisTemplate;
	
	private final LoginMapper mapper;

	public UserModel login(LoginModel model) {
		return mapper.login(model);
	}
}
