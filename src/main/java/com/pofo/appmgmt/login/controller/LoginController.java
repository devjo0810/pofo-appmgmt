package com.pofo.appmgmt.login.controller;

import javax.validation.Valid;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pofo.appmgmt.common.model.ApiResponseModel;
import com.pofo.appmgmt.common.model.UserModel;
import com.pofo.appmgmt.common.type.ResponseType;
import com.pofo.appmgmt.login.dto.request.LoginRequestDto;
import com.pofo.appmgmt.login.dto.request.SignupRequestDto;
import com.pofo.appmgmt.login.service.LoginService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/app")
@RequiredArgsConstructor
public class LoginController {

	private final LoginService loginService;
	
	@PostMapping("/login")
	public ApiResponseModel<UserModel> login(@Valid @RequestBody final LoginRequestDto params) {
		UserModel userModel = loginService.login(params);
		
		ApiResponseModel<UserModel> apiResponse = new ApiResponseModel<UserModel>()
				.setStatus(ResponseType.SUCCESS.code())
				.setResult(userModel);
		return apiResponse;
	}
	
	@SuppressWarnings("rawtypes")
	@PostMapping("/signup")
	public ApiResponseModel signup(@Valid @RequestBody final SignupRequestDto params) {
		loginService.signup(params);
		
		ApiResponseModel apiResponse = new ApiResponseModel()
				.setStatus(ResponseType.SUCCESS.code());
		
		return apiResponse;
	}
	
}
