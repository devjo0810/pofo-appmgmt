package com.pofo.appmgmt.domain.user.api;

import javax.validation.Valid;

import com.pofo.appmgmt.domain.user.dto.SignupRequest;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pofo.appmgmt.global.dto.ApiResponse;
import com.pofo.appmgmt.domain.user.domain.UserVO;
import com.pofo.appmgmt.global.type.ResponseType;
import com.pofo.appmgmt.domain.user.dto.LoginRequest;
import com.pofo.appmgmt.domain.user.biz.LoginService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/app")
@RequiredArgsConstructor
public class LoginApi {

	private final LoginService loginService;
	
	@PostMapping("/login")
	public ApiResponse<UserVO> login(@Valid @RequestBody final LoginRequest params) {
		UserVO user = loginService.login(params);
		
		ApiResponse<UserVO> apiResponse = new ApiResponse<UserVO>()
				.setStatus(ResponseType.SUCCESS.code())
				.setResult(user);
		return apiResponse;
	}
	
	@SuppressWarnings("rawtypes")
	@PostMapping("/signup")
	public ApiResponse signup(@Valid @RequestBody final SignupRequest params) {
		loginService.signup(params);
		
		ApiResponse apiResponse = new ApiResponse()
				.setStatus(ResponseType.SUCCESS.code());
		
		return apiResponse;
	}
	
}
